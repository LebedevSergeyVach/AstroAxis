package astro.axis.planet.libgdx;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {
    private static final String TAG = "APP:HelpActivity";

    private Button exit;
    private ImageView openGitHubButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_help_upheaval);
        } else {
            setContentView(R.layout.activity_help);
        }

        Log.d(TAG, "Start HelpActivity");

        openGitHubButton = findViewById(R.id.openGithubButton);
        exit = findViewById(R.id.exit);

        openGitHubButton.setOnClickListener(view -> {
            Log.d(TAG, "~~~ Pressing the button 'open_github' ~~~");

            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://github.com/LebedevSergeyVach/AstroAxis")));
        });

        exit.setOnClickListener(view -> {
            Log.d(TAG, "~~~ Pressing the button 'exit' ~~~");

            Intent intent = new Intent(HelpActivity.this, MainMenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}
