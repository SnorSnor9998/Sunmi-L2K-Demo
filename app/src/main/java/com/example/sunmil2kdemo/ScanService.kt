package com.example.sunmil2kdemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.view.KeyEvent

class ScanService : Service() {

    override fun onBind(p0: Intent?): IBinder {
        return binder
    }

    private val binder = object : IScanInterface.Stub(){
        override fun sendKeyEvent(key: KeyEvent) {
            when(key.action){
                KeyEvent.ACTION_DOWN -> scan()
                KeyEvent.ACTION_UP -> stop()
            }
        }

        override fun scan() {

        }

        override fun stop() {

        }

        override fun getScannerModel(): Int {
            return 0
        }

    }

}