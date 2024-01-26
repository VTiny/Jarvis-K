package com.liuxing.lab

class CompanionLab {
    companion object {
        const val TAG_COMP = "CompanionLab"

        var compVar = 1

        @JvmStatic
        var jvmStaticCompVar = 2

        fun labFun() {
            println("compHello")
        }

        @JvmStatic
        fun staticLabFun() {
            println("jvm static hello")
        }

    }

}