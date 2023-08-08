package basics

/*
    - 중위 함수
        - 파라미터를 하나만 받는 멤버 함수나 확장(extension) 함수는, 해당 함수를 "중위 함수" 형태로 쓸 수 있습니다.
 */
fun main() {
    infix fun Int.times(str: String) = str.repeat(this) // 지역 함수
    println(2 times "Bye ")

    val pair = "자바" to "오라클"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "코틀린" onto "젯브레인스"
    println(myPair)

    val koo = Person("손석구")
    val yeon = Person("장도연")
    koo likes yeon
    koo.printLikedPeople()
}

class Person(val name: String) {
    private val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {
        likedPeople.add(other)
    }

    fun printLikedPeople() {
        println(likedPeople.map { it.name })
    }
}