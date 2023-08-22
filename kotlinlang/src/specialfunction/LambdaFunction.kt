package specialfunction

/*
    람다 함수는 그 자리에서 곧바로 함수를 만드는 간단한 방법입니다. 타입추론 기능과 암묵적 it 변수 덕분에 매우 간결하게 람다 함수를 작성할 수 있습니다.
 */

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val upperCase1: (String) -> String = { str: String -> str.uppercase() }

    val upperCase2: (String) -> String = { str -> str.uppercase() } // 추론

    val upperCase3 = { str: String -> str.uppercase() } // 추론

 // val upperCase4 = { str -> str.uppercase() } // 둘다 추론 불가

    val upperCase5: (String) -> String = { it.uppercase() } // 파라미터 한 개를 받는 람다의 경우, 별도로 이름을 주지 않고, 암묵적으로 it 변수를 사용할 수 있다.

    val upperCase6: (String) -> String = String::uppercase // 람다가 딱 한 번의 함수 호출로 구성된다면, 함수를 지칭하는 (::) 표기법으로 선언할 수 있다.

    println(upperCase1("hello"))
    println(upperCase2("hello"))
    println(upperCase3("hello"))
    println(upperCase5("hello"))
    println(upperCase6("hello"))
}