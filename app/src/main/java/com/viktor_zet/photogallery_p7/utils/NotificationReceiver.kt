package com.viktor_zet.photogallery_p7.utils

import android.app.Activity
import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationManagerCompat
import androidx.work.impl.utils.ForceStopRunnable

private const val TAG = "NotificationReceiver"

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.i(TAG, "received result: $resultCode")
        if (resultCode != Activity.RESULT_OK) {
            // Активність переднього плану відмінила повернення транзакції.
        }
        val requestCode = intent.getIntExtra(PollWorker.REQUEST_CODE, 0)
        val notification: Notification? =
            intent.getParcelableExtra(PollWorker.NOTIFICATION)
        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(requestCode, notification!!)
    }
}