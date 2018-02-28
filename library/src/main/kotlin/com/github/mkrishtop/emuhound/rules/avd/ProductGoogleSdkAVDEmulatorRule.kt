package com.github.mkrishtop.emuhound.rules.avd

import android.os.Build
import com.github.mkrishtop.emuhound.EmulatorRule
import com.github.mkrishtop.emuhound.EmulatorType

/**
 * Created by mykhailokryshtop on 2/27/18.
 */
internal object ProductGoogleSdkAVDEmulatorRule : EmulatorRule() {

    override fun name(): String {
        return "product-google-sdk" + type()
    }

    override fun type(): EmulatorType {
        return EmulatorType.AVD
    }

    override fun check(): Boolean {
        return "google_sdk" == Build.PRODUCT
    }
}