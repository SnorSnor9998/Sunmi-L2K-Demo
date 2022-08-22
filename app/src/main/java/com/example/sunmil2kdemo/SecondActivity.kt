package com.example.sunmil2kdemo

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.sunmil2kdemo.databinding.ActivityMainBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var scanInterface: IScanInterface? = null

    private val conn: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            scanInterface = IScanInterface.Stub.asInterface(service)
            Log.v("Setting", "Scanner Service Connected!")
        }

        override fun onServiceDisconnected(name: ComponentName) {
            Log.v("Setting", "Scanner Service Disconnected!")
            scanInterface = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = Intent()
        i.setClassName(packageName,"$packageName.ScanService")
        bindService(i, conn, Service.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(conn)
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        Log.v("Setting","$event")
        if (event.keyCode == KeyEvent.KEYCODE_5) {
            scanInterface!!.sendKeyEvent(event)
        }
        return super.dispatchKeyEvent(event)
    }

}