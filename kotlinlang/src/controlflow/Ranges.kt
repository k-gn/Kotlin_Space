package controlflow

fun main() {
    for (i in 0..3) { // 마지막 포함
        print(i)
    }
    println()

    for (i in 0 until 3) { // 마지막 제외
        print(i)
    }
    println()

    for (i in 2..8 step 2) { // 연속 요소에서 몇 단계씩 증가할지 지정
        print(i)
    }
    println()

    for (i in 3 downTo 0) { // 특정 범위를 거꾸로 순회
        print(i)
    }
    println()

    for (c in 'a'..'d') { // 문자 범위를 알파벳 순서대로 순회
        print(c)
    }
    println()

    for (c in 'z' downTo 's' step 2) { // 문자 범위에도 step이나 downTo를 쓸 수 있다.
        print(c)
    }
    println()

    // if 문 안에서의 범위
    val x = 2
    if (x in 1..5) { // 값이 범위 안에 있는지 확인
        print("x는 1에서 5 사이의 수")
    }
    println()

    if (x !in 6..10) { // !in는 in의 반대
        print("x는 6에서 10 사이의 수가 아님")
    }
}