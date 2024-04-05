package astro.axis.planet.libgdx;

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


public class TheoryActivity extends AppCompatActivity {

    private Button exitButton, openGLinkGuideButton;

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gestureDetector = new GestureDetector(this, new MyGestureListener());

        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_theory_upheaval);
        } else {
            setContentView(R.layout.activity_theory);
        }

        openGLinkGuideButton = findViewById(R.id.openGLinkGuideButton);
        exitButton = findViewById(R.id.exitButton);

        openGLinkGuideButton.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://docs.yandex.ru/docs/view?tm=1712343804&tld=ru&lang=ru&name=65777082.pdf&text=Основные%20иены%20измерения%20астрономия%2011%20класс&url=https%3A%2F%2Fwww.litres.ru%2Fget_pdf_trial%2F65777082.pdf&lr=65&mime=pdf&l10n=ru&sign=5f049789bcb124afa918d794e59be610&keyno=0&serpParams=tm%3D1712343804%26tld%3Dru%26lang%3Dru%26name%3D65777082.pdf%26text%3D%25D0%259E%25D1%2581%25D0%25BD%25D0%25BE%25D0%25B2%25D0%25BD%25D1%258B%25D0%25B5%2B%25D0%25B8%25D0%25B5%25D0%25BD%25D1%258B%2B%25D0%25B8%25D0%25B7%25D0%25BC%25D0%25B5%25D1%2580%25D0%25B5%25D0%25BD%25D0%25B8%25D1%258F%2B%25D0%25B0%25D1%2581%25D1%2582%25D1%2580%25D0%25BE%25D0%25BD%25D0%25BE%25D0%25BC%25D0%25B8%25D1%258F%2B11%2B%25D0%25BA%25D0%25BB%25D0%25B0%25D1%2581%25D1%2581%26url%3Dhttps%253A%2F%2Fwww.litres.ru%2Fget_pdf_trial%2F65777082.pdf%26lr%3D65%26mime%3Dpdf%26l10n%3Dru%26sign%3D5f049789bcb124afa918d794e59be610%26keyno%3D0")));
        });

        exitButton.setOnClickListener(view -> {
            Intent intent = new Intent(TheoryActivity.this, MainMenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
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
