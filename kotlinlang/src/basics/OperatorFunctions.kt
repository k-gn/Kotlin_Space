package basics

/*
    - 연산자 함수
        - 특정 함수들은 연산자로 "업그레이드"될 수 있고, 해당 연산자를 써서 그 함수를 호출할 수 있습니다.

    - vararg 파라미터
        - 쉼표로 연달아 쓴 파라미터들을 전달한다.
 */

fun main() {
    operator fun Int.times(str: String) = str.repeat(this)
    println(2 * "하이 ")

    operator fun String.get(range: IntRange) = substring(range)
    val str = "ABCDEFG"
    println(str[0..3])

    printAll("Hello", "Hallo", "Salut", "Hola", "안녕")
    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "안녕",
        prefix = "Greeting: "
    )
    log("Hello", "Hallo", "Salut", "Hola", "안녕")
}

fun printAll(vararg messages: String) {
    for (m in messages) println(m)
}

fun printAllWithPrefix(vararg messages: String, prefix: String) {
    for (m in messages) println(prefix + m)
}

fun log(vararg entries: String) {
    // 배열을 vararg 파라미터로 전달하려면, * 연산자를 써서 전달
    printAll(*entries)
    // * 연산자 없이 entries로 쓰면 Array<String>으로 인식
}