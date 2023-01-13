package com.lannstark.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {

}

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}

fun parseIntOrNull(str: String): Int? {
    // try catch 도 expression 이다!
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

// 코틀린에선 IOException 에 대한 빨간줄이 생기지 않는다?
// -> 코틀린은 모두 Unchecked Exception 으로 간주한다! => 따라서 method throws 를 볼일이 거의 없다.
fun readFile() {
    val currentFile = File(".")
    val file = File(currentFile.absolutePath + "/a.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close()
}

// 코틀린의 try with resources 은 use 를 사용한다.
fun readFile(path: String) {
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.readLine())
    }
}