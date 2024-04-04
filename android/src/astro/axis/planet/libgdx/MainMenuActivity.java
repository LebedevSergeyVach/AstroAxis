package astro.axis.planet.libgdx;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainMenuActivity extends AppCompatActivity {
    private static final String TAG = "APP:MainMenu";

    private Button planetsButton, testsButton, helpButton, exitButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_menu_upheaval);
        } else {
            setContentView(R.layout.activity_main_menu);
        }

        Log.d(TAG, "Start Application and MainMenuActivity");

        planetsButton = findViewById(R.id.planetsButton);
        testsButton = findViewById(R.id.testsButton);
        helpButton = findViewById(R.id.helpButton);
        exitButton = findViewById(R.id.exitButton);

        planetsButton.setOnClickListener(view -> {
            Log.d(TAG, "The transition of their MainMenuActivity to MainActivity");

            startActivity(new Intent(MainMenuActivity.this, MainActivity.class));
        });

        testsButton.setOnClickListener(view -> {
            Log.d(TAG, "The transition of their MainMenuActivity to TestsActivity");

            startActivity(new Intent(MainMenuActivity.this, TestsActivity.class));
        });

        helpButton.setOnClickListener(view -> {
            Log.d(TAG, "The transition of their MainMenuActivity to HelpActivity");

            startActivity(new Intent(MainMenuActivity.this, HelpActivity.class));
        });

        exitButton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainMenuActivity.this, R.style.AlertDialogCustom);
            builder.setIcon(R.drawable.space);
            builder.setTitle("Выход из приложения");
            builder.setMessage("Вы точно хотите выйти из приложения ?! \uD83E\uDD76\uD83E\uDD76\uD83E\uDD76");
            builder.setCancelable(false);

            builder.setPositiveButton("Да \uD83D\uDE2D", (dialog, which) -> {
                finishAffinity();
                System.exit(0);
            });

            builder.setNegativeButton("Нет \uD83D\uDE01", (dialog, which) -> {
                dialog.cancel();
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this, R.style.AlertDialogCustom)
                .setIcon(R.drawable.space)
                .setTitle("Выход из приложения")
                .setMessage("Вы точно хотите выйти из приложения ?! \uD83E\uDD76\uD83E\uDD76\uD83E\uDD76")
                .setPositiveButton("Да \uD83D\uDE2D", (dialog, which) -> {
                    // Пользователь подтвердил выход, закрываем приложение
                    finishAffinity();
                })
                .setNegativeButton("Нет \uD83D\uDE01", null)
                .show();
    }
}
