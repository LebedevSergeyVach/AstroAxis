package astro.axis.planet.libgdx.development;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import astro.axis.planet.libgdx.R;
import astro.axis.planet.libgdx.activity.MainMenuActivity;

import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;


@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 500;
    // Диалоговое окно для разметки спиннера
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

//        new Handler().postDelayed(() -> {
//            // После задержки перенаправляем на главную активность
//            Intent intent = new Intent(SplashScreenActivity.this, MainMenuActivity.class);
//            startActivity(intent);
//            finish();
//        }, SPLASH_DELAY);

        new Thread(() -> runOnUiThread(() -> {
            // Отображение спиннера загрузки
            progressDialog = new ProgressDialog(SplashScreenActivity.this, R.style.CustomProgressDialog);
            // Указывает, можно ли отменить этот диалог с помощью клавиши BACK.
            progressDialog.setCancelable(false);
            progressDialog.show();
        })).start();

        new Thread(() -> {
            try {
                startActivity(new Intent(SplashScreenActivity.this, MainMenuActivity.class));
            } catch (ActivityNotFoundException e) {
                // Выкидывает на главную активность приложения и выводит тостер
                runOnUiThread(() -> exitMainMenuActivity(1));
            } catch (RejectedExecutionException e) {
                runOnUiThread(() -> {
                    Toast.makeText(SplashScreenActivity.this, getString(R.string.error_loading_model), R.style.AlertDialogCustom).show();
                    throw new RuntimeException(e);
                });
            }
        }).start();

    }

    private void exitMainMenuActivity (int errorMessage) {
        if (Objects.equals(errorMessage, 1)) {
            Toast.makeText(this, getString(R.string.error_loading_model), R.style.AlertDialogCustom).show();

            Intent intent = new Intent(SplashScreenActivity.this, MainMenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(SplashScreenActivity.this, MainMenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }
}
