package astro.axis.planet.libgdx.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.view.GestureDetector;
import android.view.MotionEvent;
import astro.axis.planet.libgdx.R;
import astro.axis.planet.libgdx.helper.SwipeGestureListener;


public class HelpActivity extends AppCompatActivity {
    private static final String TAG = "APP:HelpActivity";

    private Button backButton;
    private ImageView openGitHubButton, openRuStoreButton;
    private TextView helpTextView;

    private GestureDetector gestureDetector;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gestureDetector = new GestureDetector(new SwipeGestureListener(this));
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_help_upheaval);
        } else {
            setContentView(R.layout.activity_help);
        }

        Log.d(TAG, "Start HelpActivity");

        openGitHubButton = findViewById(R.id.openGithubButton);
        openRuStoreButton = findViewById(R.id.openRuStoreButton);
        backButton = findViewById(R.id.backButton);

        openGitHubButton.setOnClickListener(view -> {
            Log.d(TAG, "~~~ Pressing the button 'open_github' ~~~");

            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(getString(R.string.link_GitHub))));
        });

        openRuStoreButton.setOnClickListener(view -> {
            Log.d(TAG, "~~~ Pressing the button 'open_rustore' ~~~");

            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(getString(R.string.link_RuStore))));
        });

        backButton.setOnClickListener(view -> {
            Log.d(TAG, "~~~ Pressing the button 'exit' ~~~");
            finish();
        });

        helpTextView = findViewById(R.id.help_text);

        textDisplayView(helpTextView, R.string.help_text, R.color.white, 18);
    }

    private void textDisplayView(TextView textView, int stringIdText, int colorIdText, int textSize) {
        textView.setText(getString(stringIdText));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        textView.setTextColor(getResources().getColor(colorIdText));
        textView.setGravity(Gravity.CENTER);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
