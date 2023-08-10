package specialclass

/*
    데이터 클래스는 평범한 값들을 보관하는 용도의 클래스를 쉽게 만드는 데 씁니다
    클래스를 복제하거나 문자열 표현을 하거나 컬렉션의 값으로 쓸 때 필요한 메서드들을 자동으로 만들어 줍니다
 */

data class User(val name: String, val id: Int) {
    override fun equals(other: Any?) =
        other is User && other.id == this.id
}

fun main() {
    val user = User("석구", 1)
    println(user)

    val secondUser = User("석구", 1)
    val thirdUser = User("동석", 2)

    println("user == secondUser: ${user == secondUser}")
    println("user == thirdUser: ${user == thirdUser}")

    // hashCode() function
    println(user.hashCode())
    println(secondUser.hashCode())
    println(thirdUser.hashCode())

    // copy() function - copy는 새로운 인스턴스를 만들기 때문에, 원래의 인스턴스와 새 인스턴스는 다른 참조값을 갖습니다.
    println(user.copy())
    println(user === user.copy())
    println(user.copy("동석")) // 데이터 클래스를 복제할 때 특정 속성을 바꿀 수 있습니다.
    println(user.copy(id = 3))

    println("name = ${user.component1()}") // 자동 생성되는 componentN 함수를 써서, 데이터 클래스를 정의할 때의 속성들을 순서대로 접근
    println("id = ${user.component2()}")
}