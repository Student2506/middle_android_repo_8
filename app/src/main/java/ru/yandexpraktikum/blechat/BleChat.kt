package ru.yandexpraktikum.blechat

import android.app.Application
import android.app.NotificationManager
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationManagerCompat
import dagger.hilt.android.HiltAndroidApp

private const val CHANNEL_ID = "8d0d8523-9362-4442-99bf-a9a097e7342f"

@HiltAndroidApp
class BleChat : Application() {

    override fun onCreate() {
        super.onCreate()
        setUpNotificationsChannel()
    }

    private fun setUpNotificationsChannel() {
        val channel =
            NotificationChannelCompat.Builder(CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT)
                .setName(this.getString(R.string.message)).build()
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.createNotificationChannel(channel)
    }
}