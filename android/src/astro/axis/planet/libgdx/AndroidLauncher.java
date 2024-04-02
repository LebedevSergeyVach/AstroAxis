package astro.axis.planet.libgdx;

import android.content.Intent;
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;


public class AndroidLauncher extends AndroidApplication {
	private static String planetName;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		if (intent != null && intent.hasExtra("planetName")) {
			planetName = intent.getStringExtra("planetName");
		}

		if (planetName.equals(getString(R.string.Sun))) {
			AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
			initialize(new SunModel(), config);
		} else if (planetName.equals(getString(R.string.Mercury))) {
			AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
			initialize(new MercuryModel(), config);
		} else if (planetName.equals(getString(R.string.Venus))) {
			AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
			initialize(new VenusModel(), config);
		} else if (planetName.equals(getString(R.string.Earth))) {
			AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
			initialize(new EarthModel(), config);
		} else if (planetName.equals(getString(R.string.Mars))) {
			AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
			initialize(new MarsModel(), config);
		} else if (planetName.equals(getString(R.string.Jupiter))) {
			AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
			initialize(new JupiterModel(), config);
		} else if (planetName.equals(getString(R.string.Saturn))) {


			Intent intentHome = new Intent(AndroidLauncher.this, MainMenuActivity.class);
			intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
			startActivity(intentHome);
			finish();


		} else if (planetName.equals(getString(R.string.Uranium))) {
			AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
			initialize(new UranusModel(), config);
		} else if (planetName.equals(getString(R.string.Neptune))) {
			AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
			initialize(new NeptuneModel(), config);
		} else if (planetName.equals(getString(R.string.Pluto))) {
			AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
			initialize(new PlutoModel(), config);
		}





		else {
			Intent intentHome = new Intent(AndroidLauncher.this, MainMenuActivity.class);
			intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
			startActivity(intentHome);
			finish();
		}
	}
}
