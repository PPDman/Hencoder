package com.example.hencoder.util

import java.lang.RuntimeException

/**
 * 计算字符串字幕个数
 */
fun String.lettersCount(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }

    }
    return count
}

/**
 * 字符重复次数
 */
operator fun String.times(n: Int) = this.repeat(n)

fun <T : Comparable<T>> max(vararg nums: T): T {
    if (nums.isEmpty()) throw RuntimeException("Params can not be empty.")
    var maxNum = nums[0]
    for (num in nums) {
        if (num > maxNum) {
            maxNum = num
        }
    }
    return maxNum
}

fun main(){
    val a = 3.5
    val b = 3.8
    val c = 4.1
    val largest = max(a, b, c)
    println(largest)
}