package basics

/*
    - 코틀린은 불변(immutability) 변수 사용을 권장
 */
fun main() {
    var a: String = "처음값" // 가변
    a = "다른값"
    println(a)
    val b: Int = 1 // 불변
    val c = 3 // 타입 추론 가능

    var e: Int // 초기화 하지 않고 선언은 가능하나 사용전에 반드시 초기화 해야한다.
    val d: Int
    d = 1
    println(d)
}