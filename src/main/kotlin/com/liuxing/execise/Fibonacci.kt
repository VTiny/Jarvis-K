package com.liuxing.execise

import com.liuxing.jarvis.utils.timeWatcher
import kotlinx.coroutines.runBlocking

/**
 * Description:
 * Author: liuxia
 * Date: 2023/11/20
 */
fun fib1(n: Int): Int {
    return if (n == 0 || n == 1) 1 else fib1(n - 1) + fib1(n - 2)
}

/**
 * 尾递归实现
 */
fun fib2(n: Int): Int {
    return fibIterate2(1, 1, n)
}

fun fibIterate2(num1: Int, num2: Int, n: Int): Int {
    return if (n == 0) num1 else fibIterate2(num2, num1 + num2, n - 1)
}


/**
 * Kotlin 针对尾递归优化，是哟给你 tailrec 关键字，编译后会转换为循环
 */
fun fib3(n: Int): Int {
    return fibIterate3(1, 1, n)
}

tailrec fun fibIterate3(num1: Int, num2: Int, n: Int): Int {
    return if (n == 0) num1 else fibIterate3(num2, num1 + num2, n - 1)
}


fun main() {
    runBlocking {

    }


    compare1To2()
    compare2To3()
}

private fun compare1To2() {
    // 对比初版递归和尾递归
    val n1 = 45
    // block start at: 1700491159282, end at: 1700491162847, cost: 3565ms
    timeWatcher {
        println(fib1(n1))
    }
    // block start at: 1700491162848, end at: 1700491162848, cost: 0ms
    timeWatcher {
        println(fib2(n1))
    }
}

private fun compare2To3() {
    // 对比有无 tailrec 关键字的尾递归
    val n2 = 10000
    // block start at: 1700492935596, end at: 1700492935629, cost: 33ms
    timeWatcher {
        repeat(1000) {
            fib2(n2)            // 25000左右发生内存溢出
        }
    }
    // block start at: 1700492935630, end at: 1700492935635, cost: 5ms
    timeWatcher {
        repeat(1000) {
            fib3(n2)            // 不会发生内存溢出
        }
    }
}

