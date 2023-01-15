package com.lannstark.lec17

fun main() {
    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000)
    );
    
    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    val isApple2 = { fruit: Fruit -> fruit.name == "사과" }

    isApple(fruits[0])
    isApple.invoke(fruits[0])

    // param 이 하나면 it 으로 참조하여 사용 가능
    val isApple3: (Fruit) -> Boolean = { it.name == "사과" }

    filterFruits(fruits, isApple3)
    filterFruits(fruits) { it.name == "사과" }

    // 람다는 여러줄 작성될 수 있고, return 이 없어도 마지막 표현식 줄이 return 된다.
    // 람다가 실행되는 시점에 쓰고 있는 변수들을 모두 포획한 데이터 구조를 클로져라고 한다.
    // 코틀린은 클로져로 인해 람다 안에서 final 이 아닌 가변 변수를 사용할 수 있다!
}

private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return fruits
}

private fun filterFruitsLambda(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    return fruits.filter(filter)
}
