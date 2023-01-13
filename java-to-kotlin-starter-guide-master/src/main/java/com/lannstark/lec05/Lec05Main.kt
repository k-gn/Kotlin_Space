package com.lannstark.lec05

import java.lang.IllegalArgumentException

fun main() {

}

fun validateScoreIsNotNegative(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    }
}

fun getPassOrFail(score: Int): String {
    if (score < 0) {
        return "P"
    } else {
        return "F"
    }
}

/*
    Statement: 프로그램의 문장, 하나의 값으로 도출되지 않는다.
    Expression:: 하나의 값으로 도출되는 문장

    ex. int score = 30 + 40 에서 30 + 40 은 70 이라는 하나의 결과 + 문장 (expression + statement)

    자바에서 if 문은 값으로 취급하지 않지만 코틀린에선 값으로도 취급한다.
    단. 코틀린에선 해당 이유로 삼항 연산자가 없다.
 */
fun getPassOrFailExpr(score: Int): String {
    return if (score < 0) {
        "P"
    } else {
        "F"
    }
}

fun getGrade(score: Int): String {
    return if (score !in 80..100) { // 특정 범위에 포함 여부 (between)
        throw IllegalArgumentException()
    } else {
        "A"
    }
}

fun getGradeWithSwitch(score: Int): String {
    return when (score) {
        // 어떠한 조건식도 들어갈 수 있다.
        in 90..99 -> "A"
        in 80..89 -> "B"
        else -> "C"
    }
}

fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(num: Int) {
    when (num) {
        1, 0, -1 -> println("어디서 많이 본 숫자입니다.")
        else -> println("1, 0, -1이 아닙니다.")
    }
}

fun judgeNumber2(num: Int) {
    when {
        num == 0 -> println("0 입니다.")
        num % 2 == 0 -> println("짝수입니다.")
        else -> println("홀수입니다.")
    }
}

// when 은 enum class or sealed class 와 잘 어울린다.