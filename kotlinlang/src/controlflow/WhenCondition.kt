package controlflow

import controlflow.Car.*

/*
    - 흔히 쓰는 switch 구문 대신에 더 유연하고 명확한 when 문법을 씁니다.
        - 따로 반환값이 남지 않는 명령문(statement) 방식이나, 결국 반환값으로 돌아오는 표현식(expression) 형태
 */
class MyClass

fun main() {
    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")
}

fun cases(obj: Any) { // Any = Object
    when (obj) {
        1 -> println("하나")
        "안녕" -> println("인사")
        is Long -> println("Long") // is : 타입 검사
        !is String -> println("문자열 아님")
        else -> println("그 외")
    }
}

fun whenAssign(obj: Any): Any = when (obj) {
    1 -> "하나"
    "안녕" -> 1
    is Long -> false
    else -> 42
}

fun handleCar(car: Car) {
    when (car) {
        AVANTE -> TODO()
        SONATA -> TODO()
        GRADEUR -> TODO()
    }
}