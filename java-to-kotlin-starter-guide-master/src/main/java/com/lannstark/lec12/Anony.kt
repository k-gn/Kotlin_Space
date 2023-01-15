package com.lannstark.lec12

// 코틀린의 익명 클래스 사용
fun main() {
    moveSomething(object : Movable {
        override fun move() {
            TODO("Not yet implemented")
        }

        override fun fly() {
            TODO("Not yet implemented")
        }
    })
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}