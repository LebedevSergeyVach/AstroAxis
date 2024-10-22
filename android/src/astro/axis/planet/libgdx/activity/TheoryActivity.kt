package astro.axis.planet.libgdx.activity

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.TypedValue
import android.view.GestureDetector
import android.view.Gravity
import android.view.MotionEvent
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import astro.axis.planet.libgdx.R
import astro.axis.planet.libgdx.helper.PlanetDataArray
import astro.axis.planet.libgdx.helper.SwipeGestureListener

@Suppress("DEPRECATION")
class TheoryActivity : AppCompatActivity() {

    private lateinit var gestureDetector: GestureDetector
    private lateinit var openGLinkGuideButton: Button
    private lateinit var exitButton: Button
    private lateinit var tableLayout: TableLayout
    private lateinit var schematicView: TextView
    private lateinit var horizontalView: TextView

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gestureDetector = GestureDetector(SwipeGestureListener(this))
        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_theory_upheaval)
        } else {
            setContentView(R.layout.activity_theory)
        }

        openGLinkGuideButton = findViewById(R.id.openGLinkGuideButton)
        exitButton = findViewById(R.id.backButton)

        openGLinkGuideButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(getString(R.string.link_guide_pdf))))
        }

        exitButton.setOnClickListener { finish() }

        tableLayout = findViewById(R.id.tableLayout)

        val dataTheory = PlanetDataArray()
        val data = dataTheory.getTheoryData()

        for (row in data) {
            val tableRow = TableRow(this)
            tableRow.setBackgroundResource(R.drawable.table_border) // Добавляем фоновый рисунок для линий
            for (cell in row) {
                val textView = TextView(this)
                textView.text = cell
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25f) // Устанавливаем размер текста
                textView.setTextColor(resources.getColor(R.color.white)) // Устанавливаем цвет текста
                textView.setPadding(20, 15, 20, 15)
                // textView.setBackgroundResource(R.drawable.cell_border); // Добавляем фоновый рисунок для линий
                textView.layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f) // Добавляем параметры для переноса текста
                tableRow.addView(textView)

                // Устанавливаем ваш шрифт
                val typeface = ResourcesCompat.getFont(this, R.font.samsungone700c)
                textView.typeface = typeface
            }
            tableLayout.addView(tableRow)
        }

        schematicView = findViewById(R.id.schematic_representation_of_the_celestial_sphere_text)
        horizontalView = findViewById(R.id.horizontal_coordinate_system_text)

        textDisplayView(schematicView, R.string.description_schematic_representation_of_the_celestial_sphere, R.color.white, 20)
        textDisplayView(horizontalView, R.string.description_horizontal_coordinate_system, R.color.white, 20)

        val schematicImageView = findViewById<ImageView>(R.id.schematic_image)
        val horizontalImageView = findViewById<ImageView>(R.id.horizontal_image)

        imageDisplayView(schematicImageView, R.drawable.schematic_representation_of_the_celestial_sphere)
        imageDisplayView(horizontalImageView, R.drawable.horizontal_coordinate_system)
    }

    private fun textDisplayView(textView: TextView, stringIdText: Int, colorIdText: Int, textSize: Int) {
        textView.text = getString(stringIdText)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.toFloat())
        textView.setTextColor(resources.getColor(colorIdText))
        textView.gravity = Gravity.CENTER
    }

    private fun imageDisplayView(imageView: ImageView, drawableIdImage: Int) {
        imageView.setImageResource(drawableIdImage)
        imageView.colorFilter = null

        fullScreenImage(imageView, drawableIdImage)
    }

    private fun fullScreenImage(nameImage: ImageView, drawableIdImage: Int) {
        nameImage.setOnClickListener {
            // Создаем диалог
            val dialog = Dialog(this, R.style.FullScreenDialogStyle)
            dialog.setContentView(R.layout.dialog_full_screen_image)

            // Получаем ImageView из диалога и устанавливаем изображение
            val fullScreenImageView = dialog.findViewById<ImageView>(R.id.full_screen_image)
            fullScreenImageView.setImageResource(drawableIdImage)

            // Отображаем диалог
            dialog.show()
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }
}
