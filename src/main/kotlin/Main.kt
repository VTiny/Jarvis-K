import java.lang.reflect.Constructor

fun main(args: Array<String>) {
//    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.

//    val list = listOf("1", "2", "3")

//    println("Program arguments: ${list.joinToString(separator = ",")}")


    val clazz = UIState.Load::class.java
    println(clazz.constructors)
    var con : (Constructor<Boolean>?)
    con = clazz.constructors.filter {
        it.parameterCount == 1 && it.parameterTypes[0] == Boolean::class.java
    }.getOrNull(0) as (Constructor<Boolean>?)
    println(con)
}

interface IUIState {}

sealed class UIState: IUIState {
    data class Load(val value: String): UIState()
}