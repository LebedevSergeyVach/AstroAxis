package com.example.astroaxis;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

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
        buttonList.add("Кнопка 1");
        buttonList.add("Кнопка 2");
        buttonList.add("Кнопка 3");
        buttonList.add("Кнопка 4");
        buttonList.add("Кнопка 5");
        buttonList.add("Кнопка 6");
        buttonList.add("Кнопка 7");
        buttonList.add("Кнопка 8");
        buttonList.add("Кнопка 9");
        buttonList.add("Кнопка 10");

        // Создайте адаптер для списка кнопок
        adapter = new ButtonAdapter(buttonList);
        recyclerView.setAdapter(adapter);
    }
}
