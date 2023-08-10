package specialclass

import java.util.*

/*
    클래스와 오브젝트는 대부분의 객체 지향 언어에서와 같은 방식으로 작동

    코틀린에는 object 키워드를 써서 특별한 단일 인스턴스를 만들 수 있습니다.
    자바 개발을 해보신 분은 "단일"의 뜻이 싱글톤(singleton) 패턴 인스턴스를 의미한다고 보시면 됩니다.
    여러 스레드에서 동시에 사용하려고 하더라도 딱 하나의 인스턴스만 생성됩니다.
    lazy 인스턴스 생성
 */
class LuckDispatcher {
    fun getNumber() {
        var objRandom = Random()
        println(objRandom.nextInt(90))
    }
}

fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {  

    // object 식
    // 간단히 할 때는 클래스를 선언할 필요 없이 오브젝트를 하나 만들어서 그 안에 멤버들을 선언해 두고 접근 가능
    val dayRates = object {                                                     
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special      
    
    print("Total price: $$total")                                             
}

// object 단일 인스턴스
// 별도의 인스턴스를 만들지 않고, 해당 오브젝트의 멤버에 곧바로 접근할 수 있습니다.
object DoAuth {
    fun takeParams(username: String, password: String) {
        println("input Auth parameters = $username:$password")
    }
}

// 동반 오브젝트 Companion Objects
// 자바의 정적(static) 메서드와 비슷하게 클래스 이름을 통해서 해당 오브젝트 멤버에 접근할 수 있습니다.
// 틀린에서 동반 오브젝트를 쓸만한 상황이라면, 패키지에 곧바로 함수를 선언해 쓰는 toplevel 방법을 고려할 것
class BigBen {
    companion object {
        fun getBongs(nTimes: Int) {
            for (i in 1 .. nTimes) {
                print("BONG ")
            }
        }
    }
}


fun main() {
    DoAuth.takeParams("foo", "qwerty")
    
    BigBen.getBongs(12)
}
