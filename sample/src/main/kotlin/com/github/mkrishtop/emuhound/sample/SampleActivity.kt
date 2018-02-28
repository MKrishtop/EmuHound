package com.github.mkrishtop.emuhound.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.github.mkrishtop.emuhound.EmuHound
import com.github.mkrishtop.emuhound.HoundOutputObserver
import com.github.mkrishtop.emuhound.HoundOutput

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        EmuHound.with(this.applicationContext
        ).addObserver(object: HoundOutputObserver {
            override fun onResult(output: HoundOutput) {
                output.triggeredRules.forEach {
                    Log.d("SampleActivity", "Triggered rule: " + it)
                }
            }
        }).detectAsync()
    }
}
