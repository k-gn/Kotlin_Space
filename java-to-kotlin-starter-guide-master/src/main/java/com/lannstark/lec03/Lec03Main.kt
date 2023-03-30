package com.lannstark.lec03

fun main() {

    /*
        자바에선 기본적으로 암시적 캐스팅이 동작하지만 코틀린에선 동작하지 않음
    */

    // 코틀린은 초기값을 보고 타입을 추론하며, 기본타입들 간 변환은 명시적으로 이루어진다.
    val number1 = 4;
    // val number2: Long = number1; // Type mismatch
    val number2: Long = number1.toLong() // toXXX() 로 명시적 캐스팅

    val result1: Double = number1 / number2.toDouble()

    // nullable 변수는 적절한 처리가 필요
    val number3: Int? = 3
    val number4: Long = number3?.toLong() ?: 0

}

fun printAgeIfPerson(obj: Any?) {
    // value as Type : value 가 type 이면 타입 캐스팅, 아니면 예외
    // value as? Type : value 가 type 이면 타입 캐스팅, 아니거나 null 이면 null
    val person = obj as? Person
    println(person?.age)

    // value is Type : value 가 type 이면 true 아니면 false
    if (obj is Person) { // == instanceof
        // val person = obj // if 안에서 생략 가능
        println(obj.age) // 스마트 캐스트!
    }

    if (obj !is Person) { // 아니라면~
        println(obj)
    }
}

/*
    # kotlin 의 특이한 타입
    1. Any
        - Java Object (모든 객체의 최상위 타입)
        - 모든 primitive type 의 최상위 타입도 Any
        - Any 자체는 null 을 포함할 수 없어 Any? 로 표현해야한다.
        - equals, hashcode, toString 존재

    2. Unit
        - Java void
        - void 와 다르게 그 자체로 타입 인자로 사용 가능
        - 함수형 프로그래밍에서 Unit 은 단하나의 인스턴스만 갖는 타입을 의미한다.
            - 즉, 코틀린의 Unit 은 실제 존재하는 타입이라는 것을 표현

    3. Nothing
        - 함수가 정상적으로 끝나지 안핬다는 사실을 표시
        - 무조건 예외를 반환하거나, 무한루프 함수 등에 사용
 */

fun f(): Unit {

}

fun stringInterpolationAndIndexing() {
    val person = Person("개발자", 100)
    // ${변수명} 으로 문자열 내에서 사용 가능!
    val log = "사람의 이름은 ${person.name}, 나이는 ${person.age} 입니다."

    // {} 생략 가능 (있는게 가독성이 좋은 것 같다.)
    val log2 = "사람은 $person"

    val log3 = """
        ABCD
        EFG
        $person
    """.trimIndent()

    // 문자열에서 문자 가져오기 - []
    val str = "ABCDEF"
    val first = str[0]
    val last = str[5]
}