package ru.yandexpraktikum.blechat.presentation.notifications

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.yandexpraktikum.blechat.R
import ru.yandexpraktikum.blechat.utils.checkForConnectPermission
import javax.inject.Inject

private const val CHANNEL_ID = "8d0d8523-9362-4442-99bf-a9a097e7342f"
private const val NOTIFICATION_ID = 1234

class NotificationsHelperImpl
@Inject constructor(
    @ApplicationContext private val context: Context,
    private val notificationManager: NotificationManagerCompat,
) : NotificationsHelper {

    override fun notifyOnMessageReceived(title: String, message: String) {
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.bluetooth_ic)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()
        context.checkForConnectPermission {
            notificationManager.notify(NOTIFICATION_ID, notification)
        }
    }
}