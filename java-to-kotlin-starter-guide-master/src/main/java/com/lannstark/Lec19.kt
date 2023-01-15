package com.lannstark

import com.lannstark.lec17.Fruit as f

data class Person(
    val name: String,
    val age: Int
)

class Person2(
    val name: String,
    val age: Int
) {
    // operator : 연산자 속성을 가지고 있어 연산자 오버로딩
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): String {
        return this.name
    }
}

fun main() {

    val person = Person("", 100)
    val (name, age) = person // data class 구조분해 문법 (순서 중요)

    val person2 = Person2("", 100)
    val (name2, age2) = person2 // 직접 componentN 정의 후 구조분해

    val numbers = listOf(1, 2, 3)

    // foreach 에선 break, continue 를 사용할 수 없다.
    // 아래 방법처럼 하면 break 가능
    run {
        numbers.forEach { number ->
            if (number == 3) {
                return@run
            }
            println(number)
        }
    }
    // 아래 방법처럼 하면 continue 가능
    numbers.forEach { number ->
        if (number == 3) {
            return@forEach
        }
        println(number)
    }

    // Label (사용 안하는 것을 추천 - 복잡도와 유지보수가 증가)
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                break@loop
            }
        }
    }
}

// Type Alias, as import
fun filterFruits(filter: (f) -> Boolean) {

}

typealias FruitFilter = (f) -> Boolean

fun filterFruits2(filter: FruitFilter) {

}

// 서로다른 위치의 같은 이름의 함수를 가져올 때 어떻게 써야할까?
// as import : 어떤 클래스나 함수를 임포트 할 때 이름을 바꾸는 기능

// take if / take unless
fun getNumberOrNull(number: Int): Int? {
    return if (number <= 0) {
        null
    } else {
        number
    }
}

fun getNumberOrNullTakeIf(number: Int): Int? {
    // take if : 주어진 조건을 만족하면 그 값이, 아니면 null 이 반환
    // take unless : 주어진 조건을 만족하지 않으면 그 값이, 아니면 null 이 반환
    return number.takeIf { it > 0 }
}