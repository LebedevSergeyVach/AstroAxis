package astro.axis.planet.libgdx.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.MotionEvent;
import astro.axis.planet.libgdx.adapter.ButtonAdapter;
import astro.axis.planet.libgdx.R;
import astro.axis.planet.libgdx.helper.SwipeGestureListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "APP:MainActivity";

    // Объявление переменных для RecyclerView
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private GestureDetector gestureDetector;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gestureDetector = new GestureDetector(new SwipeGestureListener(this));
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_upheaval);
        } else {
            setContentView(R.layout.activity_main);
        }

        Log.d(TAG, "Start MainActivity and application");

        // Инициализация RecyclerView и его компонентов
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Создание списка кнопок
        ArrayList<String> buttonList = new ArrayList<>();
        buttonList.add(getString(R.string.Mercury));
        buttonList.add(getString(R.string.Venus));
        buttonList.add(getString(R.string.Earth));
        buttonList.add(getString(R.string.Mars));
        buttonList.add(getString(R.string.Jupiter));
        buttonList.add(getString(R.string.Saturn));
        buttonList.add(getString(R.string.Uranium));
        buttonList.add(getString(R.string.Neptune));
        buttonList.add(getString(R.string.main_menu));

        // Инициализация адаптера и установка его для RecyclerView
        adapter = new ButtonAdapter(buttonList);
        recyclerView.setAdapter(adapter);

        // Установка слушателя нажатий на кнопки в адаптере
        ((ButtonAdapter) adapter).setOnButtonClickListener(position -> {
            if (position == 0) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra(getString(R.string.planetName), getString(R.string.Mercury));
                startActivity(intent);
            }

            if (position == 1) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra(getString(R.string.planetName), getString(R.string.Venus));
                startActivity(intent);
            }

            if (position == 2) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra(getString(R.string.planetName), getString(R.string.Earth));
                startActivity(intent);
            }

            if (position == 3) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra(getString(R.string.planetName), getString(R.string.Mars));
                startActivity(intent);
            }

            if (position == 4) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra(getString(R.string.planetName), getString(R.string.Jupiter));
                startActivity(intent);
            }

            if (position == 5) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra(getString(R.string.planetName), getString(R.string.Saturn));
                startActivity(intent);
            }

            if (position == 6) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra(getString(R.string.planetName), getString(R.string.Uranium));
                startActivity(intent);
            }

            if (position == 7) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra(getString(R.string.planetName), getString(R.string.Neptune));
                startActivity(intent);
            }

            if (position == 8) {
                finish();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
