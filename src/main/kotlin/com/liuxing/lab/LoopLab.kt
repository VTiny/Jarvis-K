package com.liuxing.lab

import com.liuxing.jarvis.utils.timeWatcher

fun main() {

    val n = 1000000000
    timeWatcher("loop1") {
        println(loop1(n))
    }

    timeWatcher("loop2") {
        println(loop2(n))
    }

    // StackOverflowError
//    timeWatcher("rec") {
//        println(rec(n))
//    }

    timeWatcher("tailrec") {
        println(tailRec(n))
    }

}

private fun loop1(n: Int): Long {
    var a: Long = 1
    for (i in 1..n) {
        a *= i
    }
    return a
}

private fun loop2(n: Int): Long {
    var a0: Long = 1
    var a1: Long = 1
    var a2: Long = 1
    var a3: Long = 1
    for (i in 1..n step 4) {
        a0 *= i
        a1 *= i + 1
        a2 *= i + 2
        a3 *= i + 3
    }
    return a0 * a1 * a2 * a3
}

private fun tailRec(n: Int): Long {
    return tailRecWorker(1, n)
}

private tailrec fun tailRecWorker(r: Long, i: Int): Long {
    return if (i == 0) r else tailRecWorker(r * i, i - 1)
}

private fun rec(n: Int): Long {
    return if (n == 1) 1 else rec(n - 1) * n
}
