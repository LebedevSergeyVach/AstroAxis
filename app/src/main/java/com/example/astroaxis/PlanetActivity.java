package com.example.astroaxis;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class PlanetActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet);

        Log.d(TAG, "Start PlanetActivity");
    }
}
