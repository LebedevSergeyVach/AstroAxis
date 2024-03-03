package com.example.astroaxis;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;

public class MainMenuActivity extends AppCompatActivity {
    private static final String TAG = "APP:MainMenu";

    private Button planetsButton, testsButton, helpButton, exitButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Log.d(TAG, "Start Application and MainMenuActivity");

        planetsButton = findViewById(R.id.planetsButton);
        testsButton = findViewById(R.id.testsButton);
        helpButton = findViewById(R.id.helpButton);
        exitButton = findViewById(R.id.exitButton);

        planetsButton.setOnClickListener(view -> {
            Log.d(TAG, "The transition of their MainMenuActivity to MainActivity");

            startActivity(new Intent(MainMenuActivity.this, MainActivity.class));
        });

        testsButton.setOnClickListener(view -> {
            Log.d(TAG, "The transition of their MainMenuActivity to TestsActivity");

            startActivity(new Intent(MainMenuActivity.this, TestsActivity.class));
        });

        helpButton.setOnClickListener(view -> {
            Log.d(TAG, "The transition of their MainMenuActivity to HelpActivity");

            startActivity(new Intent(MainMenuActivity.this, HelpActivity.class));
        });

        exitButton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainMenuActivity.this);
            builder.setMessage("Вы точно хотите выйти из приложения ?! \uD83E\uDD76\uD83E\uDD76\uD83E\uDD76");
            builder.setTitle("Выход");
            builder.setCancelable(false);

            builder.setPositiveButton("Да \uD83D\uDE2D", (dialog, which) -> {
                finishAffinity();
                System.exit(0);
            });

            builder.setNegativeButton("Нет \uD83D\uDE01", (dialog, which) -> {
                dialog.cancel();
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });

    }
}
