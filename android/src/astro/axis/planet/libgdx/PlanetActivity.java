package astro.axis.planet.libgdx;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class PlanetActivity extends AppCompatActivity {
    private static final String TAG = "APP:PlanetActivity";

    private TextView planetNameTextView;
    private Button modelButton;

    private static String planetName;

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
            planetName = intent.getStringExtra("planetName");
            planetNameTextView.setText(planetName);
            Log.e(TAG, "planetName  =>   " + planetName);
        }

        modelButton = findViewById(R.id.modelButton);

        if (planetName.equals(getString(R.string.Sun))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Sun));
                startActivity(intentName);
            });
        }  else if (planetName.equals(getString(R.string.Mercury))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Mercury));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Venus))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Venus));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Earth))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Earth));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Mars))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Mars));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Jupiter))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Jupiter));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Saturn))) {
            modelButton.setOnClickListener(view -> {


                Log.d(TAG, "The transition of their PlanetActivity to MainActivity");
                Intent intentHome = new Intent(PlanetActivity.this, MainMenuActivity.class);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentHome);
                finish();


            });
        } else if (planetName.equals(getString(R.string.Uranium))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Uranium));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Neptune))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Neptune));
                startActivity(intentName);
            });
        } else if (planetName.equals(getString(R.string.Pluto))) {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to AndroidLauncher");
                Intent intentName = new Intent(PlanetActivity.this, AndroidLauncher.class);
                intentName.putExtra(getString(R.string.planetName), getString(R.string.Pluto));
                startActivity(intentName);
            });
        }













        else {
            modelButton.setOnClickListener(view -> {
                Log.d(TAG, "The transition of their PlanetActivity to MainActivity");
                Intent intentHome = new Intent(PlanetActivity.this, MainMenuActivity.class);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentHome);
                finish();
            });
        }

    }
}
