package specialfunction

/*
    확장 기능으로 이미 있는 특정 클래스에 새로운 멤버를 나중에 추가할 수 있습니다.
    확장함수와 확장속성이 있고, 둘 다 보통의 함수와 속성처럼 생겼지만 한 가지 중요한 차이점이 있습니다.
    어떤 타입에서 확장할지 명시한다는 점이 다릅니다.
 */

data class Item(val name: String, val price: Int)

data class Order(val items: Collection<Item>)

fun Order.maxPricedItemValue(): Int = this.items.maxByOrNull { it.price }?.price ?: 0
fun Order.maxPricedItemName() = this.items.maxByOrNull { it.price }?.name ?: "NO_PRODUCTS"

val Order.commaDelimitedItemNames: String
    get() = items.map { it.name }.joinToString()

fun main() {

    val order = Order(listOf(Item("빵", 5000), Item("와인", 29000), Item("생수", 1500)))

    println("가장 비싼 식료품: ${order.maxPricedItemName()}")
    println("가장 비싼 가격: ${order.maxPricedItemValue()}")
    println("식료품: ${order.commaDelimitedItemNames}")

}

fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"