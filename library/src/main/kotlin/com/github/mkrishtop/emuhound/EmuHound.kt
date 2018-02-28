package com.github.mkrishtop.emuhound

import android.annotation.SuppressLint
import android.content.Context
import android.os.AsyncTask
import android.support.annotation.MainThread
import android.support.annotation.WorkerThread

/**
 * Created by mykhailokryshtop on 2/27/18.
 */

class EmuHound private constructor() {

    private var appContext: Context? = null
    private var useStaticRules = true

    private val observers: MutableSet<HoundOutputObserver> = HashSet()
    private val results: MutableMap<HoundInput, HoundOutput> = HashMap()

    companion object {

        @SuppressLint("StaticFieldLeak")
        private val instance = EmuHound()

        @MainThread
        fun with(context: Context): EmuHound {
            instance.appContext = context.applicationContext

            return instance
        }
    }

    fun useStaticRules(useStaticRules: Boolean = true): EmuHound {
        this.useStaticRules = useStaticRules
        return this
    }

    fun addObserver(observer: HoundOutputObserver): EmuHound {
        observers.add(observer)
        return this;
    }

    fun removeObserver(observer: HoundOutputObserver): EmuHound {
        observers.remove(observer)
        return this;
    }

    @WorkerThread
    internal fun detect(input: HoundInput): HoundOutput {
        var result = HoundOutput(false)

        if (input.useStaticRules) result = StaticRulesHoundDetector(appContext).detect(input);

        return result
    }

    @MainThread
    fun detectAsync() {
        val request = HoundInput(useStaticRules);

        if (results.containsKey(request).not()) {
            object : AsyncTask<HoundInput, Void, HoundOutput?>() {

                override fun doInBackground(vararg inputs: HoundInput): HoundOutput {
                    return inputs[0]!!.let { it -> detect(it) }
                }

                override fun onPostExecute(output: HoundOutput?) {
                    observers.forEach { observer -> output?.let { observer.onResult(it) } }
                }

            }.execute(request)
        } else {

        }
    }
}
