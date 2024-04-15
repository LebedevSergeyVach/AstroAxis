package astro.axis.planet.libgdx;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;

import android.view.GestureDetector.SimpleOnGestureListener;


public class PlanetActivity extends AppCompatActivity {
    private static final String TAG = "APP:PlanetActivity";

    private TextView planetNameTextView;
    private Button modelButton, backButton;

    // Для жеста назад
    private GestureDetector gestureDetector;

    private static String planetName;
    private static int textSizeTable;

    // Диалоговое окно для разметки спиннера
    private ProgressDialog progressDialog;

    @SuppressLint({"SetTextI18n", "NewApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gestureDetector = new GestureDetector(this, new MyGestureListener());

        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_planet_upheaval);
            textSizeTable = 28;
        } else {
            setContentView(R.layout.activity_planet);
            textSizeTable = 23;
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
            modelButton.setOnClickListener(view -> openModelButton(getString(R.string.Sun)));
        } else if (planetName.equals(getString(R.string.Mercury))) {
            modelButton.setOnClickListener(view -> openModelButton(getString(R.string.Mercury)));
        } else if (planetName.equals(getString(R.string.Venus))) {
            modelButton.setOnClickListener(view -> openModelButton(getString(R.string.Venus)));
        } else if (planetName.equals(getString(R.string.Earth))) {
            modelButton.setOnClickListener(view -> openModelButton(getString(R.string.Earth)));
        } else if (planetName.equals(getString(R.string.Mars))) {
            modelButton.setOnClickListener(view -> openModelButton(getString(R.string.Mars)));
        } else if (planetName.equals(getString(R.string.Jupiter))) {
            modelButton.setOnClickListener(view -> openModelButton(getString(R.string.Jupiter)));
        } else if (planetName.equals(getString(R.string.Saturn))) {
            modelButton.setOnClickListener(view -> openModelButton(getString(R.string.Saturn)));
        } else if (planetName.equals(getString(R.string.Uranium))) {
            modelButton.setOnClickListener(view -> openModelButton(getString(R.string.Uranium)));
        } else if (planetName.equals(getString(R.string.Neptune))) {
            modelButton.setOnClickListener(view -> openModelButton(getString(R.string.Neptune)));
        } else if (planetName.equals(getString(R.string.Pluto))) {
            modelButton.setOnClickListener(view -> openModelButton(getString(R.string.Pluto)));
        } else {
            modelButton.setOnClickListener(view -> exitMainMenuActivity(1));
        }

        backButton.setOnClickListener(view -> finish());

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Подключение базы данных



        String[][] data = {
                {getString(R.string.name), planetName},
                {getString(R.string.radius), "6,371 км"},
                {getString(R.string.mass), "5.972 × 10^24\nкг"},
                {getString(R.string.density), "5,515 г/см³"},
                {getString(R.string.average_temperature), "14°C"},
                {getString(R.string.number_of_satellites), "1"},
                {getString(R.string.main_satellites), "Луна"},
                {getString(R.string.the_speed_of_rotation_around_its_axis), "23 часа 56 мин\n1,674 км/ч"},
                {getString(R.string.the_speed_of_rotation_around_the_Sun), "107,225\nкм/ч"},
                {getString(R.string.rotation_period), "23.934 часа"},
                {getString(R.string.the_orbital_period), "365.256 дней"},
                {getString(R.string.large_semi_axis), "149.600.000\nкм"},
                {getString(R.string.rings), "Нет"},
                {getString(R.string.quantity_ring), "Нет"},
                {getString(R.string.giant), "Нет"},
                {getString(R.string.the_presence_of_an_atmosphere), "Есть"},
                {getString(R.string.atmospheric_layers), "Тропосфера\nСтратосфера\nМезосфера\nТермосфера\nЭкзосфера"},
                {getString(R.string.internal_structure), "Кора\nмантия\nядро"},
                {getString(R.string.features), "Живое\nсущества\nАтмосфера с\nкислородом\nИзменения\nклимата"},

        };

        for (String[] row : data) {
            TableRow tableRow = new TableRow(this);
            tableRow.setBackgroundResource(R.drawable.table_border); // Добавляем фоновый рисунок для линий
            for (String cell : row) {
                TextView textView = new TextView(this);
                textView.setText(cell);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeTable); // Устанавливаем размер текста
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

    private void openModelButton(String namePlanet) {
        // Исполнение асинхронной задачи в отдельном потоке
        // Загружаем следующую активность

        // Первый поток
        new Thread(() -> runOnUiThread(() -> {
            modelButton.setText(getString(R.string.loading));
            // Отображение спиннера загрузки
            progressDialog = new ProgressDialog(PlanetActivity.this, R.style.CustomProgressDialog);
            progressDialog.setMessage(getString(R.string.loading_model));
            // Указывает, можно ли отменить этот диалог с помощью клавиши BACK.
            progressDialog.setCancelable(false);
            progressDialog.show();
        })).start();

        // Второй поток
        new Thread(() -> {
            try {
                // Загружаем следующую активность
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), namePlanet);
                startActivity(intentName);
            } catch (ActivityNotFoundException e) {
                // Выкидывает на главную активность приложения и выводит тостер
                runOnUiThread(() -> exitMainMenuActivity(1));
            } catch (RejectedExecutionException e) {
                runOnUiThread(() -> {
                    Toast.makeText(PlanetActivity.this, getString(R.string.error_loading_model), R.style.AlertDialogCustom).show();
                    throw new RuntimeException(e);
                });
            }
        }).start();
    }

    private void exitMainMenuActivity (int errorMessage) {
        if (Objects.equals(errorMessage, 1)) {
            Log.d(TAG, "The transition of their PlanetActivity to MainActivity ERROR");
            Toast.makeText(this, getString(R.string.error_loading_model), R.style.AlertDialogCustom).show();

            Intent intent = new Intent(PlanetActivity.this, MainMenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        } else {
            Log.d(TAG, "The transition of their PlanetActivity to MainActivity");
            Intent intent = new Intent(PlanetActivity.this, MainMenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }

    // ОБЯЗАТЕЛЕН ДЛЯ ЗАКРЫТИЯ СПИННЕРА
    @Override
    protected void onResume() {
        super.onResume();
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        modelButton.setText(getString(R.string.model));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class MyGestureListener extends SimpleOnGestureListener {
        private static final int SWIPE_MIN_DISTANCE = 120;
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
