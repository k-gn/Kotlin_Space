package com.lannstark.lec11

/*
    코틀린은 .kt 파일에 변수, 함수, 클래스 여러개를 바로 만들 수 있다.

    public: 기본값 / 어디서든 접근 가능
    protected: 선언된 클래스, 하위 클래스만 접근가능, 파일 최상단에선 사용 불가능 (자바에서 쓸 땐 같은 패키지 개념도 동작)
    Internal: 같은 모듈에서만 접근 가능 (바이트 코드상 public, 자바에서 가져와 쓸 수 있다.)
    private: 선언된 클래스 내에서만 접근 가능

    생성자에 접근 제어자를 붙이려면 constructor 키워드를 써줘야 한다.
 */

val a = 3

fun add(a: Int, b: Int): Int {
    return a + b
}

open class Cat protected constructor()

fun main() {
    val car = Car("", "", 1000)
}

class Car(
    // getter, setter 접근 제한
    internal val name: String,
    private val owner: String,
    _price: Int
) {

    var price = _price
        private set
}