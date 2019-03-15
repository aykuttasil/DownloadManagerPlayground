package com.aykutasil.downloadmanagerplayground

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class DownloadCompletedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val downloadID = intent?.getLongExtra("extra_download_id", 0)
        Toast.makeText(context, "İndirildi. Id: $downloadID", Toast.LENGTH_LONG).show()

        val downloadManager = context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val file = downloadManager.openDownloadedFile(downloadID!!)
    }
}