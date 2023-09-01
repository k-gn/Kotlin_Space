package collections

// filter 함수로 컬렉션의 요소들을 선별할 수 있습니다.
val numbers = listOf(1, -2, 3, -4, 5, -6)
val positives = numbers.filter { x -> x > 0 }
val negatives = numbers.filter { it < 0 }

// 하나라도 있나? any (any 함수는 컬렉션에 주어진 명제에 참인 요소가 하나라도 있으면 true를 반환)
val numbers2 = listOf(1, -2, 3, -4, 5, -6)            // 1
val anyNegative = numbers2.any { it < 0 }             // 2
val anyGT6 = numbers2.any { it > 6 }

// 모두 그런가? all (all 함수는 모든 요소가 해당 명제를 만족할 때 true를 반환)
val numbers3 = listOf(1, -2, 3, -4, 5, -6)            // 1
val allEven = numbers3.all { it % 2 == 0 }            // 2
val allLess6 = numbers3.all { it < 6 }

// 없나? none (주어진 조건에 해당하는 요소가 하나도 없는 경우에만 true를 반환)
val numbers4 = listOf(1, -2, 3, -4, 5, -6)
val noneEven = numbers4.none { it % 2 == 1 }
val noneLess6 = numbers4.none { it > 6 }

// find 함수는 어떤 컬렉션에 주어진 명제에 참인 있는지 앞에서부터 차례로 찾아봅니다
// findLast 함수는 마찬가지로 주어진 명제에 참인 요소를 찾는데, 뒤에서부터 순서대로 찾는다는 점이 다릅니다
// 두 함수 모두, 조건에 해당하는 요소가 없다면 null을 반환
val words = listOf("컬렉션에", "있는", "어떤", "아이템", "골라서", "찾기")
val first = words.find { it.startsWith("아이") }
val last = words.findLast { it.startsWith("아이") }
val nothing = words.find { it.contains("없는") }

fun main() {
    println(anyNegative)
    println(allLess6)
    println(noneLess6)

    println("\"아이\"로 시작하는 첫번째 단어는 \"$first\"입니다.")
    println("\"아이\"로 시작하는 마지막 단어는 \"$last\"입니다.")
    println("\"없는\"을 포함한 단어는 ${nothing?.let { "\"$it\"" } ?: "null"}입니다.")
}
