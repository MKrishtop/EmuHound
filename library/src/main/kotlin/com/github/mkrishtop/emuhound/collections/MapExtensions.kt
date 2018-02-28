package com.github.mkrishtop.emuhound.collections

/**
 * Created by mykhailokryshtop on 2/27/18.
 */
internal inline fun <K, V> MutableMap<out K, V>.removeAllWithValue(value: V) {
    val iterator = this.entries.iterator()
    while (iterator.hasNext()) {
        iterator.next().value?.let {
            if (equals(value)) {
                iterator.remove()
            }
        }
    }
}