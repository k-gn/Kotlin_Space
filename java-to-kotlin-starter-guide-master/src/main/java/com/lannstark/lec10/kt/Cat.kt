package com.lannstark.lec10.kt

class Cat(
    species: String
) : Animal(species, 4) {

    /*
        상속 시 : 를 사용한다.
        상속 시 상위 클래스 생성자를 바로 호출한다.
     */

    override fun move() {
        println("고양이가 움직인다!")
    }
}