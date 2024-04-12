package astro.axis.planet.libgdx;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE = "planet_table";
    private static final String DATABASE_NAME = "databasePlanet.db";

    private static final int VERSION = 1;

    Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE planet_table (" +
                "column_info TEXT," +
                "column_Mercury TEXT," +
                "column_Venus TEXT," +
                "column_Earth TEXT," +
                "column_Mars TEXT," +
                "column_Jupiter TEXT," +
                "column_Saturn TEXT," +
                "column_Uranus TEXT," +
                "column_Neptune TEXT)";
        db.execSQL(createTable);

        // Добавляем 19 строк в столбец column_info
        for (int i = 1; i <= 19; i++) {
            String insertRow = "INSERT INTO planet_table (column_info) VALUES (?)";
            switch (i) {
                case 1:
                    db.execSQL(insertRow, new String[]{"Название"});
                    break;
                case 2:
                    db.execSQL(insertRow, new String[]{"Радиус"});
                    break;
                case 3:
                    db.execSQL(insertRow, new String[]{"Масса"});
                    break;
                case 4:
                    db.execSQL(insertRow, new String[]{"Плотность"});
                    break;
                case 5:
                    db.execSQL(insertRow, new String[]{"Средняя температура"});
                    break;
                case 6:
                    db.execSQL(insertRow, new String[]{"Количество спутников"});
                    break;
                case 7:
                    db.execSQL(insertRow, new String[]{"Основные спутники"});
                    break;
                case 8:
                    db.execSQL(insertRow, new String[]{"Скорость вращения вокруг своей оси"});
                    break;
                case 9:
                    db.execSQL(insertRow, new String[]{"Скорость вращения вокруг Солнца"});
                    break;
                case 10:
                    db.execSQL(insertRow, new String[]{"Период вращения"});
                    break;
                case 11:
                    db.execSQL(insertRow, new String[]{"Орбитальный период"});
                    break;
                case 12:
                    db.execSQL(insertRow, new String[]{"Большая полуось"});
                    break;
                case 13:
                    db.execSQL(insertRow, new String[]{"Наличие колец"});
                    break;
                case 14:
                    db.execSQL(insertRow, new String[]{"Количество колец"});
                    break;
                case 15:
                    db.execSQL(insertRow, new String[]{"Гигант"});
                    break;
                case 16:
                    db.execSQL(insertRow, new String[]{"Наличие атмосферы"});
                    break;
                case 17:
                    db.execSQL(insertRow, new String[]{"Слои атмосферы"});
                    break;
                case 18:
                    db.execSQL(insertRow, new String[]{"Внутреннее строение"});
                    break;
                case 19:
                    db.execSQL(insertRow, new String[]{"Особенности"});
                    break;
            }
        }

        // Добавляем 19 строк в столбец column_Mercury
        for (int i = 1; i <= 19; i++) {
            String insertRow = "INSERT INTO planet_table (column_Mercury) VALUES (?)";
            switch (i) {
                case 1:
                    db.execSQL(insertRow, new String[]{"Меркурий"});
                    break;
                case 2:
                    db.execSQL(insertRow, new String[]{"2,439 км"});
                    break;
                case 3:
                    db.execSQL(insertRow, new String[]{"3.302 × 10^23\nкг"});
                    break;
                case 4:
                    db.execSQL(insertRow, new String[]{"5,427 кг/м³"});
                    break;
                case 5:
                    db.execSQL(insertRow, new String[]{"-35°C до 187°C"});
                    break;
                case 6:
                    db.execSQL(insertRow, new String[]{"0"});
                    break;
                case 7:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 8:
                    db.execSQL(insertRow, new String[]{"58.646 км/ч"});
                    break;
                case 9:
                    db.execSQL(insertRow, new String[]{"47.870 км/ч"});
                    break;
                case 10:
                    db.execSQL(insertRow, new String[]{"58.65 дней"});
                    break;
                case 11:
                    db.execSQL(insertRow, new String[]{"87,97 дней"});
                    break;
                case 12:
                    db.execSQL(insertRow, new String[]{"57.910.000\nкм"});
                    break;
                case 13:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 14:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 15:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 16:
                    db.execSQL(insertRow, new String[]{"Очень разреженная"});
                    break;
                case 17:
                    db.execSQL(insertRow, new String[]{"Термосфера"});
                    break;
                case 18:
                    db.execSQL(insertRow, new String[]{"Кора\nмантия\nядро"});
                    break;
                case 19:
                    db.execSQL(insertRow, new String[]{"Наименьшая планета\nСолнечной системы\nвысокая доля железа\nв составе\nзначительные\nтемпер. колебания"});
                    break;
            }
        }

        // Добавляем 19 строк в столбец column_Venus
        for (int i = 1; i <= 19; i++) {
            String insertRow = "INSERT INTO planet_table (column_Venus) VALUES (?)";
            switch (i) {
                case 1:
                    db.execSQL(insertRow, new String[]{"Венера"});
                    break;
                case 2:
                    db.execSQL(insertRow, new String[]{"6,051 км"});
                    break;
                case 3:
                    db.execSQL(insertRow, new String[]{"4.867 × 10^24nкг"});
                    break;
                case 4:
                    db.execSQL(insertRow, new String[]{"5,243 кг/м³"});
                    break;
                case 5:
                    db.execSQL(insertRow, new String[]{"462°C"});
                    break;
                case 6:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 7:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 8:
                    db.execSQL(insertRow, new String[]{"6.520 км/ч "});
                    break;
                case 9:
                    db.execSQL(insertRow, new String[]{"35.020 км/ч"});
                    break;
                case 10:
                    db.execSQL(insertRow, new String[]{"243 дня"});
                    break;
                case 11:
                    db.execSQL(insertRow, new String[]{"224,70 дней"});
                    break;
                case 12:
                    db.execSQL(insertRow, new String[]{"108.200.000\nкм"});
                    break;
                case 13:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 14:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 15:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 16:
                    db.execSQL(insertRow, new String[]{"Есть"});
                    break;
                case 17:
                    db.execSQL(insertRow, new String[]{"Тропосфера\nстратосфера\nмезосфера\nтермосфера"});
                    break;
                case 18:
                    db.execSQL(insertRow, new String[]{"Кора\nмантия\nядро"});
                    break;
                case 19:
                    db.execSQL(insertRow, new String[]{"Вторая планета\nот Солнца\nСамая горячая\nпланета\nПлотная атмосфера\nиз углекислого газа\nОблака из серной\nкислоты\nОбратная вращение"});
                    break;
            }
        }

        // Добавляем 19 строк в столбец column_Earth
        for (int i = 1; i <= 19; i++) {
            String insertRow = "INSERT INTO planet_table (column_Earth) VALUES (?)";
            switch (i) {
                case 1:
                    db.execSQL(insertRow, new String[]{"Земля"});
                    break;
                case 2:
                    db.execSQL(insertRow, new String[]{"6,371 км"});
                    break;
                case 3:
                    db.execSQL(insertRow, new String[]{"5.972 × 10^24\nкг"});
                    break;
                case 4:
                    db.execSQL(insertRow, new String[]{"5,515 г/см³"});
                    break;
                case 5:
                    db.execSQL(insertRow, new String[]{"14°C"});
                    break;
                case 6:
                    db.execSQL(insertRow, new String[]{"1"});
                    break;
                case 7:
                    db.execSQL(insertRow, new String[]{"Луна"});
                    break;
                case 8:
                    db.execSQL(insertRow, new String[]{"1,674 км/ч"});
                    break;
                case 9:
                    db.execSQL(insertRow, new String[]{"107,225\nкм/ч"});
                    break;
                case 10:
                    db.execSQL(insertRow, new String[]{"23 часа\n56 мин"});
                    break;
                case 11:
                    db.execSQL(insertRow, new String[]{"365.256 дней"});
                    break;
                case 12:
                    db.execSQL(insertRow, new String[]{"149.600.000\nкм"});
                    break;
                case 13:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 14:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 15:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 16:
                    db.execSQL(insertRow, new String[]{"Есть"});
                    break;
                case 17:
                    db.execSQL(insertRow, new String[]{"Тропосфера\nСтратосфера\nМезосфера\nТермосфера\nЭкзосфера"});
                    break;
                case 18:
                    db.execSQL(insertRow, new String[]{"Кора\nмантия\nядро"});
                    break;
                case 19:
                    db.execSQL(insertRow, new String[]{"Живое\nсущества\nАтмосфера с\nкислородом\nИзменения\nклимата"});
                    break;
            }
        }

        // Добавляем 19 строк в столбец column_Mars
        for (int i = 1; i <= 19; i++) {
            String insertRow = "INSERT INTO planet_table (column_Mars) VALUES (?)";
            switch (i) {
                case 1:
                    db.execSQL(insertRow, new String[]{"Марс"});
                    break;
                case 2:
                    db.execSQL(insertRow, new String[]{"3,390 км"});
                    break;
                case 3:
                    db.execSQL(insertRow, new String[]{"6.417 × 10^23\nкг"});
                    break;
                case 4:
                    db.execSQL(insertRow, new String[]{"3,933 кг/м³"});
                    break;
                case 5:
                    db.execSQL(insertRow, new String[]{"-87°C"});
                    break;
                case 6:
                    db.execSQL(insertRow, new String[]{"2"});
                    break;
                case 7:
                    db.execSQL(insertRow, new String[]{"Фобос\nДеймос"});
                    break;
                case 8:
                    db.execSQL(insertRow, new String[]{"240.077 км/ч"});
                    break;
                case 9:
                    db.execSQL(insertRow, new String[]{"24.077 км/ч"});
                    break;
                case 10:
                    db.execSQL(insertRow, new String[]{"1.026 дней"});
                    break;
                case 11:
                    db.execSQL(insertRow, new String[]{"687 дней"});
                    break;
                case 12:
                    db.execSQL(insertRow, new String[]{"227.940.000\nкм"});
                    break;
                case 13:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 14:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 15:
                    db.execSQL(insertRow, new String[]{"Нет"});
                    break;
                case 16:
                    db.execSQL(insertRow, new String[]{"Очень разреженная"});
                    break;
                case 17:
                    db.execSQL(insertRow, new String[]{"Тропосфера\nстратосфера"});
                    break;
                case 18:
                    db.execSQL(insertRow, new String[]{"Кора\nмантия\nядро"});
                    break;
                case 19:
                    db.execSQL(insertRow, new String[]{"Красный цвет\nНаличие полярных\nшапок каньонов\nвулканов и ударных\nкратеров и двух\nспутников"});
                    break;
            }
        }

        // Добавляем 19 строк в столбец column_Jupiter
        for (int i = 1; i <= 19; i++) {
            String insertRow = "INSERT INTO planet_table (column_Jupiter) VALUES (?)";
            switch (i) {
                case 1:
                    db.execSQL(insertRow, new String[]{"Юпитер"});
                    break;
                case 2:
                    db.execSQL(insertRow, new String[]{"69,911 км"});
                    break;
                case 3:
                    db.execSQL(insertRow, new String[]{"1.898 × 10^27\nкг"});
                    break;
                case 4:
                    db.execSQL(insertRow, new String[]{"1,326 кг/м³"});
                    break;
                case 5:
                    db.execSQL(insertRow, new String[]{"-145°C"});
                    break;
                case 6:
                    db.execSQL(insertRow, new String[]{"79"});
                    break;
                case 7:
                    db.execSQL(insertRow, new String[]{"Европа\nКаллисто\nИо\nГанимед"});
                    break;
                case 8:
                    db.execSQL(insertRow, new String[]{"12.684 км/ч"});
                    break;
                case 9:
                    db.execSQL(insertRow, new String[]{"13.062 км/ч"});
                    break;
                case 10:
                    db.execSQL(insertRow, new String[]{"9.925 часов"});
                    break;
                case 11:
                    db.execSQL(insertRow, new String[]{"11.862 земных\nгода"});
                    break;
                case 12:
                    db.execSQL(insertRow, new String[]{"778.340.000\nкм"});
                    break;
                case 13:
                    db.execSQL(insertRow, new String[]{"Есть"});
                    break;
                case 14:
                    db.execSQL(insertRow, new String[]{"4 основных"});
                    break;
                case 15:
                    db.execSQL(insertRow, new String[]{"Газовый гигант"});
                    break;
                case 16:
                    db.execSQL(insertRow, new String[]{"Есть"});
                    break;
                case 17:
                    db.execSQL(insertRow, new String[]{"Тропосфера\nСтратосфера\nМезосфера\nТермосфера"});
                    break;
                case 18:
                    db.execSQL(insertRow, new String[]{"Горячая\nмантийная зона\nядро"});
                    break;
                case 19:
                    db.execSQL(insertRow, new String[]{"Самая большая\nпланета в Солнечной\nсистеме\nНаличие сильного\nмагнитного поля\nВеликолепные полосы\nи штормовые\nобразования"});
                    break;
            }
        }

        // Добавляем 19 строк в столбец column_Saturn
        for (int i = 1; i <= 19; i++) {
            String insertRow = "INSERT INTO planet_table (column_Saturn) VALUES (?)";
            switch (i) {
                case 1:
                    db.execSQL(insertRow, new String[]{"Сатурн"});
                    break;
                case 2:
                    db.execSQL(insertRow, new String[]{"58,232 км"});
                    break;
                case 3:
                    db.execSQL(insertRow, new String[]{"5.683 × 10^26\nкг"});
                    break;
                case 4:
                    db.execSQL(insertRow, new String[]{"0.687 кг/м³"});
                    break;
                case 5:
                    db.execSQL(insertRow, new String[]{"-185°C"});
                    break;
                case 6:
                    db.execSQL(insertRow, new String[]{"82"});
                    break;
                case 7:
                    db.execSQL(insertRow, new String[]{"Титан\nРея\nДиона\nТефия\nЭнцелад"});
                    break;
                case 8:
                    db.execSQL(insertRow, new String[]{"9.690 км/ч"});
                    break;
                case 9:
                    db.execSQL(insertRow, new String[]{"9.690 км/ч"});
                    break;
                case 10:
                    db.execSQL(insertRow, new String[]{"10.656 часов"});
                    break;
                case 11:
                    db.execSQL(insertRow, new String[]{"29.457\nземных лет"});
                    break;
                case 12:
                    db.execSQL(insertRow, new String[]{"1,429.400.000\nкм"});
                    break;
                case 13:
                    db.execSQL(insertRow, new String[]{"Есть"});
                    break;
                case 14:
                    db.execSQL(insertRow, new String[]{"Многочисленные\n7 основных"});
                    break;
                case 15:
                    db.execSQL(insertRow, new String[]{"Газовый гигант"});
                    break;
                case 16:
                    db.execSQL(insertRow, new String[]{"Есть"});
                    break;
                case 17:
                    db.execSQL(insertRow, new String[]{"Тропосфера\nСтратосфера\nТермосфера"});
                    break;
                case 18:
                    db.execSQL(insertRow, new String[]{"Горячая\nмантийная зона\nядро"});
                    break;
                case 19:
                    db.execSQL(insertRow, new String[]{"Наличие спутника\nТитана с атмосферой\nи органическими\nмолекулами\nНаличие спутника\nЭнцелада с\nгейзерами\nводяного льда"});
                    break;
            }
        }

        // Добавляем 19 строк в столбец column_Uranus
        for (int i = 1; i <= 19; i++) {
            String insertRow = "INSERT INTO planet_table (column_Uranus) VALUES (?)";
            switch (i) {
                case 1:
                    db.execSQL(insertRow, new String[]{"Уран"});
                    break;
                case 2:
                    db.execSQL(insertRow, new String[]{"25,362 км"});
                    break;
                case 3:
                    db.execSQL(insertRow, new String[]{"8.681 × 10^25\nкг"});
                    break;
                case 4:
                    db.execSQL(insertRow, new String[]{"1.270 кг/м³"});
                    break;
                case 5:
                    db.execSQL(insertRow, new String[]{"-206°C"});
                    break;
                case 6:
                    db.execSQL(insertRow, new String[]{"27"});
                    break;
                case 7:
                    db.execSQL(insertRow, new String[]{"Ариэль\nУмбриэль\nТитания\nОберон"});
                    break;
                case 8:
                    db.execSQL(insertRow, new String[]{"6.810 км/ч"});
                    break;
                case 9:
                    db.execSQL(insertRow, new String[]{"6.810 км/ч"});
                    break;
                case 10:
                    db.execSQL(insertRow, new String[]{"17.24 часов"});
                    break;
                case 11:
                    db.execSQL(insertRow, new String[]{"84.016\nземных лет"});
                    break;
                case 12:
                    db.execSQL(insertRow, new String[]{"2,870.990.000\nкм"});
                    break;
                case 13:
                    db.execSQL(insertRow, new String[]{"Есть"});
                    break;
                case 14:
                    db.execSQL(insertRow, new String[]{"13 основных"});
                    break;
                case 15:
                    db.execSQL(insertRow, new String[]{"Ледяной гигант"});
                    break;
                case 16:
                    db.execSQL(insertRow, new String[]{"Есть"});
                    break;
                case 17:
                    db.execSQL(insertRow, new String[]{"Тропосфера\nСтратосфера\nТермосфера"});
                    break;
                case 18:
                    db.execSQL(insertRow, new String[]{"Горячая\nмантийная зона\nядро"});
                    break;
                case 19:
                    db.execSQL(insertRow, new String[]{"Планета вращается\nпод углом 97.77°\nНаличие метана\nв атмосфере"});
                    break;
            }
        }


        // Добавляем 19 строк в столбец column_Neptune
        for (int i = 1; i <= 19; i++) {
            String insertRow = "INSERT INTO planet_table (column_Neptune) VALUES (?)";
            switch (i) {
                case 1:
                    db.execSQL(insertRow, new String[]{"Нептун"});
                    break;
                case 2:
                    db.execSQL(insertRow, new String[]{"24,764 км"});
                    break;
                case 3:
                    db.execSQL(insertRow, new String[]{"1.024 × 10^26\nкг"});
                    break;
                case 4:
                    db.execSQL(insertRow, new String[]{"1.638 кг/м³"});
                    break;
                case 5:
                    db.execSQL(insertRow, new String[]{"-201°C"});
                    break;
                case 6:
                    db.execSQL(insertRow, new String[]{"14"});
                    break;
                case 7:
                    db.execSQL(insertRow, new String[]{"Тритон\nНерида"});
                    break;
                case 8:
                    db.execSQL(insertRow, new String[]{"5.436 км/ч"});
                    break;
                case 9:
                    db.execSQL(insertRow, new String[]{"5.436 км/ч"});
                    break;
                case 10:
                    db.execSQL(insertRow, new String[]{"16.11 часов"});
                    break;
                case 11:
                    db.execSQL(insertRow, new String[]{"164.79\nземных лет"});
                    break;
                case 12:
                    db.execSQL(insertRow, new String[]{"4,495.100.000\nкм"});
                    break;
                case 13:
                    db.execSQL(insertRow, new String[]{"Есть"});
                    break;
                case 14:
                    db.execSQL(insertRow, new String[]{"5 основных"});
                    break;
                case 15:
                    db.execSQL(insertRow, new String[]{"Ледяной гигант"});
                    break;
                case 16:
                    db.execSQL(insertRow, new String[]{"Есть"});
                    break;
                case 17:
                    db.execSQL(insertRow, new String[]{"Тропосфера\nСтратосфера\nТермосфера"});
                    break;
                case 18:
                    db.execSQL(insertRow, new String[]{"Горячая\nмантийная зона\nядро"});
                    break;
                case 19:
                    db.execSQL(insertRow, new String[]{"Метан в атмосфере\nНаличие сильных\nветров и штормов\nСамая дальняя\nпланета от Солнца"});
                    break;
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String command = String.format("DROP TABLE IF EXISTS %s", TABLE);
        db.execSQL(command);
        onCreate(db);
    }
}
