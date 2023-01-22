package com.group.libraryapp.dto.user.response

import com.group.libraryapp.domain.user.User

/*
    dto 클래스는 data class 로 만들어 주면 도움이 된다.
 */
data class UserResponse(
    val id: Long,
    val name: String,
    val age: Int?,
) {

    // 정적 팩토리 메서드 방법
    companion object {
        fun of(user: User): UserResponse {
            return UserResponse(
                id = user.id!!, // null 아님 단언 (null 이 들어올 수 없는 구조라서)
                name = user.name,
                age = user.age
            )
        }
    }

    // 부생성자 방법
    /*constructor(user: User) : this(
        id = user.id!!,
        name = user.name,
        age = user.age
    )*/

}