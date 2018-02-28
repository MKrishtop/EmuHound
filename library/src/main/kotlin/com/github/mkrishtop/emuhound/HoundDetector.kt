package com.github.mkrishtop.emuhound

/**
 * Created by mykhailokryshtop on 2/27/18.
 */
internal interface HoundDetector {
    fun detect(input: HoundInput): HoundOutput
}