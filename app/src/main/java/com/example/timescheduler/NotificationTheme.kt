package com.example.timescheduler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NotificationTheme : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service=Counter(applicationContext)
        setContentView(R.layout.activity_notification_theme)
        findViewById<Button>(R.id.button).setOnClickListener { service.shownotification() }
    }
}