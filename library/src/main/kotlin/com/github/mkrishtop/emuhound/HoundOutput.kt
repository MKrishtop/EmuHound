package com.github.mkrishtop.emuhound

/**
 * Created by mykhailokryshtop on 2/27/18.
 */
data class HoundOutput(val emulator: Boolean, val triggeredRules: Collection<EmulatorRule> = emptyList())