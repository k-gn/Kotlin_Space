package com.lannstark.lec09

fun main() {

    // .필드 를 통해 접근 가능
    val person = Person("이름", 10)

    println(person.name)
    person.age = 20
    println(person.age)
    println(person.isAdult) // 함수를 프로퍼티 처럼 사용


}

// constructor 지시어 생략 가능
class Person( // 주 생성자 (반드시 존재 - 파라미터가 하나도 없다면 생략 가능)
    // 코틀린은 생성자에서 프로퍼티를 만들 수 있다.
    val name: String,
    var age: Int,
    value: String = "hello"
) {
    /*
        코틀린은 필드만 만들면 알아서 getter, setter 를 만들어준다
        프로퍼티 = 필드 + getter + setter
     */
    //val name = name
    //var age = age

    // 초기화 블록
    init {
        if (age <= 0) {
            throw IllegalArgumentException()
        }
    }

    // 부 생성자 (추가적으로 만들고 싶을 때, 최종적으로 this 를 호출해야 한다.)
    constructor(name: String) : this(name, 10) {
        // body 를 가질 수 있다.
        println("부 생성자")
    }

    // 초기화 블록 -> 부생성자 순으로 실행된다..
    // 코틀린은 부생성자 보단 정적 팩토리 메소드 또는 default parameter 를 권장한다!

    // custom getter
    val isAdult: Boolean
        get() = this.age >= 20

//    fun isAdult(): Boolean {
//        return this.age >= 20
//    }
    // 객체의 속성이라면 custom getter, 아니면 함수를 쓰자


    // custom setter / custom getter
    // 자기 자신을 변형할 수 있다.
    // 필드명으로 부르면 getter 를 호출함 -> 무한루프 발생 (계속 자기 자신을 호출)
    // 이 때 field 를 사용하면 된다. (backing field)
    var value = value
        get() = field.uppercase()
        set(value) {
            field = value.uppercase()
        }

    // backing field 를 사용하는 경우도 드물긴 하다. (위 예를 아래처럼 사용함)
    // setter 는 지양하는게 좋아서 잘 안씀
    fun getUppercaseValue(): String = this.value.uppercase()
}