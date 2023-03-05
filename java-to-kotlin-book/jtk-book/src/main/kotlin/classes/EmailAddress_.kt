package classes

import java.util.*

/**
 * data class : equals, hashcode, toString 을 자동으로 생성해준다.
 *
 * 단, 데이터 클래스는 캡슐화를 제공하지 않는다. (copy method도 함께 생성하기 때문)
 * ex. val postmasterEmail = customerEmail.copy(localPart = "postmaster")
 * 위 예시처럼 내부 상테에 직접 접근하도록 허용해서 불변 조건을 깰 수 있다는 문제가 있다.
 */
data class EmailAddress_(
    val localPart: String,
    val domain: String
) {
    override fun toString(): String {
        return "$localPart@$domain"
    }

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress_ {
            val atIndex = value.lastIndexOf('@')
            require(!(atIndex < 1 || atIndex == value.length - 1)) {
                "EmailAddress must be two parts separated by @"
            }
            return EmailAddress_(
                value.substring(0, atIndex),
                value.substring(atIndex + 1)
            )
        }
    }
}