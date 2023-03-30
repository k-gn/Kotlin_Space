package com.lannstark.lec01

fun main() {

    /*
        코틀린에서는 자동으로 타입을 추론해준다.
        원할 경우 명시적으로 작성할 수 있다.

        ** tip
        모든 변수는 우선 val (불변) 으로 만들고 꼭 필요한 경우 var 로 변경한다.
        -> 코드가 깔끔하고 디버깅하기 쉬워진다.
     */

    // 가변 변수 선언
    var number1 = 10L

    // 상수 변수 선언
    val number2: Long = 10L

    number1 = 5L
    // number2 = 5L

    /*
        초기값을 지정하지 않을 경우 타입을 추론할 수 없어 예외가 일단 발생한다.
        -> 따라서 타입 선언을 해줘야 한다.

        또한 초기화 하지 않은 변수를 사용하려 한다면 예외가 발생한다.
     */
    var number3: Long
    number3 = 10L

    val number4: Long
    number4 = 10L // 최초 한번 초기화 가능

    /*
        * 번외
            final ArrayList 일 때 배열자체는 못바꾸지만 배열 안에 값들은 건드릴 수 있다.
        단. Arrays.asList 로 생성 시 값들을 건드릴 수 없다. (고정 크기의 List를 반환하기 때문에 예외가 발생)
     */


    /*
        * primitive type 과 reference type

        자바에선 연산을 할 땐 primitive type 을 사용해야 한다.
        -> 불필요한 boxing, unboxing 으로 객체생성이 일어나기 때문

        코틀린은 ?
        -> 코틀린은 boxing, unboxing 를 고려하지 않아도 될 정도로 자기가 알아서 똑똑하게 처리해줘서 크게 신경쓸 필요가 없다.
     */

    // type + ? : nullable
    var number5: Long? = 1000L
    number5 = null

    // class type (new 를 붙이지 않는다!)
    var person = Person("김규남")
    print(person.name)
}
