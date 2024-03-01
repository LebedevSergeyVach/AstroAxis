package com.example.astroaxis;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;


public class PlanetActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet);

        Log.d(TAG, "Start PlanetActivity");
    }
}
