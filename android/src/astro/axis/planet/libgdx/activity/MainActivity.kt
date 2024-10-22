package astro.axis.planet.libgdx.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import astro.axis.planet.libgdx.R
import astro.axis.planet.libgdx.adapter.ButtonAdapter
import astro.axis.planet.libgdx.helper.SwipeGestureListener

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private val TAG = "APP:MainActivity"

    // Объявление переменных для RecyclerView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gestureDetector = GestureDetector(SwipeGestureListener(this))
        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_upheaval)
        } else {
            setContentView(R.layout.activity_main)
        }

        Log.d(TAG, "Start MainActivity and application")

        // Инициализация RecyclerView и его компонентов
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Создание списка кнопок
        val buttonList = ArrayList<String>().apply {
            add(getString(R.string.Mercury))
            add(getString(R.string.Venus))
            add(getString(R.string.Earth))
            add(getString(R.string.Mars))
            add(getString(R.string.Jupiter))
            add(getString(R.string.Saturn))
            add(getString(R.string.Uranium))
            add(getString(R.string.Neptune))
            add(getString(R.string.main_menu))
        }

        // Инициализация адаптера и установка его для RecyclerView
        adapter = ButtonAdapter(buttonList)
        recyclerView.adapter = adapter

        // Установка слушателя нажатий на кнопки в адаптере
        (adapter as ButtonAdapter).setOnButtonClickListener(object : ButtonAdapter.OnButtonClickListener {
            override fun onButtonClick(position: Int) {
                when (position) {
                    0 -> startPlanetActivity(R.string.Mercury)
                    1 -> startPlanetActivity(R.string.Venus)
                    2 -> startPlanetActivity(R.string.Earth)
                    3 -> startPlanetActivity(R.string.Mars)
                    4 -> startPlanetActivity(R.string.Jupiter)
                    5 -> startPlanetActivity(R.string.Saturn)
                    6 -> startPlanetActivity(R.string.Uranium)
                    7 -> startPlanetActivity(R.string.Neptune)
                    8 -> finish()
                }
            }
        })
    }

    private fun startPlanetActivity(planetNameResId: Int) {
        val intent = Intent(this, PlanetActivity::class.java)
        intent.putExtra(getString(R.string.planetName), getString(planetNameResId))
        startActivity(intent)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }
}
