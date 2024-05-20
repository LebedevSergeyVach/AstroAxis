package astro.axis.planet.libgdx.helper;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.app.Activity;


public class SwipeGestureListener extends GestureDetector.SimpleOnGestureListener {

    private static final int SWIPE_MIN_DISTANCE = 200;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    private final Activity activity;

    public SwipeGestureListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
            activity.finish();
        }

        return false;
    }
}
