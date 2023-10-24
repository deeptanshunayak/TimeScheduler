package com.example.timescheduler

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.timescheduler.databinding.ActivityNotificationBinding
import java.text.DateFormat
import java.util.Calendar
import java.util.Date


class Notification : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createNotification()
        binding.submit.setOnClickListener { schedulec() }
    }

    private fun schedulec() {
        val intent = Intent(applicationContext,Notify::class.java)
        val title = binding.titleet.text.toString()
        val message = binding.messageet.text.toString()
        intent.putExtra(titlextra,title)
        intent.putExtra(msgextra,message)
        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            Nid,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT

        )
        val alarmManager =getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time=getTiime()
        alarmManager.setAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            time,
            pendingIntent
        )
        showAlert(time,title,message)
    }

    private fun showAlert(time: Long, title: String, message: String) {
    val date = Date(time)
    val dateFormat = android.text.format.DateFormat.getLongDateFormat(applicationContext)
        val timeFormat = android.text.format.DateFormat.getTimeFormat(applicationContext)
        AlertDialog.Builder(this).setTitle("Notification Scheduled")
            .setMessage(
                "Title:"+title+"/nMessage:"+message+"/nAt:"+dateFormat.format(date)+" "+timeFormat.format(time)
            )
            .setPositiveButton("Okay"){_,_-> }
            .show()
    }

    private fun getTiime(): Long {
    val minute = binding.datepicker.minute
        val hour = binding.datepicker.hour
        val day =binding.timepicker.dayOfMonth
        val month=binding.timepicker.month
        val year = binding.timepicker.year
        val calendar = Calendar.getInstance()
         calendar.set(year,month,day,hour,minute)
        return calendar.timeInMillis
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotification() {
    val name="Noti Channel"
    val desc ="A description of channel"
    val importance=NotificationManager.IMPORTANCE_DEFAULT
    val channel=NotificationChannel(Cid,name, importance)
        channel.description=desc
    val notificationManager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
           notificationManager.createNotificationChannel(channel)

    }
}