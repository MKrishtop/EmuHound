package com.github.mkrishtop.emuhound

import android.content.Context
import android.support.annotation.MainThread

/**
 * Created by mykhailokryshtop on 2/27/18.
 */

class EmuHound private constructor() {

    private var context: Context? = null

    companion object {

        private val instance = EmuHound()

        @MainThread
        fun with(context: Context): EmuHound {
            instance.context = context

            return instance
        }
    }
}
