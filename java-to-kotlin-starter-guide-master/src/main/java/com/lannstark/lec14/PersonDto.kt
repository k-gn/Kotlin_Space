package com.lannstark.lec14

/*
    - Data class
        - 계층간의 데이터를 전달하기 위한 DTO (Data Transfer Object)
        - 데이터 (필드), 생성자와 getter, equals, hashCode, toString ...
        - data keyword 사용
 */
data class PersonDto(
    val name: String,
    val age: Int
)

fun main() {
    val dto1 = PersonDto("aa", 100)
    val dto2 = PersonDto(name = "aa", age = 100)

    println(dto1 == dto2)
}

