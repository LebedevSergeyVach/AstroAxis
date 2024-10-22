package astro.axis.planet.libgdx.activity

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.Gravity
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import astro.axis.planet.libgdx.R
import astro.axis.planet.libgdx.helper.NotificationHelper.showNotification
import kotlin.math.abs

@Suppress("DEPRECATION")
class MainMenuActivity : AppCompatActivity() {
    private val TAG = "APP:MainMenu"

    private lateinit var planetsButton: Button
    private lateinit var theoryButton: Button
    private lateinit var helpButton: Button
    private lateinit var exitButton: Button
    private lateinit var applicationNameTextView: TextView
    private lateinit var descriptionApplicationNameTextView: TextView
    private var clickCount = 0

    private var gestureDetector: GestureDetector? = null

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gestureDetector = GestureDetector(this, MyGestureListener())

        val orientation = resources.configuration.orientation

        val textSizeButton: Int
        val textSizeApplicationName: Int
        val textSizeDescriptionApplication: Int
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_menu_upheaval)
            textSizeButton = 30
            textSizeApplicationName = 70
            textSizeDescriptionApplication = 18
        } else {
            setContentView(R.layout.activity_main_menu)
            textSizeButton = 19
            textSizeApplicationName = 58
            textSizeDescriptionApplication = 16
        }

        Log.d(TAG, "Start Application and MainMenuActivity")

        applicationNameTextView = findViewById(R.id.applicationName)
        descriptionApplicationNameTextView = findViewById(R.id.descriptionApplication)

        textDisplayView(applicationNameTextView, R.string.app_name, R.color.white, textSizeApplicationName)
        textDisplayView(
            descriptionApplicationNameTextView,
            R.string.description_name,
            R.color.white,
            textSizeDescriptionApplication
        )

        planetsButton = findViewById(R.id.planetsButton)
        theoryButton = findViewById(R.id.theoryButton)
        helpButton = findViewById(R.id.helpButton)
        exitButton = findViewById(R.id.backButton)

        buttonDisplayView(planetsButton, R.string.planets, 30, R.color.white)
        buttonDisplayView(theoryButton, R.string.theory, 30, R.color.white)
        buttonDisplayView(helpButton, R.string.help, textSizeButton, R.color.white)
        buttonDisplayView(exitButton, R.string.exit, textSizeButton, R.color.white)

        planetsButton.setOnClickListener {
            Log.d(TAG, "The transition of their MainMenuActivity to MainActivity")
            startActivity(Intent(this@MainMenuActivity, MainActivity::class.java))
        }

        theoryButton.setOnClickListener {
            Log.d(TAG, "The transition of their MainMenuActivity to TestsActivity")
            startActivity(Intent(this@MainMenuActivity, TheoryActivity::class.java))
        }

        helpButton.setOnClickListener {
            Log.d(TAG, "The transition of their MainMenuActivity to HelpActivity")
            startActivity(Intent(this@MainMenuActivity, HelpActivity::class.java))
        }

        exitButton.setOnClickListener { exitApplication() }

        val nameApp = findViewById<TextView>(R.id.applicationName)

        nameApp.setOnClickListener {
            clickCount++
            if (clickCount == 5) {
                val browserIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/LebedevSergeyVach/AstroAxis"))
                showNotification(
                    this,
                    getString(R.string.app_name),
                    "Кликните и поставьте ⭐\uFE0F на GitHub",
                    browserIntent
                )

                clickCount = 0
            }
        }
    }

    private fun textDisplayView(textView: TextView?, stringIdText: Int, colorIdText: Int, textSize: Int) {
        textView!!.text = getString(stringIdText)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.toFloat())
        textView.setTextColor(resources.getColor(colorIdText))
        textView.gravity = Gravity.CENTER
    }

    private fun buttonDisplayView(
        buttonView: Button?,
        stringIdTextButton: Int,
        colorIdTextButton: Int,
        textSizeButton: Int
    ) {
        buttonView!!.text = getString(stringIdTextButton)
        buttonView.setTextSize(TypedValue.COMPLEX_UNIT_SP, colorIdTextButton.toFloat())
        buttonView.setTextColor(resources.getColor(textSizeButton))
        buttonView.gravity = Gravity.CENTER
    }

    private fun exitApplication() {
        AlertDialog.Builder(this, R.style.AlertDialogCustom)
            .setIcon(R.drawable.space)
            .setTitle(getString(R.string.exit_application))
            .setMessage(getString(R.string.confirmation_exit_application))
            .setPositiveButton("Да") { _: DialogInterface?, _: Int ->
                // Пользователь подтвердил выход, закрываем приложение
                finishAffinity()
            }
            .setNegativeButton("Нет", null)
            .show()
    }

    @Deprecated("Deprecated in Java")
    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        exitApplication()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector!!.onTouchEvent(event)
    }

    private inner class MyGestureListener : SimpleOnGestureListener() {
        private val SWIPE_MIN_DISTANCE = 200
        private val SWIPE_THRESHOLD_VELOCITY = 200

        override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            if (e1!!.x - e2.x < SWIPE_MIN_DISTANCE && abs(velocityX.toDouble()) > SWIPE_THRESHOLD_VELOCITY) {
                exitApplication()
            }
            return false
        }
    }
}
