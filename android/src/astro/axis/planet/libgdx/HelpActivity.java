package astro.axis.planet.libgdx;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;

public class HelpActivity extends AppCompatActivity {
    private static final String TAG = "APP:HelpActivity";

    private Button exit;
    private ImageView openGitHubButton;

    private GestureDetector gestureDetector;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gestureDetector = new GestureDetector(this, new MyGestureListener());

        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_help_upheaval);
        } else {
            setContentView(R.layout.activity_help);
        }

        Log.d(TAG, "Start HelpActivity");

        openGitHubButton = findViewById(R.id.openGithubButton);
        exit = findViewById(R.id.exit);

        openGitHubButton.setOnClickListener(view -> {
            Log.d(TAG, "~~~ Pressing the button 'open_github' ~~~");

            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://github.com/LebedevSergeyVach/AstroAxis")));
        });

        exit.setOnClickListener(view -> {
            Log.d(TAG, "~~~ Pressing the button 'exit' ~~~");

            Intent intent = new Intent(HelpActivity.this, MainMenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class MyGestureListener extends SimpleOnGestureListener {
        private static final int SWIPE_MIN_DISTANCE = 120;
        private static final int SWIPE_MAX_OFF_PATH = 250;
        private static final int SWIPE_THRESHOLD_VELOCITY = 200;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() < SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                // Смахивание слева направо
                Log.d("MyActivity", "Swipe right to left detected");
                finish(); // Закрываем активность
                return true;
            }
            return false;
        }
    }
}
