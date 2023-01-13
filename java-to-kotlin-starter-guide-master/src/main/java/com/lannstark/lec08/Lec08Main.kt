package com.lannstark.lec08

fun main() {
    // 매개변수 이름을 지정하여 전달할 수 있다.
    // default 값이 있는 인자는 안보내도 된다!
    // 단, 자바 함수를 가져다 쓸 땐 사용할 수 없다.
    repeat(str = "hello", useNewLine = false)

    printAll("a", "b", "c")
    val array = arrayOf("A", "B", "C")
    // * 을 넣어줘야 한다 (스프레드 연산자)
    // -> 배열 안에 값들을 , 를 쓴 것처럼 꺼내준다~ 라는 연산자
    printAll(*array)
}

/*
    # 함수 선언 문법
        1. return 과 {} 을 없애고 = 를 쓸 수 있다.
        2. 반환타입 생략 가능
        3. 내부 중괄호 생략 가능
 */
fun max(a: Int, b: Int) = if (a > b) a else b


/*
    # default parameter
 */

fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true,
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            println(str)
        }
    }
}

/*
    # 가변 인자
 */

fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}