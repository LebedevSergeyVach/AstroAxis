package astro.axis.planet.libgdx;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
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


public class PlanetActivity extends AppCompatActivity {
    private static final String TAG = "APP:PlanetActivity";

    private static String planetName;

    private Button modelButton, backButton;

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
            textSizeTable = 28;
        } else {
            setContentView(R.layout.activity_planet);
            textSizeTable = 22;
        }

        Log.d(TAG, "Start PlanetActivity");

        TextView planetNameTextView = findViewById(R.id.planetName);

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

        // Подключение базы данных

//        if (checkDataBase()) {
//            // База данных существует
//            Toast.makeText(this, "БД ЕСТЬ", R.style.AlertDialogCustom).show();
//        } else {
//            // База данных не существует
//            // Toast.makeText(this, "БД НЕТ", R.style.AlertDialogCustom).show();
//        }
//
//        try {
//            DatabaseHelper dbHelper = new DatabaseHelper(this); // Создайте экземпляр класса DatabaseHelper
//
//            Cursor cursor = dbHelper.getDataById(1); // Получить данные по ID
//            if (cursor.moveToFirst()) {
//                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_NAME));
//                @SuppressLint("Range") String radius = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_RADIUS));
//                @SuppressLint("Range") String mass = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_MASS));
//                @SuppressLint("Range") String density = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_DENSITY));
//                @SuppressLint("Range") String averagetTemperature = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_AVERAGE_TEMPERATURE));
//                @SuppressLint("Range") String numberSatellites = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_NUMBER_OF_SATELLITES));
//                @SuppressLint("Range") String mainSatellites = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_MAIN_SATELLITES));
//                @SuppressLint("Range") String SpeedRotationAroundItsAxis = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_SPEED_OF_ROTATION_AROUND_ITS_AXIS));
//                @SuppressLint("Range") String speedRotationAroundSun = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_SPEED_OF_ROTATION_AROUND_THE_SUN));
//                @SuppressLint("Range") String rotationPeriod = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_ROTATION_PERIOD));
//                @SuppressLint("Range") String orbitalPeriod = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_ORBITAL_PERIOD));
//                @SuppressLint("Range") String largeSemiAxis = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_LARGE_SEMI_AXIS));
//                @SuppressLint("Range") String quantityRing = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_RINGS));
//                @SuppressLint("Range") String quantityRin = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_QUANTITY_RING));
//                @SuppressLint("Range") String gigant = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_GIANT));
//                @SuppressLint("Range") String presenceAtmosphere = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_PRESENCE_OF_AN_ATMOSPHERE));
//                @SuppressLint("Range") String layersAtmosphere = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_ATMOSPHERIC_LAYERS));
//                @SuppressLint("Range") String internalStructure = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_INTERNAL_STRUCTURE));
//                @SuppressLint("Range") String features = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_FEATURES));
//            } else {
//                Log.e("qweasd", "ПИЗДА");
//            }
//            cursor.close();
//            Log.e("qweasd", "Идет загрузки бд");
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e("qweasd", "Ошибка загрузки бд");
//        }

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        String[][] planetData = getPlanetDataArray();

        for (String[] row : planetData) {
            TableRow tableRow = new TableRow(this);
            tableRow.setBackgroundResource(R.drawable.table_border); // Добавляем фоновый рисунок для линий
            for (String cell : row) {
                TextView textView = new TextView(this);
                textView.setText(cell);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeTable); // Устанавливаем размер текста
                textView.setTextColor(getColor(R.color.white)); // Устанавливаем цвет текста
                textView.setPadding(15, 20, 0, 20);
//                textView.setBackgroundResource(R.drawable.cell_border); // Добавляем фоновый рисунок для линий
                tableRow.addView(textView);

                // Устанавливаем ваш шрифт
                Typeface typeface = ResourcesCompat.getFont(this, R.font.samsungone700c);
                textView.setTypeface(typeface);
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

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DatabaseHelper.DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            // База данных еще не существует
        }

        if (checkDB != null) {
            checkDB.close();
        }

        return checkDB != null;
    }
}
