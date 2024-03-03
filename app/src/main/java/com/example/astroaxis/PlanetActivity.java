package com.example.astroaxis;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class PlanetActivity extends AppCompatActivity {
    private static final String TAG = "APP:PlanetActivity";

    private TextView planetNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_planet_upheaval);
        } else {
            setContentView(R.layout.activity_planet);
        }

        Log.d(TAG, "Start PlanetActivity");

        planetNameTextView = findViewById(R.id.planetName);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("planetName")) {
            String planetName = intent.getStringExtra("planetName");
            planetNameTextView.setText(planetName);
        }
    }
}
