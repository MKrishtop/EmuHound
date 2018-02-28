package com.github.mkrishtop.emuhound.rules.andy

import android.os.Build
import com.github.mkrishtop.emuhound.EmulatorRule
import com.github.mkrishtop.emuhound.EmulatorType

/**
 * Created by mykhailokryshtop on 2/27/18.
 */
internal object HardwareAndyEmulatorRule : EmulatorRule() {

    override fun name(): String {
        return "hardware-" + type()
    }

    override fun type(): EmulatorType {
        return EmulatorType.Andy
    }

    override fun check(): Boolean {
        return Build.HARDWARE == "andy"
    }
}