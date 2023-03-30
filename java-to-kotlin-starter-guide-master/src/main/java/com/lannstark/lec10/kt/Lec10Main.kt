package com.lannstark.lec10.kt

fun main() {
    Derived(300)
}

open class Base(
    open val number: Int = 100
) {
    init {
        println("Base")
        /*
            상위 클래스에 생성자와, init 블록에서는
            하위 클래스의 non-final open field 에 접근하면 안된다. (초기화가 진행되지 않은 값이 호출된다)
            예상치 못한 값이 호출될 수 있다.

            따라서 상위 클래스를 설계할 때
            생성자 또는 초기화 블록에 사용되는 프로퍼티는
            open 을 피해야한다.

            final 은 override 할 수 없게한다.
         */
        println(number)
    }
}

class Derived(
    override val number: Int = 50
) : Base(number) {
    init {
        println("Derived")
    }
}