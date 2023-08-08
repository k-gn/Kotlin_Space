package basics

/*
    # 상속
        - 코틀린에서 클래스는 기본적으로 최종(final) -> 상속을 허용하려면 반드시 open 제어자를 표시
        - 코틀린에서 메서드도 기본적으로 최종(final) -> 재정의(override)를 허용하려면 open 키워드 표시
 */
open class Dog {
    open fun sayHello() {
        println("멍멍!")
    }
}

class Yorkshire : Dog() {
    override fun sayHello() {
        println("왈왈!")
    }
}

fun main() {
    val dog: Dog = Yorkshire()
    dog.sayHello()
}

open class Tiger(private val origin: String) {
    fun sayHello() {
        println("${origin}의 타이거 왈: 어흥!")
    }
}

class SiberianTiger : Tiger("시베리아")

open class Lion(
    private val name: String,
    private val origin: String)
{
    fun sayHello() {
        println("$name, ${origin}에서 온 사자 왈: 으르렁!")
    }
}

class Asiatic(name: String) : Lion(name = name, origin = "인도")