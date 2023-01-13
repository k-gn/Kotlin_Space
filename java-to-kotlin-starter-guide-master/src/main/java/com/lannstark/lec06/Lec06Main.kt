package com.lannstark.lec06

fun main() {

    val numbers = listOf(1L, 2L, 3L)

    for (number in numbers) {
        println(number)
    }

    for (i in 1..3) { // range, progression -> 사실 등차수열을 만들어 주는 것!
        println(i)
    }

    for (i in 3 downTo 1) {
        println(i)
    }

    for (i in 1..5 step 2) {
        println(i)
    }

    /*
        downTo 나 step 도 결국은 함수이다!
        변수.함수(인자) 형식을 -> 변수 함수 인자 형식으로 사용하는 것 뿐이다. (중위 호출 함수)
     */


    // while 은 자바와 동일하다
    var i = 1
    while (i <= 3) {
        print(i)
        i++
    }
}