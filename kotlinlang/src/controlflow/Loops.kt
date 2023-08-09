package controlflow

fun main() {
    val cakes = listOf("당근", "치즈", "초콜릿")

    // for
    for (cake in cakes) {
        println("맛있는 ${cake}케이크!")
    }

    var cakesEaten = 0
    var cakesBaked = 0

    // while
    while (cakesEaten < 5) {
        eatACake()
        cakesEaten++
    }

    // do-while
    do {
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)

    // Iterators
    val zoo = Zoo(listOf(Animal("얼룩말"), Animal("사자")))
    for (animal in zoo) {
        println("여기 ${animal.name} 있어요!")
    }
}

fun eatACake() = println("케이크 먹기")
fun bakeACake() = println("케이크 굽기")

class Animal(val name: String)

class Zoo(private val animals: List<Animal>) {
    // 클래스를 만들 때 iterator 연산자를 구현하면, 나만의 이터레이터를 정의할 수 있습니다.
    // 이터레이터는 타입 안에 직접 선언하거나, 확장(extension) 함수의 형태로 타입 밖에서 따로 선언할 수도 있습니다.
    // * next(): Animal
    // * hasNext(): Boolean
    operator fun iterator(): Iterator<Animal> {
        return animals.iterator()
    }
}
