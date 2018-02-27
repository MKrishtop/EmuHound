package com.github.mkrishtop.emuhound.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mkrishtop.emuhound.EmuHound

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        EmuHound.with(this)
    }
}
