package com.github.janrone.app.logcathelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.janrone.lib.logcathelper.LogcatHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LogcatHelper.getInstance(this@MainActivity).start()

        Log.i("LogcatHelper","TEST")
        Log.d("LogcatHelper","TEST")
        Log.w("LogcatHelper","TEST")
        Log.e("LogcatHelper","TEST")
    }

    override fun onStop() {
        super.onStop()
        LogcatHelper.getInstance(this@MainActivity).stop()
    }
}
