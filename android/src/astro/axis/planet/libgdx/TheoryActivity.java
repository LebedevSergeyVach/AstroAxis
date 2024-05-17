package astro.axis.planet.libgdx;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;


public class TheoryActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;

    private Button openGLinkGuideButton, exitButton;

    private TableLayout tableLayout;
    private TextView schematicView, horizontalView;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gestureDetector = new GestureDetector(new SwipeGestureListener(this));
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_theory_upheaval);
        } else {
            setContentView(R.layout.activity_theory);
        }

        openGLinkGuideButton = findViewById(R.id.openGLinkGuideButton);
        exitButton = findViewById(R.id.backButton);

        openGLinkGuideButton.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(getString(R.string.link_guide_pdf))));
        });

        exitButton.setOnClickListener(view -> finish());

        tableLayout = findViewById(R.id.tableLayout);

        String[][] data = {
                {"Астроном. единица", "Перевод в единицы измерения"},
                {"Парсек", "4,848 * 10-⁶"},
                {"Световой год", "4,848 * 10-⁶"},
                {"Километр", "1,496 * 10⁸"},

                {""},
                {"Парсек", "Перевод в единицы измерения"},
                {"Астроном. единица", "206 265"},
                {"Световой год", "3,26"},
                {"Километр", "3,086 * 10¹³"},

                {""},
                {"Световой год", "Перевод в единицы измерения"},
                {"Астроном. единица", "63 241"},
                {"Парсек", "0,306"},
                {"Километр", "9,461 * 10¹²"},
        };

        for (String[] row : data) {
            TableRow tableRow = new TableRow(this);
            tableRow.setBackgroundResource(R.drawable.table_border); // Добавляем фоновый рисунок для линий
            for (String cell : row) {
                TextView textView = new TextView(this);
                textView.setText(cell);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25); // Устанавливаем размер текста
                textView.setTextColor(getColor(R.color.white)); // Устанавливаем цвет текста
                textView.setPadding(50, 15, 50, 15);
//                textView.setBackgroundResource(R.drawable.cell_border); // Добавляем фоновый рисунок для линий
                textView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)); // Добавляем параметры для переноса текста
                tableRow.addView(textView);

                // Устанавливаем ваш шрифт
                Typeface typeface = ResourcesCompat.getFont(this, R.font.samsungone700c);
                textView.setTypeface(typeface);
            }
            tableLayout.addView(tableRow);
        }

        schematicView = findViewById(R.id.schematic_representation_of_the_celestial_sphere_text);
        horizontalView = findViewById(R.id.horizontal_coordinate_system_text);

        schematicView.setText(getString(R.string.description_schematic_representation_of_the_celestial_sphere));
        schematicView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        schematicView.setTextColor(getResources().getColor(R.color.white));
        schematicView.setGravity(Gravity.CENTER);

        horizontalView.setText(getString(R.string.description_horizontal_coordinate_system));
        horizontalView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        horizontalView.setTextColor(getResources().getColor(R.color.white));
        horizontalView.setGravity(Gravity.CENTER);

        ImageView schematicImageView = findViewById(R.id.schematic_image);
        schematicImageView.setImageResource(R.drawable.schematic_representation_of_the_celestial_sphere);
        schematicImageView.setColorFilter(null);

        ImageView horizontalImageView = findViewById(R.id.horizontal_image);
        horizontalImageView.setImageResource(R.drawable.horizontal_coordinate_system);
        horizontalImageView.setColorFilter(null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
