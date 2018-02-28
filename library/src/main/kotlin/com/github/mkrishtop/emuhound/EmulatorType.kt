package com.github.mkrishtop.emuhound

/**
 * Created by mykhailokryshtop on 2/28/18.
 */
sealed class EmulatorType(val name: String) {
    object AVD: EmulatorType("AVD")
    object Andy: EmulatorType("Andy")
    object Bluestacks: EmulatorType("Bluestacks")
    object Genymotion: EmulatorType("Genymotion")
    object Jenkins: EmulatorType("Jenkins")

    override fun toString(): String {
        return name
    }
}