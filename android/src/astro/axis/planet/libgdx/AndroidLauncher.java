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

		if (planetName.equals("Земля")) {
			AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
			initialize(new EarthModel(), config);
		} else if (planetName.equals("Меркурий")) {
			AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
			initialize(new MercuryModel(), config);
		} else {
			Intent intentHome = new Intent(AndroidLauncher.this, MainMenuActivity.class);
			intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
			startActivity(intentHome);
			finish();
		}
	}
}
