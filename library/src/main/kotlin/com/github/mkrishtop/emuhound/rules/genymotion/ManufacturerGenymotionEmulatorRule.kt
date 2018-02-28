package com.github.mkrishtop.emuhound.rules.genymotion

import android.os.Build
import android.os.Environment
import com.github.mkrishtop.emuhound.EmulatorRule
import com.github.mkrishtop.emuhound.EmulatorType
import java.io.File

/**
 * Created by mykhailokryshtop on 2/27/18.
 */
internal object ManufacturerGenymotionEmulatorRule : EmulatorRule() {

    override fun name(): String {
        return "manufacturer-" + type()
    }

    override fun type(): EmulatorType {
        return EmulatorType.Genymotion
    }

    override fun check(): Boolean {
        return Build.MANUFACTURER.contains("Genymotion")
    }
}