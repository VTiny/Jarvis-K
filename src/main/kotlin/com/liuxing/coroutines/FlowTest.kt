package com.liuxing.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val numbersFlow: Flow<Int> = createNumberFlow()

    numbersFlow
        .onEach {  }
        .buffer(100) // 设置缓冲区大小为100
        .collect { numbers ->
            println("Collected numbers in the last 100 milliseconds: $numbers")
        }
}

fun createNumberFlow(): Flow<Int> = flow {
    for (i in 0..1000) {
        emit(i)
        delay(10L)
    }
}