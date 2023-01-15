package com.lannstark.lec12

fun main() {
    Person.Factory.newBaby("ABC")

    Person.newBaby("DEF")
}

// private class
class Person private constructor(
    var name: String,
    var age: Int
) {

    // 코틀린은 static 키워드가 없다.
    // companion object 를 사용한다. (클래스와 동행하는 유일한 오브젝트)
    // 하나의 객체로 간주하기 때문에 이름을 붙이거나 인터페이스를 구현할 수 있다.
    // 유틸성 함수도 넣을 순 있지만, 최상단 파일을 활용하는 게 좋다.
    companion object Factory : Log {
        // const : 컴파일 시에 변수가 할당된다. 진짜 상수에 붙이기 위한 용도 (기본타입과 String에 붙일 수 있다.)
        private const val MIN_AGE = 1

        @JvmStatic // 자바에서 바로 사용하려면 붙여준다.
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            TODO("Not yet implemented")
        }
    }
}

interface Log {
    fun log()
}