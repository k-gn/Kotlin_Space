package specialclass

// 딱 정해진 수의 구분된 값들을 표현하는 데에 쓰는 타입
// 보통 클래스와 마찬가지로 속성이나 메서드를 추가할 수 있고, 각 Enum 상수는 세미콜론으로 구분해 선언
enum class State {
    IDLE, RUNNING, FINISHED
}

fun main() {
    val state = State.RUNNING
    // when-조건식에 쓸 때에는 컴파일러가 모든 경우의 수를 모두 다루었는지 확인할 수 있기 때문에 else-조건이 없어도 됩니다.
    val message = when (state) {
        State.IDLE -> "대기 중"
        State.RUNNING -> "실행 중"
        State.FINISHED -> "완료"
    }
    println(message)

    val red = Color.RED
    println(red)
    println(red.containsRed())
    println(Color.BLUE.containsRed())
    println(Color.YELLOW.containsRed())
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0) // and(&) 연산
}