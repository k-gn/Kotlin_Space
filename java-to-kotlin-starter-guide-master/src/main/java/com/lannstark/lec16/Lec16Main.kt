package com.lannstark.lec16

fun main() {
    3 add 4
}

// 확장 함수
// 추가기능 개발을 위해 등장
// this 로 자신을 호출하고, 생략할 수도 있다.
// 원래 있는 멤버함수 처럼 사용할 수 있다.
// 확장함수는 클래스에 private, protected 멤버를 가져올 수 없다.
// 확장함수와 멤버함수 중 멤버함수가 우선적으로 호출된다.
fun String.lastChar(): Char {
    return this[this.length - 1]
}

// 타입에 따라 호출되는 확장함수가 결정된다
// 정적 메소드를 부르는 것 처럼 사용 가능
// 확장 프로퍼티도 가능하다.
val String.lastChar: Char
    get() = this[this.length - 1]

// infix 키워드로 중위함수 호출 방식 가능
infix fun Int.add(other: Int): Int {
    return this + other
}

// inline 키워드로 함수를 호출한 지점에 함수 본문을 그대로 복붙한다.
// 함수를 파라미터로 전달할 때 콜 체인 오버헤드를 줄일 수 있다.
// inline 처리는 1~3줄 정도의 길이를 권장한다.
inline fun Int.add2(other: Int): Int {
    return this + other
}

// 지역함수 - 함수안에 함수를 선언할 수 있다.