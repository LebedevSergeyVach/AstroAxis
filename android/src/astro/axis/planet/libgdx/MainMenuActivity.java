package astro.axis.planet.libgdx;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainMenuActivity extends AppCompatActivity {
    private static final String TAG = "APP:MainMenu";

    private Button planetsButton, testsButton, helpButton, exitButton;

    private GestureDetector gestureDetector;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gestureDetector = new GestureDetector(this, new MainMenuActivity.MyGestureListener());

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
            startActivity(new Intent(MainMenuActivity.this, TheoryActivity.class));
        });

        helpButton.setOnClickListener(view -> {
            Log.d(TAG, "The transition of their MainMenuActivity to HelpActivity");
            startActivity(new Intent(MainMenuActivity.this, HelpActivity.class));
        });

        exitButton.setOnClickListener(view -> exitApplication());
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        exitApplication();
    }

    public void exitApplication() {
        new AlertDialog.Builder(this, R.style.AlertDialogCustom)
                .setIcon(R.drawable.space)
                .setTitle(getString(R.string.exit_application))
                .setMessage(getString(R.string.confirmation_exit_application))
                .setPositiveButton("Да", (dialog, which) -> {
                    // Пользователь подтвердил выход, закрываем приложение
                    finishAffinity();
                })
                .setNegativeButton("Нет", null)
                .show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_MIN_DISTANCE = 120;
        private static final int SWIPE_THRESHOLD_VELOCITY = 200;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() < SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                new AlertDialog.Builder(MainMenuActivity.this, R.style.AlertDialogCustom)
                        .setIcon(R.drawable.space)
                        .setTitle(getString(R.string.exit_application))
                        .setMessage(getString(R.string.confirmation_exit_application))
                        .setPositiveButton("Да", (dialog, which) -> {
                            // Пользователь подтвердил выход, закрываем приложение
                            finishAffinity();
                        })
                        .setNegativeButton("Нет", null)
                        .show();
            }
            return false;
        }
    }
}
