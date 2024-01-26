package com.liuxing.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.random.Random
import kotlin.time.measureTime

fun main() = runBlocking {


    flow {
        for (i in 0..1000) {
            emit(i)
            delay(10L)
        }
    }.buffer(1000)
        .collect {
        println("$it ${System.currentTimeMillis()}")
    }

//    var curr = numbersFrom(2)
//
//    repeat(5) {
//        val prime = curr.receive()
//        println(prime)
//        curr = filter(curr, prime)
//    }
//    coroutineContext.cancelChildren()
}

fun CoroutineScope.numbersFrom(start: Int) = produce<Int> {
    var x = start
    while (true) {
        println("-- numbersFrom.. $this $x")
        send(x++)
    }
}

fun CoroutineScope.filter(numers: ReceiveChannel<Int>, prime: Int) = produce<Int> {
    for (x in numers) {
        println(" - filter..$this x=$x, prime=$prime")
        if (x % prime != 0) {
            println(" - filter send.. $numers $this $x")
            send(x)
        }
    }
}
