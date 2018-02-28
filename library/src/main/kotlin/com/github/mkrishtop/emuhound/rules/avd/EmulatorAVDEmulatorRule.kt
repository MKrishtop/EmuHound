package com.github.mkrishtop.emuhound.rules.avd

import android.os.Build
import com.github.mkrishtop.emuhound.EmulatorRule
import com.github.mkrishtop.emuhound.EmulatorType

/**
 * Created by mykhailokryshtop on 2/27/18.
 */
internal object EmulatorAVDEmulatorRule : EmulatorRule() {

    override fun name(): String {
        return "model-emulator-" + type()
    }

    override fun type(): EmulatorType {
        return EmulatorType.AVD
    }

    override fun check(): Boolean {
        return Build.MODEL.contains("Emulator")
    }
}