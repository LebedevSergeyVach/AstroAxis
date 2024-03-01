package com.example.astroaxis;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "APP:MainActivity";
    private static final int REGISTRATION_REQUEST_CODE = 1;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Start MainActivity and application");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Создайте список кнопок
        ArrayList<String> buttonList = new ArrayList<>();
        buttonList.add("Меркурий");
        buttonList.add("Венера");
        buttonList.add("Земля");
        buttonList.add("Марс");
        buttonList.add("Юпитер");
        buttonList.add("Сатурн");
        buttonList.add("Уран");
        buttonList.add("Нептун");
        buttonList.add("Плутон");

        // Создайте адаптер для списка кнопок
        adapter = new ButtonAdapter(buttonList);
        recyclerView.setAdapter(adapter);

        ((ButtonAdapter) adapter).setOnButtonClickListener(position -> {
            if (position == 0) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra("planetName", "Меркурий");
                startActivity(intent);
            }

            if (position == 1) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra("planetName", "Венера");
                startActivity(intent);

            }

            if (position == 2) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra("planetName", "Земля");
                startActivity(intent);

            }

            if (position == 3) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra("planetName", "Марс");
                startActivity(intent);

            }

            if (position == 4) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra("planetName", "Юпитер");
                startActivity(intent);
            }

            if (position == 5) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra("planetName", "Сатурн");
                startActivity(intent);

            }

            if (position == 6) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra("planetName", "Уран");
                startActivity(intent);

            }

            if (position == 7) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra("planetName", "Нептун");
                startActivity(intent);

            }

            if (position == 8) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra("planetName", "Плутон");
                startActivity(intent);

            }
        });
    }
}
