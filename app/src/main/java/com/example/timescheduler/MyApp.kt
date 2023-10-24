package com.example.timescheduler

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        createNotification()
    }

    private fun createNotification() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
         val channel=NotificationChannel(
             Counter.counterId,
             "counter",
             NotificationManager.IMPORTANCE_HIGH
         )
            channel.description="Lecture Notifications"
            val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}