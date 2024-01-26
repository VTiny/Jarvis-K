package com.liuxing.jarvis.utils

fun <R> timeWatcher(name: String? = null, block: () -> R): R {
    val ts = System.currentTimeMillis()
    val r = block()
    println(
        "# ${if (name.isNullOrEmpty()) "block" else name} cost: ${System.currentTimeMillis() - ts}ms" +
                " (start at: $ts, end at: ${System.currentTimeMillis()})"
    )
    return r
}
