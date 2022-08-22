package com.example.sunmil2kdemo

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sunmil2kdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val receiver = object : BroadcastReceiver() {
        @SuppressLint("SetTextI18n")
        override fun onReceive(p0: Context, p1: Intent) {

            val str = StringBuilder()
            val keySet: Set<String> = p1.extras!!.keySet()
            keySet.forEach {
                str.append("key = $it || value = ${p1.extras!![it].toString()}\n")
            }
            binding.txt.text = str.toString()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val filter = IntentFilter()
        filter.addAction("com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED")
        registerReceiver(receiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        receiver.abortBroadcast()
    }

}