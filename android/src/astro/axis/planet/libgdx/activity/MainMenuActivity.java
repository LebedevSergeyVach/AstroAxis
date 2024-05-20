package astro.axis.planet.libgdx.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import astro.axis.planet.libgdx.helper.NotificationHelper;
import astro.axis.planet.libgdx.R;


public class MainMenuActivity extends AppCompatActivity {
    private static final String TAG = "APP:MainMenu";

    private Button planetsButton, theoryButton, helpButton, exitButton;
    private TextView applicationNameTextView, descriptionApplicationNameTextView;
    private int clickCount = 0;

    private GestureDetector gestureDetector;

    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gestureDetector = new GestureDetector(this, new MyGestureListener());

        int orientation = getResources().getConfiguration().orientation;

        int textSizeButton;
        int textSizeApplicationName;
        int textSizeDescriptionApplication;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_menu_upheaval);
            textSizeButton = 30;
            textSizeApplicationName = 70;
            textSizeDescriptionApplication = 18;
        } else {
            setContentView(R.layout.activity_main_menu);
            textSizeButton = 19;
            textSizeApplicationName = 58;
            textSizeDescriptionApplication = 16;
        }

        Log.d(TAG, "Start Application and MainMenuActivity");

        applicationNameTextView = findViewById(R.id.applicationName);
        descriptionApplicationNameTextView = findViewById(R.id.descriptionApplication);

        textDisplayView(applicationNameTextView, R.string.app_name, R.color.white, textSizeApplicationName);
        textDisplayView(descriptionApplicationNameTextView, R.string.description_name, R.color.white, textSizeDescriptionApplication);

        planetsButton = findViewById(R.id.planetsButton);
        theoryButton = findViewById(R.id.theoryButton);
        helpButton = findViewById(R.id.helpButton);
        exitButton = findViewById(R.id.backButton);

        buttonDisplayView(planetsButton, R.string.planets, 30, R.color.white);
        buttonDisplayView(theoryButton, R.string.theory, 30, R.color.white);
        buttonDisplayView(helpButton, R.string.help, textSizeButton, R.color.white);
        buttonDisplayView(exitButton, R.string.exit, textSizeButton, R.color.white);

        planetsButton.setOnClickListener(view -> {
            Log.d(TAG, "The transition of their MainMenuActivity to MainActivity");
            startActivity(new Intent(MainMenuActivity.this, MainActivity.class));
        });

        theoryButton.setOnClickListener(view -> {
            Log.d(TAG, "The transition of their MainMenuActivity to TestsActivity");
            startActivity(new Intent(MainMenuActivity.this, TheoryActivity.class));
        });

        helpButton.setOnClickListener(view -> {
            Log.d(TAG, "The transition of their MainMenuActivity to HelpActivity");
            startActivity(new Intent(MainMenuActivity.this, HelpActivity.class));
        });

        exitButton.setOnClickListener(view -> exitApplication());

        TextView nameApp = findViewById(R.id.applicationName);

        nameApp.setOnClickListener(view -> {
            clickCount++;

            if (clickCount == 5) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/LebedevSergeyVach/AstroAxis"));
                NotificationHelper.showNotification(this, getString(R.string.app_name), "Кликните и поставьте ⭐\uFE0F на GitHub", browserIntent);

                clickCount = 0;
            }
        });
    }

    private void textDisplayView(TextView textView, int stringIdText, int colorIdText, int textSize) {
        textView.setText(getString(stringIdText));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        textView.setTextColor(getResources().getColor(colorIdText));
        textView.setGravity(Gravity.CENTER);
    }

    private void buttonDisplayView(Button buttonView, int stringIdTextButton, int colorIdTextButton, int textSizeButton) {
        buttonView.setText(getString(stringIdTextButton));
        buttonView.setTextSize(TypedValue.COMPLEX_UNIT_SP, colorIdTextButton);
        buttonView.setTextColor(getResources().getColor(textSizeButton));
        buttonView.setGravity(Gravity.CENTER);
    }

    private void exitApplication() {
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

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        exitApplication();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_MIN_DISTANCE = 200;
        private static final int SWIPE_THRESHOLD_VELOCITY = 200;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() < SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                exitApplication();
            }
            return false;
        }
    }
}
