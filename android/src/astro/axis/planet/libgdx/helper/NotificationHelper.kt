package astro.axis.planet.libgdx.helper

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import astro.axis.planet.libgdx.R

object NotificationHelper {
    private const val CHANNEL_ID = "my_channel"
    private const val CHANNEL_NAME = "My Channel"
    private const val CHANNEL_DESCRIPTION = "This is my channel for notifications"

    @JvmStatic
    fun showNotification(context: Context, title: String?, message: String?, intent: Intent?) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create notification channel for Android O and higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = CHANNEL_DESCRIPTION
            notificationManager.createNotificationChannel(channel)
        }

        // Use FLAG_IMMUTABLE to ensure the PendingIntent can't be changed
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(message)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        notificationManager.notify(0, builder.build())
    }
}
