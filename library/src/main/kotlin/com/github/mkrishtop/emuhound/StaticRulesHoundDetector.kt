package com.github.mkrishtop.emuhound

import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat
import com.github.mkrishtop.emuhound.rules.avd.*

/**
 * Created by mykhailokryshtop on 2/27/18.
 */
internal class StaticRulesHoundDetector(private val appContext: Context?) : HoundDetector {

    private val rules: Set<EmulatorRule> = setOf(
            AndroidSdkAVDEmulatorRule,
            EmulatorAVDEmulatorRule,
            GenericAVDEmulatorRule,
            GenericBrandAVDEmulatorRule,
            ModelGoogleSdkAVDEmulatorRule,
            ProductGoogleSdkAVDEmulatorRule,
            UnknownAVDEmulatorRule
    )

    override fun detect(input: HoundInput): HoundOutput {
        val checkedRules = rules.filter {
            hasAllPermissions(it.requiredPermissions()) && it.check()
        }

        return if (checkedRules.isEmpty()) {
            HoundOutput(false)
        } else {
            HoundOutput(true, checkedRules)
        }
    }

    private fun hasAllPermissions(permissions: Collection<String>): Boolean {
        val context = appContext!!

        permissions.forEach {
            if (ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }

        return true
    }
}