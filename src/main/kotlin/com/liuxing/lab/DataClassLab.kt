package com.liuxing.lab

data class App(
    var name: String,
    val packageName: String
)

fun main() {
    val app1 = App("AAA", "com.aaa")
    val app2 = App("AAA", "com.aaa")
    println(app1 !== app2)

}