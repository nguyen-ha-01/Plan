package com.code.domain.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class CountingService(): Service(){

    override fun onCreate() {
        super.onCreate()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

}