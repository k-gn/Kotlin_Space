package collections

/*
    코틀린의 리스트는 크게 두 종류가 있는데, 하나는 변경 가능한 리스트(MutableList)고, 다른 하나는 읽기전용 리스트(List)가 있습니다.
    리스트를 만들려면, 표준 라이브러리에 있는 함수인 listOf()를 써서 읽기전용 리스트를 만들거나, mutableListOf() 함수를 써서 변경가능 리스트를 만듭니다.
 */

val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)
val sudoers: List<Int> = systemUsers

fun addSystemUser(newUser: Int) {
    systemUsers.add(newUser)
}

fun getSysSudoers(): List<Int> {
    return sudoers
}

fun main() {
    addSystemUser(4)
    println("전체 sudoers: ${getSysSudoers().size}")
    getSysSudoers().forEach {
            i -> println("이용자 ${i}에 대한 정보")
    }
    // getSysSudoers().add(5) <- Error!
}