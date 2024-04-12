package astro.axis.planet.libgdx;

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
import android.view.GestureDetector.SimpleOnGestureListener;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "APP:MainActivity";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private GestureDetector gestureDetector;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureDetector = new GestureDetector(this, new MyGestureListener());

        Log.d(TAG, "Start MainActivity and application");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Создайте список кнопок
        ArrayList<String> buttonList = new ArrayList<>();
//        buttonList.add(getString(R.string.Sun));
        buttonList.add(getString(R.string.Mercury));
        buttonList.add(getString(R.string.Venus));
        buttonList.add(getString(R.string.Earth));
        buttonList.add(getString(R.string.Mars));
        buttonList.add(getString(R.string.Jupiter));
        buttonList.add(getString(R.string.Saturn));
        buttonList.add(getString(R.string.Uranium));
        buttonList.add(getString(R.string.Neptune));
//        buttonList.add(getString(R.string.Pluto));
//        buttonList.add(getString(R.string.theory));
        buttonList.add(getString(R.string.main_menu));

        // Создайте адаптер для списка кнопок
        adapter = new ButtonAdapter(buttonList);
        recyclerView.setAdapter(adapter);

        ((ButtonAdapter) adapter).setOnButtonClickListener(position -> {
//            if (position == 0) {
//                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
//                intent.putExtra(getString(R.string.planetName), getString(R.string.Sun));
//                startActivity(intent);
//            }

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

//            if (position == 9) {
//                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
//                intent.putExtra(getString(R.string.planetName), getString(R.string.Pluto));
//                startActivity(intent);
//            }

//            if (position == 10) {
//                startActivity(new Intent(MainActivity.this, TheoryActivity.class));
//            }

            if (position == 8) {
                Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
        }
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
            Log.d("MyActivity", "onFling called");
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
