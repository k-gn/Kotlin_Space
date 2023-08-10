package specialclass

// 클래스 상속을 특정 범위로 제한 가능 (클래스 구조를 통제된 범위안에서 사용)
// 오로지 같은 패키지 안에서만 상속해서 하위 클래스를 만들 수 있습니다.
// when 으로 모든 클래스 커버 가능
sealed class Mammal(val name: String)

class Cat(val catName: String) : Mammal(catName)
class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    return when (mammal) {
        is Human -> // smart casting
            "안녕하세요, ${mammal.name}님. 직업은 ${mammal.job}이군요."
        is Cat ->
            "안녕 ${mammal.name}"
    }
}

fun main() {
    println(greetMammal(Cat("Snowy")))
}