@file:Suppress("DEPRECATION")

package astro.axis.planet.libgdx.activity

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import astro.axis.planet.libgdx.R
import astro.axis.planet.libgdx.helper.PlanetDataArray
import astro.axis.planet.libgdx.helper.SwipeGestureListener
import astro.axis.planet.libgdx.launcher.AndroidLauncher
import java.util.concurrent.RejectedExecutionException

@Suppress("DEPRECATION")
class PlanetActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "APP:PlanetActivity"
        private var planetName: String? = null
    }

    private lateinit var modelButton: Button
    private lateinit var backButton: Button
    private lateinit var planetNameTextView: TextView
    private lateinit var tableLayout: TableLayout
    private lateinit var planetData: Array<Array<String>>
    private var progressDialog: ProgressDialog? = null
    private lateinit var gestureDetector: GestureDetector

    @SuppressLint("NewApi") // ДЛЯ GetColor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gestureDetector = GestureDetector(SwipeGestureListener(this))
        val orientation = resources.configuration.orientation
        val textSizeTable = if (orientation == Configuration.ORIENTATION_LANDSCAPE) 26 else 22

        setContentView(if (orientation == Configuration.ORIENTATION_LANDSCAPE) R.layout.activity_planet_upheaval else R.layout.activity_planet)

        Log.d(TAG, "Start PlanetActivity")

        planetNameTextView = findViewById(R.id.planetName)

        intent?.let {
            if (it.hasExtra("planetName")) {
                planetName = it.getStringExtra("planetName")
                planetNameTextView.text = planetName
                Log.e(TAG, "planetName  =>   $planetName")
            }
        }

        modelButton = findViewById(R.id.modelButton)
        backButton = findViewById(R.id.backButton)

        when (planetName) {
            getString(R.string.Sun) -> modelButton.setOnClickListener { openModelButton(getString(R.string.Sun)) }
            getString(R.string.Mercury) -> modelButton.setOnClickListener { openModelButton(getString(R.string.Mercury)) }
            getString(R.string.Venus) -> modelButton.setOnClickListener { openModelButton(getString(R.string.Venus)) }
            getString(R.string.Earth) -> modelButton.setOnClickListener { openModelButton(getString(R.string.Earth)) }
            getString(R.string.Mars) -> modelButton.setOnClickListener { openModelButton(getString(R.string.Mars)) }
            getString(R.string.Jupiter) -> modelButton.setOnClickListener { openModelButton(getString(R.string.Jupiter)) }
            getString(R.string.Saturn) -> modelButton.setOnClickListener { openModelButton(getString(R.string.Saturn)) }
            getString(R.string.Uranium) -> modelButton.setOnClickListener { openModelButton(getString(R.string.Uranium)) }
            getString(R.string.Neptune) -> modelButton.setOnClickListener { openModelButton(getString(R.string.Neptune)) }
            getString(R.string.Pluto) -> modelButton.setOnClickListener { openModelButton(getString(R.string.Pluto)) }
            else -> modelButton.setOnClickListener { exitMainMenuActivity(1) }
        }

        backButton.setOnClickListener { finish() }

        tableLayout = findViewById(R.id.tableLayout)
        planetData = getPlanetDataArray()

        for (row in planetData) {
            val tableRow = TableRow(this).apply {
                setBackgroundResource(R.drawable.table_border)
            }
            for (cell in row) {
                TextView(this).apply {
                    text = cell
                    textSize = textSizeTable.toFloat()
                    setTextColor(getColor(R.color.white))
                    setPadding(25, 20, 15, 20)
                    typeface = ResourcesCompat.getFont(this@PlanetActivity, R.font.samsungone700c)
                    layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
                }.also { tableRow.addView(it) }
            }
            tableLayout.addView(tableRow)
        }
    }

    private fun getPlanetDataArray(): Array<Array<String>> {
        val planetData = Array(19) { "" }
        val planetDataArray = PlanetDataArray()

        try {
            when (planetName) {
                getString(R.string.Mercury) -> planetDataArray.getPlanetData("mercury").copyInto(planetData)
                getString(R.string.Venus) -> planetDataArray.getPlanetData("venus").copyInto(planetData)
                getString(R.string.Earth) -> planetDataArray.getPlanetData("earth").copyInto(planetData)
                getString(R.string.Mars) -> planetDataArray.getPlanetData("mars").copyInto(planetData)
                getString(R.string.Jupiter) -> planetDataArray.getPlanetData("jupiter").copyInto(planetData)
                getString(R.string.Saturn) -> planetDataArray.getPlanetData("saturn").copyInto(planetData)
                getString(R.string.Uranium) -> planetDataArray.getPlanetData("uranus").copyInto(planetData)
                getString(R.string.Neptune) -> planetDataArray.getPlanetData("neptune").copyInto(planetData)
                else -> {
                    Log.e(TAG, "Unknown planet name: $planetName")
                    return emptyArray()
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error in getPlanetDataArray", e)
            return emptyArray()
        }

        return arrayOf(
            arrayOf(getString(R.string.name), planetData[0]),
            arrayOf(getString(R.string.radius), planetData[1]),
            arrayOf(getString(R.string.mass), planetData[2]),
            arrayOf(getString(R.string.density), planetData[3]),
            arrayOf(getString(R.string.average_temperature), planetData[4]),
            arrayOf(getString(R.string.number_of_satellites), planetData[5]),
            arrayOf(getString(R.string.main_satellites), planetData[6]),
            arrayOf(getString(R.string.the_speed_of_rotation_around_its_axis), planetData[7]),
            arrayOf(getString(R.string.the_speed_of_rotation_around_the_Sun), planetData[8]),
            arrayOf(getString(R.string.rotation_period), planetData[9]),
            arrayOf(getString(R.string.the_orbital_period), planetData[10]),
            arrayOf(getString(R.string.large_semi_axis), planetData[11]),
            arrayOf(getString(R.string.rings), planetData[12]),
            arrayOf(getString(R.string.quantity_ring), planetData[13]),
            arrayOf(getString(R.string.giant), planetData[14]),
            arrayOf(getString(R.string.the_presence_of_an_atmosphere), planetData[15]),
            arrayOf(getString(R.string.atmospheric_layers), planetData[16]),
            arrayOf(getString(R.string.internal_structure), planetData[17]),
            arrayOf(getString(R.string.features), planetData[18])
        )
    }

    private fun openModelButton(namePlanet: String) {
        Thread {
            runOnUiThread {
                modelButton.text = getString(R.string.loading)
                progressDialog = ProgressDialog(this, R.style.CustomProgressDialog).apply {
                    setMessage(getString(R.string.loading_model))
                    setCancelable(false)
                    show()
                }
            }
        }.start()

        Thread {
            try {
                val intentName = Intent(this, AndroidLauncher::class.java).apply {
                    putExtra(getString(R.string.planetName), namePlanet)
                }
                startActivity(intentName)
            } catch (e: ActivityNotFoundException) {
                runOnUiThread { exitMainMenuActivity(1) }
            } catch (e: RejectedExecutionException) {
                runOnUiThread {
                    Toast.makeText(this, getString(R.string.error_loading_model), Toast.LENGTH_SHORT).show()
                    throw RuntimeException(e)
                }
            }
        }.start()
    }

    private fun exitMainMenuActivity(errorMessage: Int) {
        if (errorMessage == 1) {
            Log.d(TAG, "The transition of their PlanetActivity to MainActivity ERROR")
            Toast.makeText(this, getString(R.string.error_loading_model), Toast.LENGTH_SHORT).show()
        } else {
            Log.d(TAG, "The transition of their PlanetActivity to MainActivity")
        }

        Intent(this, MainMenuActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(this)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        progressDialog?.takeIf { it.isShowing }?.dismiss()
        modelButton.text = getString(R.string.model)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }
}
