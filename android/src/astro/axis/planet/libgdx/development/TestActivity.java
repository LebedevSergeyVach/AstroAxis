package astro.axis.planet.libgdx.development;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import astro.axis.planet.libgdx.R;

public class TestActivity extends AppCompatActivity {
    private static final String TAG = "APP:TestActivity";

    private TextView planetNameTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Log.d(TAG, "Start TestActivity");

        planetNameTextView = findViewById(R.id.planetName);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("planetName")) {
            String planetName = intent.getStringExtra("planetName");
            planetNameTextView.setText(planetName);
        }
    }
}
