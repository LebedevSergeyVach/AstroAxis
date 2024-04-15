package astro.axis.planet.libgdx;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "databasePlanet.db";
    public static final String TABLE_NAME = "planet_table";
    private static final int VERSION = 1;

    private static final String KEY_NAME = "name";
    private static final String KEY_RADIUS = "radius";
    private static final String KEY_MASS = "mass";
    private static final String KEY_DENSITY = "density";
    private static final String KEY_AVERAGE_TEMPERATURE = "average_temperature";
    private static final String KEY_NUMBER_OF_SATELLITES = "number_of_satellites";
    private static final String KEY_MAIN_SATELLITES = "main_satellites";
    private static final String KEY_SPEED_OF_ROTATION_AROUND_ITS_AXIS = "the_speed_of_rotation_around_its_axis";
    private static final String KEY_SPEED_OF_ROTATION_AROUND_THE_SUN = "the_speed_of_rotation_around_the_Sun";
    private static final String KEY_ROTATION_PERIOD = "rotation_period";
    private static final String KEY_ORBITAL_PERIOD = "the_orbital_period";
    private static final String KEY_LARGE_SEMI_AXIS = "large_semi_axis";
    private static final String KEY_RINGS = "rings";
    private static final String KEY_QUANTITY_RING = "quantity_ring";
    private static final String KEY_GIANT = "giant";
    private static final String KEY_PRESENCE_OF_AN_ATMOSPHERE = "the_presence_of_an_atmosphere";
    private static final String KEY_ATMOSPHERIC_LAYERS = "atmospheric_layers";
    private static final String KEY_INTERNAL_STRUCTURE = "internal_structure";
    private static final String KEY_FEATURES = "features";

    Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                KEY_NAME + " TEXT," +
                KEY_RADIUS + " TEXT," +
                KEY_MASS + " TEXT," +
                KEY_DENSITY + " TEXT," +
                KEY_AVERAGE_TEMPERATURE + " TEXT," +
                KEY_NUMBER_OF_SATELLITES + " TEXT," +
                KEY_MAIN_SATELLITES + " TEXT," +
                KEY_SPEED_OF_ROTATION_AROUND_ITS_AXIS + " TEXT," +
                KEY_SPEED_OF_ROTATION_AROUND_THE_SUN + " TEXT," +
                KEY_ROTATION_PERIOD + " TEXT," +
                KEY_ORBITAL_PERIOD + " TEXT," +
                KEY_LARGE_SEMI_AXIS + " TEXT," +
                KEY_RINGS + " TEXT," +
                KEY_QUANTITY_RING + " TEXT," +
                KEY_GIANT + " TEXT," +
                KEY_PRESENCE_OF_AN_ATMOSPHERE + " TEXT," +
                KEY_ATMOSPHERIC_LAYERS + " TEXT," +
                KEY_INTERNAL_STRUCTURE + " TEXT," +
                KEY_FEATURES + " TEXT)";

        db.execSQL(createTable);

//        KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +

        // Insert data for Mercury
        String[] dataMercury = {
                "Меркурий", "2,439 км", "3.302 × 10^23\nкг", "5,427 кг/м³",
                "-35°C до 187°C", "0", "Нет", "58.646 км/ч", "47.870 км/ч",
                "58.65 дней", "87,97 дней", "57.910.000\nкм", "Нет", "Нет",
                "Нет", "Очень разреженная", "Термосфера", "Кора\nмантия\nядро",
                "Наименьшая планета\nСолнечной системы\nвысокая доля железа\nв составе\nзначительные\nтемпер. колебания"
        };

        // Insert data for Venus
        String[] dataVenus = {
                "Венера", "6,051 км", "4.867 × 10^24\nкг", "5,243 кг/м³", "462°C",
                "Нет", "Нет", "6.520 км/ч", "35.020 км/ч", "243 дня", "224,70 дней",
                "108.200.000\nкм", "Нет", "Нет", "Нет", "Есть", "Тропосфера\nстратосфера\nмезосфера\nтермосфера",
                "Кора\nмантия\nядро", "Вторая планета\nот Солнца\nСамая горячая\nпланета\nПлотная атмосфера\nиз углекислого газа\nОблака из серной\nкислоты\nОбратная вращение"
        };

        // Insert data for Earth
        String[] dataEarth = {
                "Земля", "6,371 км", "5.972 × 10^24\nкг", "5,515 г/см³", "14°C", "1", "Луна",
                "1,674 км/ч", "107.2 км/ч", "23 часа 56 мин", "365.25 дней", "149.600.000\nкм", "Нет", "Нет", "Нет",
                "Есть", "Тропосфера\nСтратосфера\nМезосфера\nТермосфера\nЭкзосфера", "Кора\nмантия\nядро",
                "Живые\nсущества\nАтмосфера с\nкислородом\nИзменения\nклимата"
        };

        String[] dataMars = {
                "Марс", "3,390 км", "6.417 × 10^23\nкг", "3,933 кг/м³", "-87°C", "2", "Фобос\nДеймос",
                "240.077 км/ч", "24.077 км/ч", "1.026 дней", "687 дней", "227.940.000\nкм", "Нет", "Нет", "Нет",
                "Очень разреженная", "Тропосфера\nстратосфера", "Кора\nмантия\nядро",
                "Вода\nземля\nатмосфера\nжизнь", "Третья планета\nот Солнца\nЕдинственная известная\nпланета с жизнью\nНаибольшая плотность\nв Солнечной системе\nНаибольшая поверхность\nв Солнечной системе"
        };

        String[] dataJupiter = {
                "Юпитер", "69,911 км", "1.898 × 10^27\nкг", "1,326 кг/м³", "-145°C", "79", "Европа\nКаллисто\nИо\nГанимед",
                "12.684 км/ч", "13.062 км/ч", "9.925 часов", "11.862 земных\nгода", "778.340.000\nкм", "Есть", "4 основных", "Газовый гигант",
                "Есть", "Тропосфера\nСтратосфера\nМезосфера\nТермосфера", "Горячая\nмантийная зона\nядро",
                "Самая большая\nпланета в Солнечной\nсистеме\nНаличие сильного\nмагнитного поля\nВеликолепные полосы\nи штормовые\nобразования"
        };

        String[] dataSaturn = {
                "Сатурн", "58,232 км", "5.683 × 10^26\nкг", "0.687 кг/м³", "-185°C", "82", "Титан\nРея\nДиона\nТефия\nЭнцелад",
                "9.690 км/ч", "9.690 км/ч", "10.656 часов", "29.457\nземных лет", "1,429.400.000\nкм", "Есть", "Многочисленные\n7 основных", "Газовый гигант",
                "Есть", "Тропосфера\nСтратосфера\nТермосфера", "Горячая\nмантийная зона\nядро",
                "Наличие спутника\nТитана с атмосферой\nи органическими\nмолекулами\nНаличие спутника\nЭнцелада с\nгейзерами\nводяного льда"
        };

        String[] dataUranus = {
                "Уран", "25,362 км", "8.681 × 10^25\nкг", "1.270 кг/м³", "-206°C", "27", "Ариэль\nУмбриэль\nТитания\nОберон",
                "6.810 км/ч", "6.810 км/ч", "17.24 часов", "84.016\nземных лет", "2,870.990.000\nкм", "Есть", "13 основных", "Ледяной гигант",
                "Есть", "Тропосфера\nСтратосфера\nТермосфера", "Горячая\nмантийная зона\nядро",
                "Планета вращается\nпод углом 97.77°\nНаличие метана\nв атмосфере"
        };

        String[] dataNeptune = {
                "Нептун", "24,764 км", "1.024 × 10^26\nкг", "1.638 кг/м³", "-201°C", "14", "Тритон\nНерида",
                "5.436 км/ч", "5.436 км/ч", "16.11 часов", "164.79\nземных лет", "4,495.100.000\nкм", "Есть", "5 основных", "Ледяной гигант",
                "Есть", "Тропосфера\nСтратосфера\nТермосфера", "Горячая\nмантийная зона\nядро",
                "Метан в атмосфере\nНаличие сильных\nветров и штормов\nСамая дальняя\nпланета от Солнца"
        };

        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < dataMercury.length; i++) {
            contentValues.put(getColumnName(i), dataMercury[i]);
        }
        db.insert(TABLE_NAME, null, contentValues);

        for (int i = 0; i < dataVenus.length; i++) {
            contentValues.put(getColumnName(i), dataVenus[i]);
        }
        db.insert(TABLE_NAME, null, contentValues);

        for (int i = 0; i < dataEarth.length; i++) {
            contentValues.put(getColumnName(i), dataEarth[i]);
        }
        db.insert(TABLE_NAME, null, contentValues);

        for (int i = 0; i < dataMars.length; i++) {
            contentValues.put(getColumnName(i), dataMars[i]);
        }
        db.insert(TABLE_NAME, null, contentValues);

        for (int i = 0; i < dataJupiter.length; i++) {
            contentValues.put(getColumnName(i), dataJupiter[i]);
        }
        db.insert(TABLE_NAME, null, contentValues);

        for (int i = 0; i < dataSaturn.length; i++) {
            contentValues.put(getColumnName(i), dataSaturn[i]);
        }
        db.insert(TABLE_NAME, null, contentValues);

        for (int i = 0; i < dataUranus.length; i++) {
            contentValues.put(getColumnName(i), dataUranus[i]);
        }
        db.insert(TABLE_NAME, null, contentValues);

        for (int i = 0; i < dataNeptune.length; i++) {
            contentValues.put(getColumnName(i), dataNeptune[i]);
        }
        db.insert(TABLE_NAME, null, contentValues);

//        String[][] planetsData = {dataMercury, dataVenus, dataEarth, dataMars, dataJupiter, dataSaturn, dataUranus, dataNeptune};
//        DatabaseHelper dbHelper = new DatabaseHelper(context);
//        dbHelper.addPlanets(planetsData);
    }

    public void addPlanets(String[][] planetsData) {
        SQLiteDatabase db = this.getWritableDatabase();

        for (String[] data : planetsData) {
            ContentValues values = new ContentValues();
            values.put(KEY_NAME, data[0]);
            values.put(KEY_RADIUS, data[1]);
            values.put(KEY_MASS, data[2]);
            values.put(KEY_DENSITY, data[3]);
            values.put(KEY_AVERAGE_TEMPERATURE, data[4]);
            values.put(KEY_NUMBER_OF_SATELLITES, data[5]);
            values.put(KEY_MAIN_SATELLITES, data[6]);
            values.put(KEY_SPEED_OF_ROTATION_AROUND_ITS_AXIS, data[7]);
            values.put(KEY_SPEED_OF_ROTATION_AROUND_THE_SUN, data[8]);
            values.put(KEY_ROTATION_PERIOD, data[9]);
            values.put(KEY_ORBITAL_PERIOD, data[10]);
            values.put(KEY_LARGE_SEMI_AXIS, data[11]);
            values.put(KEY_RINGS, data[12]);
            values.put(KEY_QUANTITY_RING, data[13]);
            values.put(KEY_GIANT, data[14]);
            values.put(KEY_PRESENCE_OF_AN_ATMOSPHERE, data[15]);
            values.put(KEY_ATMOSPHERIC_LAYERS, data[16]);
            values.put(KEY_INTERNAL_STRUCTURE, data[17]);
            values.put(KEY_FEATURES, data[18]);

            db.insert(TABLE_NAME, null, values);
        }

        db.close();
    }

    private String getColumnName(int index) {
        switch (index) {
            case 0:
                return KEY_NAME;
            case 1:
                return KEY_RADIUS;
            case 2:
                return KEY_MASS;
            case 3:
                return KEY_DENSITY;
            case 4:
                return KEY_AVERAGE_TEMPERATURE;
            case 5:
                return KEY_NUMBER_OF_SATELLITES;
            case 6:
                return KEY_MAIN_SATELLITES;
            case 7:
                return KEY_SPEED_OF_ROTATION_AROUND_ITS_AXIS;
            case 8:
                return KEY_SPEED_OF_ROTATION_AROUND_THE_SUN;
            case 9:
                return KEY_ROTATION_PERIOD;
            case 10:
                return KEY_ORBITAL_PERIOD;
            case 11:
                return KEY_LARGE_SEMI_AXIS;
            case 12:
                return KEY_RINGS;
            case 13:
                return KEY_QUANTITY_RING;
            case 14:
                return KEY_GIANT;
            case 15:
                return KEY_PRESENCE_OF_AN_ATMOSPHERE;
            case 16:
                return KEY_ATMOSPHERIC_LAYERS;
            case 17:
                return KEY_INTERNAL_STRUCTURE;
            case 18:
                return KEY_FEATURES;
            default:
                return "";

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String command = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(command);
        onCreate(db);
    }
}
