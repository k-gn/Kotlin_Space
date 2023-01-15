package com.lannstark.lec14

/*
    - Enum class
        - 추가적인 클래스 상속이 불가
        - 인터페이스는 구현가능
        - 각 코드가 싱글톤
 */
enum class Country(
    private val code: String,
) {

    KOREA("KO"),
    AMERICA("US")
    ;
}

fun handleCountry(country: Country) {
    // when 과 함께 쓰면 분기 처리가 if 에 비해 좋고, 변화를 알 수 있다.
    when (country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
    }
}

