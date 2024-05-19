package astro.axis.planet.libgdx;

import android.annotation.SuppressLint;
import android.app.Dialog;
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

        PlanetDataArray dataTheory = new PlanetDataArray();
        String[][] data = dataTheory.getTheoryData();

        for (String[] row : data) {
            TableRow tableRow = new TableRow(this);
            tableRow.setBackgroundResource(R.drawable.table_border); // Добавляем фоновый рисунок для линий
            for (String cell : row) {
                TextView textView = new TextView(this);
                textView.setText(cell);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25); // Устанавливаем размер текста
                textView.setTextColor(getColor(R.color.white)); // Устанавливаем цвет текста
                textView.setPadding(20, 15, 20, 15);
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

        textDisplayView(schematicView, R.string.description_schematic_representation_of_the_celestial_sphere, R.color.white, 20);
        textDisplayView(horizontalView, R.string.description_horizontal_coordinate_system, R.color.white, 20);


        ImageView schematicImageView = findViewById(R.id.schematic_image);
        ImageView horizontalImageView = findViewById(R.id.horizontal_image);

        imageDisplayView(schematicImageView, R.drawable.schematic_representation_of_the_celestial_sphere);
        imageDisplayView(horizontalImageView, R.drawable.horizontal_coordinate_system);
    }

    private void textDisplayView(TextView textView, int stringIdText, int colorIdText, int textSize) {
        textView.setText(getString(stringIdText));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        textView.setTextColor(getResources().getColor(colorIdText));
        textView.setGravity(Gravity.CENTER);
    }

    private void imageDisplayView(ImageView imageView, int drawableIdImage) {
        imageView.setImageResource(drawableIdImage);
        imageView.setColorFilter(null);

        fullScreenImage(imageView, drawableIdImage);
    }

    private void fullScreenImage(ImageView nameImage, int drawableIdImage) {
        nameImage.setOnClickListener(view -> {
            // Создаем диалог
            Dialog dialog = new Dialog(TheoryActivity.this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            dialog.setContentView(R.layout.dialog_full_screen_image);

            // Получаем ImageView из диалога и устанавливаем изображение
            ImageView fullScreenImageView = dialog.findViewById(R.id.full_screen_image);
            fullScreenImageView.setImageResource(drawableIdImage);

            // Отображаем диалог
            dialog.show();
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
