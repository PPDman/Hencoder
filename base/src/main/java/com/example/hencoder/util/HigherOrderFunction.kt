package com.example.hencoder.util
import java.lang.StringBuilder

/**
 * StringBuilder build扩展函数
 */
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

/**
 * lambda表达式
 */
inline fun printString(string: String,block:(String)->Unit){
    println("printString start")
    block(string)
    println("printString end")
}

/**
 * 内联高阶函数
 */
inline fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

/**
 * 非内联高阶函数
 * 代码块封装为Runnable并运行run
 */
inline fun runRunnable(crossinline block: ()->Unit){
    val runnable= Runnable{
        block()
    }
    runnable.run()
}

fun plus (num1: Int,num2: Int):Int{
    return num1+num2
}

fun minus(num1: Int,num2: Int):Int{
    return num1-num2
}

fun main(){
    val list= listOf("Apple","Banana","Orange")
    val result = StringBuilder().build {
        append("append start \n")
        for (item in list) {
            append(item).append("\n")
        }
        append("append end \n")
    }
    printString(result.toString()){
        println("lambda start")
        println(it)
        println("lambda end")
    }

    val num1=100
    val num2=80
    val result1 = num1AndNum2(num1, num2, ::plus)
    val result2 = num1AndNum2(num1, num2, ::minus)
    println("result1 is $result1")
    println("result2 is $result2")

    runRunnable {

    }
}