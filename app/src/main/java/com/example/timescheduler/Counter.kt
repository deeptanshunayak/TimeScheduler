package com.example.timescheduler

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class Counter(private val context: Context) {
private val notificationManager=context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    fun shownotification(){
        val activityIntent= Intent(context,MainActivity::class.java)
        val activityPendingIntent=PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)PendingIntent.FLAG_IMMUTABLE else 0

        )
        val notification=NotificationCompat.Builder(context, counterId)
            .setSmallIcon(R.drawable.iconclock)
            .setContentTitle("REMINDER")
            .setContentText("Lecture is starting come fast")
            .setContentIntent(activityPendingIntent)
            .build()
        notificationManager.notify(1,notification)
    }
    companion object{
        const val counterId="Counter_channel"
    }
}