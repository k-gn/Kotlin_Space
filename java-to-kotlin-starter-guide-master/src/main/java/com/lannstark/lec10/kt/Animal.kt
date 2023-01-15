package com.lannstark.lec10.kt

abstract class Animal(
    protected val species: String,
    // 프로퍼티 override 할 때 open 을 꼭 붙여야한다!
    protected open val legCount: Int
) {

    abstract fun move()
}