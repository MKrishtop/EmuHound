package com.github.mkrishtop.emuhound.rules.jenkins

import android.os.Build
import com.github.mkrishtop.emuhound.EmulatorRule
import com.github.mkrishtop.emuhound.EmulatorType

/**
 * Created by mykhailokryshtop on 2/27/18.
 */
internal object UserJenkinsEmulatorRule : EmulatorRule() {

    override fun name(): String {
        return "user-" + type()
    }

    override fun type(): EmulatorType {
        return EmulatorType.Jenkins
    }

    override fun check(): Boolean {
        return Build.USER == "jenkins"
    }
}