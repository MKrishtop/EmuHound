package com.github.mkrishtop.emuhound.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.mkrishtop.emuhound.EmuHound
import com.github.mkrishtop.emuhound.HoundOutput
import com.github.mkrishtop.emuhound.HoundOutputObserver
import kotlinx.android.synthetic.main.activity_sample.*

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        EmuHound.with(this.applicationContext
        ).addObserver(object: HoundOutputObserver {
            override fun onResult(output: HoundOutput) {
                val outputText = StringBuilder()

                output.triggeredRules.forEach {
                    outputText.append("Triggered rule: " + it).append("\n")
                }

                outputTv.text = if (outputText.isEmpty()) "Not an emulator." else outputText.toString()
            }
        }).detectAsync()
    }
}
