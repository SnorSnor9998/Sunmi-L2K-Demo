package com.example.sunmil2kdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BarcodeReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context, p1: Intent) {

        val code = p1.getStringExtra("data")
        val arr = p1.getByteArrayExtra("source_byte")
        if (code != null && code.isNotEmpty()){

        }

    }

}