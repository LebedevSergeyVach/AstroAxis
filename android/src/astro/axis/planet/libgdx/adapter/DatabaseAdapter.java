package astro.axis.planet.libgdx.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import astro.axis.planet.libgdx.helper.DatabaseHelper;

public class DatabaseAdapter {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public DatabaseAdapter(Context context) {
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }

    public DatabaseAdapter open() {
        database = dbHelper.getWritableDatabase();
        return this;
    }
}
