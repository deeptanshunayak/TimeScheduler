package com.example.timescheduler

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

const val Nid=1
const val Cid="channel1"
const val titlextra="titleExtra"
const val msgextra="messageExtra"
class Notify:BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent) {
    val notification=NotificationCompat.Builder(context, Cid)
        .setSmallIcon(R.drawable.iconclock)
        .setContentTitle(intent.getStringExtra(titlextra))
        .setContentText(intent.getStringExtra(msgextra))
        .build()
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(Nid,notification)
    }
}