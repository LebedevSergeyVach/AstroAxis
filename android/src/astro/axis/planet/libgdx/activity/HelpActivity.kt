package astro.axis.planet.libgdx.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.GestureDetector
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import astro.axis.planet.libgdx.R
import astro.axis.planet.libgdx.helper.SwipeGestureListener

class HelpActivity : AppCompatActivity() {
    private var backButton: Button? = null
    private var openGitHubButton: ImageView? = null
    private var openRuStoreButton: ImageView? = null
    private var helpTextView: TextView? = null

    private var gestureDetector: GestureDetector? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gestureDetector = GestureDetector(SwipeGestureListener(this))
        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_help_upheaval)
        } else {
            setContentView(R.layout.activity_help)
        }

        Log.d(TAG, "Start HelpActivity")

        openGitHubButton = findViewById(R.id.openGithubButton)
        openRuStoreButton = findViewById(R.id.openRuStoreButton)
        backButton = findViewById(R.id.backButton)

        openGitHubButton.setOnClickListener(View.OnClickListener { view: View? ->
            Log.d(TAG, "~~~ Pressing the button 'open_github' ~~~")
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(getString(R.string.link_GitHub))))
        })

        openRuStoreButton.setOnClickListener(View.OnClickListener { view: View? ->
            Log.d(TAG, "~~~ Pressing the button 'open_rustore' ~~~")
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(getString(R.string.link_RuStore))))
        })

        backButton.setOnClickListener(View.OnClickListener { view: View? ->
            Log.d(TAG, "~~~ Pressing the button 'exit' ~~~")
            finish()
        })

        helpTextView = findViewById(R.id.help_text)

        textDisplayView(helpTextView, R.string.help_text, R.color.white, 18)
    }

    private fun textDisplayView(textView: TextView?, stringIdText: Int, colorIdText: Int, textSize: Int) {
        textView!!.text = getString(stringIdText)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.toFloat())
        textView.setTextColor(resources.getColor(colorIdText))
        textView.gravity = Gravity.CENTER
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector!!.onTouchEvent(event)
    }

    companion object {
        private const val TAG = "APP:HelpActivity"
    }
}
