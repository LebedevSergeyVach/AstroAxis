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
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;


public class TheoryActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;

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

        Button openGLinkGuideButton = findViewById(R.id.openGLinkGuideButton);
        Button exitButton = findViewById(R.id.exitButton);

        openGLinkGuideButton.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://docs.yandex.ru/docs/view?tm=1712343804&tld=ru&lang=ru&name=65777082.pdf&text=Основные%20иены%20измерения%20астрономия%2011%20класс&url=https%3A%2F%2Fwww.litres.ru%2Fget_pdf_trial%2F65777082.pdf&lr=65&mime=pdf&l10n=ru&sign=5f049789bcb124afa918d794e59be610&keyno=0&serpParams=tm%3D1712343804%26tld%3Dru%26lang%3Dru%26name%3D65777082.pdf%26text%3D%25D0%259E%25D1%2581%25D0%25BD%25D0%25BE%25D0%25B2%25D0%25BD%25D1%258B%25D0%25B5%2B%25D0%25B8%25D0%25B5%25D0%25BD%25D1%258B%2B%25D0%25B8%25D0%25B7%25D0%25BC%25D0%25B5%25D1%2580%25D0%25B5%25D0%25BD%25D0%25B8%25D1%258F%2B%25D0%25B0%25D1%2581%25D1%2582%25D1%2580%25D0%25BE%25D0%25BD%25D0%25BE%25D0%25BC%25D0%25B8%25D1%258F%2B11%2B%25D0%25BA%25D0%25BB%25D0%25B0%25D1%2581%25D1%2581%26url%3Dhttps%253A%2F%2Fwww.litres.ru%2Fget_pdf_trial%2F65777082.pdf%26lr%3D65%26mime%3Dpdf%26l10n%3Dru%26sign%3D5f049789bcb124afa918d794e59be610%26keyno%3D0")));
        });

        exitButton.setOnClickListener(view -> finish());

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        String[][] data = {
                {"Астрон.\nединица"},
                {"Парсек", "4,848 * 10-⁶"},
                {"Световой\nгод", "4,848 * 10-⁶"},
                {"Километр", "1,496 * 10⁸"},

                {""},
                {"Парсек"},
                {"Астрон.\nединица", "206 265"},
                {"Световой\nгод", "3,26"},
                {"Километр", "3,086 * 10¹³"},

                {""},
                {"Световой\nгод"},
                {"Астрон.\nединица", "63 241"},
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
                tableRow.addView(textView);

                // Устанавливаем ваш шрифт
                Typeface typeface = ResourcesCompat.getFont(this, R.font.samsungone700c);
                textView.setTypeface(typeface);
            }
            tableLayout.addView(tableRow);
        }

        TextView schematicView = findViewById(R.id.schematic_representation_of_the_celestial_sphere_text);
        TextView horizontalView = findViewById(R.id.horizontal_coordinate_system_text);

        schematicView.setText(getString(R.string.description_schematic_representation_of_the_celestial_sphere));
        schematicView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        schematicView.setTextColor(getResources().getColor(R.color.white));
        schematicView.setGravity(Gravity.CENTER);

        horizontalView.setText(getString(R.string.description_horizontal_coordinate_system));
        horizontalView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        horizontalView.setTextColor(getResources().getColor(R.color.white));
        horizontalView.setGravity(Gravity.CENTER);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
