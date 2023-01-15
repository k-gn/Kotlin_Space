package com.lannstark.lec15

/*
    배열은 코틀린에서 잘 안쓴다.

    # 컬렉션
        - 컬렉션 생성 시 불변인지 가변인지 설정해야 한다.
        - 가변 컬렉션 (mutable) : 컬렉션에 element 를 추가 / 삭제할 수 있다.
        - 불변 컬렉션 : 컬렉션에 element 를 추가 / 삭제할 수 없다. (Collections.unmodifiableList() 등을 붙여 만듬)
            - 참조 타입 element 의 필드는 바꿀 수 있다.

 */

fun main() {
    
    // 배열 생성
    val array = arrayOf(100, 200)

    for (i in array.indices) {
        println("$i ${array[i]}")
    }

    array.plus(300)

    for ((idx, value) in array.withIndex()) {
        println("$idx $value")
    }

    // Collection
    // 우선 불변으로 하고 필요 시 가변으로 바꾸자
    val numbers = listOf(100, 200) // 불변
    val mutableNumbers = mutableListOf(100, 200) // 가변
    val emptyList = emptyList<Int>()

    mutableNumbers.add(300)

    println(numbers[0])
    for (number in numbers) {
        println(number)
    }
    
    for ((idx, value) in numbers.withIndex()) {
        
    }
    
    // Set
    val numberSet = setOf(100, 200)
    val numberMutableSet = mutableSetOf(100, 200)

    // Map
    val oldMap = mutableMapOf<Int, String>()
    // Map.put(1, "MONDAY")
    oldMap[1] = "MONDAY"

    val mapOf = mapOf(1 to "MONDAY", 2 to "TUESDAY")

    for (key in oldMap.keys) {

    }

    for ((key, value) in oldMap.entries) {

    }

    // 코틀린의 컬렉션이 자바에서 호출되면 컬렉션 내용이 변할 수 있어 조심해야 한다.
    // 반대 입장일 경우 플랫폼 타입을 신경써야한다. (파악 후 wrapping 하여 해결한다.)
}

fun printNumbers(numbers: List<Int>) {

}