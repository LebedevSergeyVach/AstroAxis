package astro.axis.planet.libgdx.helper

import android.app.Activity
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import kotlin.math.abs

class SwipeGestureListener(private val activity: Activity) : SimpleOnGestureListener() {
    override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (e2.x - e1!!.x > SWIPE_MIN_DISTANCE && abs(velocityX.toDouble()) > SWIPE_THRESHOLD_VELOCITY) {
            activity.finish()
        }

        return false
    }

    companion object {
        private const val SWIPE_MIN_DISTANCE = 200
        private const val SWIPE_THRESHOLD_VELOCITY = 200
    }
}
