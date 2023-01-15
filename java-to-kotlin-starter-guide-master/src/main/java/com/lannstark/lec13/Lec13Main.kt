package com.lannstark.lec13

/*
    static 을 사용하는 중첩 클래스
    - 밖의 클래스 직접 참조 불가

    static 을 사용하지 않는 중첩 클래스
    - 내부 클래스
        - 밖의 클래스 직접 참조 가능
    - 지역 클래스
    - 익명 클래스 
        - 일회성 클래스

    - 내부 클래스는 숨겨진 외부 클래스 정보를 가지고 있어 참조를 해지하지 못하는 경우 메모리 누수가 생길 수 있고, 디버깅이 어렵다.
    - 내부 클래스는 직렬화에 제한이 있다.
    - 따라서 static 을 사용하는 내부 클래스를 쓰자.
 */

fun main() {

}

class JavaHouse(
    private val address: String,
    private val livingRoom: LivingRoom
) {

    // 코틀린에서 권장되는 중첩 클래스를 만들 때는 그냥 클래스를 쓰면 된다. (기본적으로 바깥 클래스를 참조하지 않음)
    // 권장되지 않는 중첩 클래스 생성 시 inner 키워드를 명시적으로 붙여준다. (바깥 클래스를 참조해야할 때)
    inner class LivingRoom(
        private val area: Double
    ) {
        val address: String
            // 바깥 클래스 참조 시 this@바깥클래스 를 사용한다.
            get() = this@JavaHouse.address
    }
}