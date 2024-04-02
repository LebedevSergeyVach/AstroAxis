package astro.axis.planet.libgdx;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class TestsActivity extends AppCompatActivity {
    private static final String TAG = "APP:TestsActivity";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        Log.d(TAG, "Start TestsActivity");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Создайте список кнопок
        ArrayList<String> buttonList = new ArrayList<>();
        buttonList.add("Тест 1");
        buttonList.add("Тест 2");
        buttonList.add("Тест 3");
        buttonList.add("тест 4");
        buttonList.add("Тест 5");
        buttonList.add("Тест 6");
        buttonList.add("Тест 7");
        buttonList.add("Тест 8");
        buttonList.add("Тест 9");
        buttonList.add("Главное меню");

        // Создайте адаптер для списка кнопок

        // Создайте адаптер для списка кнопок
        adapter = new ButtonAdapter(buttonList);
        recyclerView.setAdapter(adapter);

        ((ButtonAdapter) adapter).setOnButtonClickListener(position -> {
            if (position == 0) {
                Intent intent = new Intent(TestsActivity.this, TestActivity.class);
                intent.putExtra("planetName", "Меркурий");
                startActivity(intent);
            }

            if (position == 1) {
                Intent intent = new Intent(TestsActivity.this, TestActivity.class);
                intent.putExtra("planetName", "Венера");
                startActivity(intent);

            }

            if (position == 2) {
                Intent intent = new Intent(TestsActivity.this, TestActivity.class);
                intent.putExtra("planetName", "Земля");
                startActivity(intent);

            }

            if (position == 3) {
                Intent intent = new Intent(TestsActivity.this, TestActivity.class);
                intent.putExtra("planetName", "Марс");
                startActivity(intent);

            }

            if (position == 4) {
                Intent intent = new Intent(TestsActivity.this, TestActivity.class);
                intent.putExtra("planetName", "Юпитер");
                startActivity(intent);
            }

            if (position == 5) {
                Intent intent = new Intent(TestsActivity.this, TestActivity.class);
                intent.putExtra("planetName", "Сатурн");
                startActivity(intent);

            }

            if (position == 6) {
                Intent intent = new Intent(TestsActivity.this, TestActivity.class);
                intent.putExtra("planetName", "Уран");
                startActivity(intent);

            }

            if (position == 7) {
                Intent intent = new Intent(TestsActivity.this, TestActivity.class);
                intent.putExtra("planetName", "Нептун");
                startActivity(intent);

            }

            if (position == 8) {
                Intent intent = new Intent(TestsActivity.this, TestActivity.class);
                intent.putExtra("planetName", "Плутон");
                startActivity(intent);

            }

            if (position == 9) {
                Intent intent = new Intent(TestsActivity.this, MainMenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
