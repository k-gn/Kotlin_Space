package controlflow

/*
    - 조건 ? 참일 때 : 거짓일 때 3항 연산자가 따로 없습니다. if문이 식의 형태로 그 역할을 대신합니다.
 */
fun main() {
    fun max(a: Int, b: Int) = if (a > b) a else b
    println(max(99, -42))
}