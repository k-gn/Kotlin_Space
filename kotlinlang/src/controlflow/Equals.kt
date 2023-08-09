package controlflow

/*
    - 코틀린에서는 구조적으로 비교할 때 ==(equals) 를 쓰고, 참조값을 비교할 때 === 를 씁니다.
 */
fun main() {
    val authors = setOf("셰익스피어", "헤밍웨이", "트웨인")
    val writers = setOf("트웨인", "셰익스피어", "헤밍웨이")

    println(authors == writers)
    println(authors === writers)
}