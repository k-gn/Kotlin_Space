package com.lannstark.lec02

fun main() {

    val str: String? = "ABC"
    // str.length
    str?.length // safe call - null 이 아니면 실행하고, null 이면 실행하지 않고 그대로 null

    str?.length ?: 0 // elvis - 앞에 결과가 null 이면 뒤의 값을 사용

    val person = Person("개발자")
    // 코틀린은 자바코드 어노테이션 정보를 이해한다.
    // 단, 어노테이션 정보가 없다면 코틀린은 이게 nullable 인지 아닌지 구분을 못한다 => 이것을 플랫폼 타입이라 한다.
    // 따라서 이 때 npe 가 발생할 수 있어 조심해야한다. (자바 코드의 null 여부를 확인하거나, 코틀린으로 wrapping 하여 해결)
    startsWithA(person.name);
}

fun startsWithA1(str: String?): Boolean {
    if (str == null) {
        throw IllegalArgumentException("null이 들어왔습니다");
    }
    return str.startsWith("A")
}

fun startsWithA2(str: String?): Boolean? {
    if (str == null) {
        return null
    }
    return str.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    if (str == null) {
        return false
    }
    return str.startsWith("A")
}

fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}

fun startsWithA1Advance(str: String?): Boolean {
    return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다")
}

fun startsWithA2Advance(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA3Advance(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

fun calculate(number: Long?): Long {
    number ?: return 0 // early return 에도 elvis 사용 가능
    return 1
}

fun startsWith(str: String?): Boolean {
    // !! -> null 아님 단언 - 아무리 생각해도 null 이 들어올 수 없을 거라 판단될 때 사용 (null 이 혹시나 들어가면 npe 가 발생해서 정말 확실할 때만 사용)
    return str!!.startsWith("A")
}
