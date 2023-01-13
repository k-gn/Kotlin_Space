package com.lannstark.lec04

fun main() {

    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)
    val money3 = JavaMoney(1_000L)

    // 코틀린에선 compareTo 를 알아서 실행해준다.
    if (money1 > money2) {
        println("Money1이 Money2보다 금액이 큽니다.")
    }

    // 동등성 : 정체성이 동일 (래퍼런스가 같은지) / 동일성 : 값이 동일
    // 코틀린에선 동일성에 ===. 동등성에 == 를 호출 ('==' 사용 시 equals 를 호출해준다.)
    println(money2 == money3)
    println(money2 === money3)

    // * 쇼트서킷도 (Lazy) 동작한다.

    /*
        - in / !in
            - 컬렉션이나 범위에 포함되어 있다 / 포함되어 있지 않다.
        - a..b
            - a ~ b 까지의 범위 객체 생성
        - a[i]
            - a 에서 특정 index i로 값을 가져온다.
        - a[i] = b
            - a 의 특정 index i에 b를 넣는다.
     */

    // 코틀린은 객체의 직접 연산을 정의할 수 있다. (연산자 오버로딩)
    val money4 = Money(1_000L)
    val money5 = Money(2_000L)
    println(money4 + money5)
}


data class Money(
    val amount: Long
) {

    operator fun plus(other: Money): Money {
        return Money(this.amount + other.amount)
    }
}