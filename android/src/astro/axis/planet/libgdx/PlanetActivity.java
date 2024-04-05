package astro.axis.planet.libgdx;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;


public class PlanetActivity extends AppCompatActivity {
    private static final String TAG = "APP:PlanetActivity";

    private TextView planetNameTextView;
    private Button modelButton, backButton;

    private GestureDetector gestureDetector;

    private static String planetName;

    @SuppressLint({"SetTextI18n", "NewApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gestureDetector = new GestureDetector(this, new MyGestureListener());

        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_planet_upheaval);
        } else {
            setContentView(R.layout.activity_planet);
        }

        Log.d(TAG, "Start PlanetActivity");

        planetNameTextView = findViewById(R.id.planetName);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("planetName")) {
            planetName = intent.getStringExtra("planetName");
            planetNameTextView.setText(planetName);
            Log.e(TAG, "planetName  =>   " + planetName);
        }

        modelButton = findViewById(R.id.modelButton);
        backButton = findViewById(R.id.backButton);

        if (planetName.equals(getString(R.string.Sun))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Sun));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Mercury))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Mercury));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Venus))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Venus));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Earth))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Earth));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Mars))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Mars));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Jupiter))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Jupiter));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Saturn))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Saturn));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Uranium))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Uranium));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Neptune))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Neptune));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Pluto))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Pluto));
                startActivity(intentName);
            });
        } else {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to MainActivity");
                Intent intentHome = new Intent(PlanetActivity.this, MainMenuActivity.class);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentHome);
                finish();
            });
        }

        backButton.setOnClickListener(view -> finish());


        TableLayout tableLayout = findViewById(R.id.tableLayout);

        String[][] data = {
                {getString(R.string.name), planetName},
                {getString(R.string.radius), "6,371 км"},
                {getString(R.string.mass), "5.972 × 10^24\nкг"},
                {getString(R.string.density), "5,515 г/см³"},
                {getString(R.string.average_temperature), "14°C"},
                {getString(R.string.number_of_satellites), "1"},
                {getString(R.string.main_satellites), "Луна"},
                {getString(R.string.the_speed_of_rotation_around_its_axis), "1,674 км/ч"},
                {getString(R.string.the_speed_of_rotation_around_the_Sun), "107,225\nкм/ч"},
                {getString(R.string.rotation_period), "23.934 часа"},
                {getString(R.string.the_orbital_period), "365.256 дней"},
                {getString(R.string.large_semi_axis), "149.600.000\nкм"},
                {getString(R.string.internal_structure), "Кора\nмантия\nядро"},

        };

        for (String[] row : data) {
            TableRow tableRow = new TableRow(this);
            tableRow.setBackgroundResource(R.drawable.table_border); // Добавляем фоновый рисунок для линий
            for (String cell : row) {
                TextView textView = new TextView(this);
                textView.setText(cell);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25); // Устанавливаем размер текста
                textView.setTextColor(getColor(R.color.white)); // Устанавливаем цвет текста
                textView.setPadding(50, 15, 50, 15);
//                textView.setBackgroundResource(R.drawable.cell_border); // Добавляем фоновый рисунок для линий
                tableRow.addView(textView);

                // Устанавливаем ваш шрифт
                Typeface typeface = ResourcesCompat.getFont(this, R.font.samsungone700c);
                textView.setTypeface(typeface);
            }
            tableLayout.addView(tableRow);
        }
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
