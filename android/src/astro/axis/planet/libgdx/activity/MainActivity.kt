package astro.axis.planet.libgdx.activity

import android.annotation.SuppressLint
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
import astro.axis.planet.libgdx.adapter.ButtonAdapter.OnButtonClickListener
import astro.axis.planet.libgdx.helper.SwipeGestureListener

class MainActivity : AppCompatActivity() {
    // Объявление переменных для RecyclerView
    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    private var gestureDetector: GestureDetector? = null

    @SuppressLint("MissingInflatedId")
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
        recyclerView.setLayoutManager(layoutManager)

        // Создание списка кнопок
        val buttonList = ArrayList<String>()
        buttonList.add(getString(R.string.Mercury))
        buttonList.add(getString(R.string.Venus))
        buttonList.add(getString(R.string.Earth))
        buttonList.add(getString(R.string.Mars))
        buttonList.add(getString(R.string.Jupiter))
        buttonList.add(getString(R.string.Saturn))
        buttonList.add(getString(R.string.Uranium))
        buttonList.add(getString(R.string.Neptune))
        buttonList.add(getString(R.string.main_menu))

        // Инициализация адаптера и установка его для RecyclerView
        adapter = ButtonAdapter(buttonList)
        recyclerView.setAdapter(adapter)

        // Установка слушателя нажатий на кнопки в адаптере
        (adapter as ButtonAdapter).setOnButtonClickListener(OnButtonClickListener { position: Int ->
            if (position == 0) {
                val intent = Intent(this@MainActivity, PlanetActivity::class.java)
                intent.putExtra(getString(R.string.planetName), getString(R.string.Mercury))
                startActivity(intent)
            }
            if (position == 1) {
                val intent = Intent(this@MainActivity, PlanetActivity::class.java)
                intent.putExtra(getString(R.string.planetName), getString(R.string.Venus))
                startActivity(intent)
            }

            if (position == 2) {
                val intent = Intent(this@MainActivity, PlanetActivity::class.java)
                intent.putExtra(getString(R.string.planetName), getString(R.string.Earth))
                startActivity(intent)
            }

            if (position == 3) {
                val intent = Intent(this@MainActivity, PlanetActivity::class.java)
                intent.putExtra(getString(R.string.planetName), getString(R.string.Mars))
                startActivity(intent)
            }

            if (position == 4) {
                val intent = Intent(this@MainActivity, PlanetActivity::class.java)
                intent.putExtra(getString(R.string.planetName), getString(R.string.Jupiter))
                startActivity(intent)
            }

            if (position == 5) {
                val intent = Intent(this@MainActivity, PlanetActivity::class.java)
                intent.putExtra(getString(R.string.planetName), getString(R.string.Saturn))
                startActivity(intent)
            }

            if (position == 6) {
                val intent = Intent(this@MainActivity, PlanetActivity::class.java)
                intent.putExtra(getString(R.string.planetName), getString(R.string.Uranium))
                startActivity(intent)
            }

            if (position == 7) {
                val intent = Intent(this@MainActivity, PlanetActivity::class.java)
                intent.putExtra(getString(R.string.planetName), getString(R.string.Neptune))
                startActivity(intent)
            }
            if (position == 8) {
                finish()
            }
        })
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector!!.onTouchEvent(event)
    }

    companion object {
        private const val TAG = "APP:MainActivity"
    }
}
