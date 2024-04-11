package astro.axis.planet.libgdx;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE = "Planet";
    private static final String DATABASE_NAME = "databasePlanet.db";

    private static final int VERSION = 1;


    Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE PlanetaryInfo (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "info_type TEXT," +
                "info TEXT" +
                ")";
        db.execSQL(createTable);

        // Insert data
        String[][] data = {
                {"Название", "Земля"},
                {"Радиус", "6,371 км\""},
                {"Масса", "5.972 × 10^24\nкг"},
                {"Плотность", "5,515 г/см³"},
                {"Средняя\nтемпература", "14°C"},
                {"Количество\nспутников", "1"},
                {"Основные\nспутники", "Луна"},
                {"Скорость\nвращения\nвокруг\nсвоей оси", "1,674 км/ч"},
                {"Скорость\nвращения\nвокруг\nСолнца", "107,225\nкм/ч"},
                {"Период\nвращения", "23.934 часа"},
                {"Орбитальный\nпериод", "365.256 дней"},
                {"Большая\nполуось", "149.600.000\nкм"},
                {"Наличие\nколец", "Нет"},
                {"Количество\nколец", "Нет"},
                {"Гигант", "Нет"},
                {"Наличие\nатмосферы", "Есть"},
                {"Слои\nатмосферы", "Тропосфера\nСтратосфера\nМезосфера\nТермосфера\nЭкзосфера"},
                {"Внутреннее\nстроение", "Кора\nмантия\nядро"},
                {"Особенности", "Живое\nсущества\nАтмосфера с\nкислородом\nИзменения\nклимата"},
        };

        for (String[] row : data) {
            String insertData = "INSERT INTO PlanetaryInfo (info_type, info) VALUES ('" + row[0] + "', '" + row[1] + "')";
            db.execSQL(insertData);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String command = String.format("DROP TABLE IF EXISTS %s", TABLE);
        db.execSQL(command);
        onCreate(db);
    }
}
