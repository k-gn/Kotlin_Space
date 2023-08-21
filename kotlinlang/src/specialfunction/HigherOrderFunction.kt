package specialfunction

/*
    # 고차 함수는 다른 함수를 파라미터로 받거나, 반환값으로 함수를 돌려주는 함수
 */

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun sum(x: Int, y: Int) = x + y

fun main() {
    val sumResult = calculate(4, 5, ::sum) //  ::는 어떤 함수를 이름으로 지칭하는 표기법
    val mulResult = calculate(4, 5) { a, b -> a * b }// 람다
    println("sumResult $sumResult, mulResult $mulResult")
}

// 함수를 반환하는 함수
fun operation(): (Int) -> Int {
    return ::square
}

fun square(x: Int) = x * x