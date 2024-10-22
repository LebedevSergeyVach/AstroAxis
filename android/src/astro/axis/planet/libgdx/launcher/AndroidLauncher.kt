package astro.axis.planet.libgdx.launcher

import android.content.Intent
import android.os.Bundle
import astro.axis.planet.libgdx.*
import astro.axis.planet.libgdx.activity.MainMenuActivity
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration

class AndroidLauncher : AndroidApplication() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        if (intent != null && intent.hasExtra("planetName")) {
            planetName = intent.getStringExtra("planetName")
        }

        if (planetName == getString(R.string.Sun)) {
            val config = AndroidApplicationConfiguration()
            initialize(SunModel(), config)
        } else if (planetName == getString(R.string.Mercury)) {
            val config = AndroidApplicationConfiguration()
            initialize(MercuryModel(), config)
        } else if (planetName == getString(R.string.Venus)) {
            val config = AndroidApplicationConfiguration()
            initialize(VenusModel(), config)
        } else if (planetName == getString(R.string.Earth)) {
            val config = AndroidApplicationConfiguration()
            initialize(EarthModel(), config)
        } else if (planetName == getString(R.string.Mars)) {
            val config = AndroidApplicationConfiguration()
            initialize(MarsModel(), config)
        } else if (planetName == getString(R.string.Jupiter)) {
            val config = AndroidApplicationConfiguration()
            initialize(JupiterModel(), config)
        } else if (planetName == getString(R.string.Saturn)) {
            val config = AndroidApplicationConfiguration()
            initialize(SaturnModel(), config)
        } else if (planetName == getString(R.string.Uranium)) {
            val config = AndroidApplicationConfiguration()
            initialize(UranusModel(), config)
        } else if (planetName == getString(R.string.Neptune)) {
            val config = AndroidApplicationConfiguration()
            initialize(NeptuneModel(), config)
        } else if (planetName == getString(R.string.Pluto)) {
            val config = AndroidApplicationConfiguration()
            initialize(PlutoModel(), config)
        } else {
            val intentHome = Intent(this@AndroidLauncher, MainMenuActivity::class.java)
            intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intentHome)
            finish()
        }
    }

    companion object {
        private var planetName: String? = null
    }
}
