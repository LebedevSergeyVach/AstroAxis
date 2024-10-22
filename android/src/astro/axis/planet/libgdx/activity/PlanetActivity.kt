package astro.axis.planet.libgdx.activity;

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
import astro.axis.planet.libgdx.*;
import astro.axis.planet.libgdx.helper.PlanetDataArray;
import astro.axis.planet.libgdx.helper.SwipeGestureListener;
import astro.axis.planet.libgdx.launcher.AndroidLauncher;

import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;


public class PlanetActivity extends AppCompatActivity {
    private static final String TAG = "APP:PlanetActivity";

    private static String planetName;

    private Button modelButton, backButton;

    private TextView planetNameTextView;
    private TableLayout tableLayout;

    private String[][] planetData;

    // Диалоговое окно для разметки спиннера
    private ProgressDialog progressDialog;
    // Для жеста назад
    private GestureDetector gestureDetector;

    @SuppressLint("NewApi") // ДЛЯ GetColor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        gestureDetector = new GestureDetector(new SwipeGestureListener(this));
        int orientation = getResources().getConfiguration().orientation;

        int textSizeTable;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_planet_upheaval);
            textSizeTable = 26;
        } else {
            setContentView(R.layout.activity_planet);
            textSizeTable = 22;
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

        tableLayout = findViewById(R.id.tableLayout);
        planetData = getPlanetDataArray();

        for (String[] row : planetData) {
            TableRow tableRow = new TableRow(this);
            tableRow.setBackgroundResource(R.drawable.table_border); // Добавляем фоновый рисунок для линий
            for (String cell : row) {
                TextView textView = new TextView(this);
                textView.setText(cell);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeTable); // Устанавливаем размер текста
                textView.setTextColor(getColor(R.color.white)); // Устанавливаем цвет текста
                textView.setPadding(25, 20, 15, 20);
                // textView.setBackgroundResource(R.drawable.cell_border); // Добавляем фоновый рисунок для линий
                tableRow.addView(textView);

                // Устанавливаем ваш шрифт
                Typeface typeface = ResourcesCompat.getFont(this, R.font.samsungone700c);
                textView.setTypeface(typeface);

                // Устанавливаем ширину столбца в зависимости от содержимого
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
                textView.setLayoutParams(layoutParams);
            }
            tableLayout.addView(tableRow);
        }
    }

    private String[][] getPlanetDataArray() {
        String[] planetData = new String[18];

        PlanetDataArray planetDataArray = new PlanetDataArray();

        if (planetName.equals(getString(R.string.Mercury))) {
            planetData = planetDataArray.getPlanetData("mercury");
        } else if (planetName.equals(getString(R.string.Venus))) {
            planetData = planetDataArray.getPlanetData("venus");
        } else if (planetName.equals(getString(R.string.Earth))) {
            planetData = planetDataArray.getPlanetData("earth");
        } else if (planetName.equals(getString(R.string.Mars))) {
            planetData = planetDataArray.getPlanetData("mars");
        } else if (planetName.equals(getString(R.string.Jupiter))) {
            planetData = planetDataArray.getPlanetData("jupiter");
        } else if (planetName.equals(getString(R.string.Saturn))) {
            planetData = planetDataArray.getPlanetData("saturn");
        } else if (planetName.equals(getString(R.string.Uranium))) {
            planetData = planetDataArray.getPlanetData("uranus");
        } else if (planetName.equals(getString(R.string.Neptune))) {
            planetData = planetDataArray.getPlanetData("neptune");
        }

        String[][] data = {
                {getString(R.string.name), planetData[0]},
                {getString(R.string.radius), planetData[1]},
                {getString(R.string.mass), planetData[2]},
                {getString(R.string.density), planetData[3]},
                {getString(R.string.average_temperature), planetData[4]},
                {getString(R.string.number_of_satellites), planetData[5]},
                {getString(R.string.main_satellites), planetData[6]},
                {getString(R.string.the_speed_of_rotation_around_its_axis), planetData[7]},
                {getString(R.string.the_speed_of_rotation_around_the_Sun), planetData[8]},
                {getString(R.string.rotation_period), planetData[9]},
                {getString(R.string.the_orbital_period), planetData[10]},
                {getString(R.string.large_semi_axis), planetData[11]},
                {getString(R.string.rings), planetData[12]},
                {getString(R.string.quantity_ring), planetData[13]},
                {getString(R.string.giant), planetData[14]},
                {getString(R.string.the_presence_of_an_atmosphere), planetData[15]},
                {getString(R.string.atmospheric_layers), planetData[16]},
                {getString(R.string.internal_structure), planetData[17]},
                {getString(R.string.features), planetData[18]},

        };

        return data;
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
}
