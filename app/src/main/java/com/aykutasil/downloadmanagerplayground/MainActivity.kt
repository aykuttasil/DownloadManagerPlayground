package com.aykutasil.downloadmanagerplayground

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var downloadReceiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        downloadReceiver = DownloadCompletedReceiver()

        btnDownload.setOnClickListener {
            val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val url = "http://mobil.aktif.com/penpusher/reaktif27.apk"
            val request = DownloadManager.Request(Uri.parse(url))

            val id = downloadManager.enqueue(request)

            // downloadManager.openDownloadedFile(id)
            // downloadManager.addCompletedDownload("Reaktif Download","Lütfen bekleyiniz",)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
