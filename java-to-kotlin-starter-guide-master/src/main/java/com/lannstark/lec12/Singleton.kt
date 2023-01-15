package com.lannstark.lec12

fun main() {
    println(Singleton.a)
}

// 코틀린에서 싱글톤 클래스 생성
object Singleton {
    var a: Int = 0
}