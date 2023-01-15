package com.lannstark.lec14

/*
    - Sealed
        - 상속이 가능하도록 추상 클래스를 만드는데, 외부에서는 상속 받지 않도록
        - 내가 작성한 클래스만 하위 클래스가 되도록 봉인
            - sealed 클래스의 서브 클래스들은 반드시 같은 파일 내에 선언되어야 함
            - 단, sealed 클래스의 서브 클래스를 상속한 클래스들은 같은 파일 내에 없어도 됨
        - 컴파일 타임 때 하위 클래스의 타입을 모두 기억한다.
            - 원래 컴파일러는 부모 클래스를 상속 받은 자식 클래스가 있는지 알지 못한다.
            - 런타임에 클래스 타입이 추가될 수 없다.
        - 하위 클래스는 같은 패키지에 있어야 한다.
        - 클래스 상속 가능, 하위 클래스는 멀티 인스턴스 가능
        -sealed 클래스는 private 생성자만 갖게 됨

    컴파일러에게 '얘네 말고 내 자식 없어 ㅋㅋ 다른 곳 안 가봐도 돼' 하고 알려주는 것
 */
sealed class Car(
    val name: String,
    val price: Long
) {
    abstract fun move()
}

class Avante: Car("아반떼", 1_000) {
    override fun move() {
        TODO("Not yet implemented")
    }
}

class Sonata: Car("소나타", 2_000) {
    override fun move() {
        TODO("Not yet implemented")
    }
}

class Grandeur: Car("그렌저", 3_000) {
    override fun move() {
        TODO("Not yet implemented")
    }
}

private fun handleCar(car: Car) {
    when (car) {
        is Avante -> TODO()
        is Sonata -> TODO()
        is Grandeur -> TODO()
    }
}


