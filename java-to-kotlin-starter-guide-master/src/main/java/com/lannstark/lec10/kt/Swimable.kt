package com.lannstark.lec10.kt

interface Swimable {

    // 인터페이스에 backing field 없는 프로퍼티를 만들 수 있다.
    val swimAbility: Int
        get() = 3

    fun act() {
        println(swimAbility)
        println("어푸 어푸")
    }
}