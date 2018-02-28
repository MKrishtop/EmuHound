package com.github.mkrishtop.emuhound

/**
 * Created by mykhailokryshtop on 2/27/18.
 */
abstract class EmulatorRule {

    abstract fun name(): String
    abstract fun check(): Boolean
    abstract fun type(): EmulatorType

    fun requiredPermissions(): Collection<String> = emptyList()

    override fun toString(): String {
        return name()
    }
}