package astro.axis.planet.libgdx;

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


public class HelpActivity extends AppCompatActivity {
    private static final String TAG = "APP:HelpActivity";

    private Button exitButton;
    private ImageView openGitHubButton;
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
        exitButton = findViewById(R.id.exitButton);

        openGitHubButton.setOnClickListener(view -> {
            Log.d(TAG, "~~~ Pressing the button 'open_github' ~~~");

            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://github.com/LebedevSergeyVach/AstroAxis")));
        });

        exitButton.setOnClickListener(view -> {
            Log.d(TAG, "~~~ Pressing the button 'exit' ~~~");
//            Intent intent = new Intent(HelpActivity.this, MainMenuActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
            finish();
        });

        TextView helpTextView = findViewById(R.id.help_text);
        helpTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        helpTextView.setText(getString(R.string.help_text));
        helpTextView.setTextColor(getResources().getColor(R.color.white));
        helpTextView.setGravity(Gravity.CENTER);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
