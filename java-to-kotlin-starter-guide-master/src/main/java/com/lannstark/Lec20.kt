package com.lannstark

fun main() {
    val person = Person("", 10)
    printPerson2(person)
}

/*
    Scope function : 일시적인 영역을 형성하는 함수
    - 람다를 활용해 일시적인 영역을 만들고, 코드를 더 간결하고, method 체인에 활용하는 함수
 */

fun printPerson(person: Person?) {
    if (person != null) {
        println(person.name)
        println(person.age)
    }
}

fun printPerson2(person: Person?) {
    // let : 확장함수, 람다를 받아 람다 결과를 반환
    val let = person?.let {
        println(it.name)
        println(it.age)
    }
    print(let)
}