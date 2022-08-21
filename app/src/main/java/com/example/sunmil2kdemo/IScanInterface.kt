package com.example.sunmil2kdemo

import android.view.KeyEvent

interface IScanInterface {
    /**
     * 触发开始与停止扫码
     * key.getAction()==KeyEvent.ACTION_UP 触发开始扫码
     * key.getAction()==KeyEvent.ACTION_DWON 触发停止扫码
     */
    fun sendKeyEvent(key : KeyEvent)
    /**
     * 触发开始扫码
     */
    fun scan()
    /**
     * 触发停止扫码
     */
    fun stop()
    /**
     * 获取扫码头类型
     * 100-->NONE
     * 101-->P2Lite
     * 102-->l2-newland
     * 103-->l2-zabra
     */
    fun getScannerModel() :Int

}



