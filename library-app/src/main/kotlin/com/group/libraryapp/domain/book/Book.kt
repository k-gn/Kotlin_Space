package com.group.libraryapp.domain.book

import java.lang.IllegalArgumentException
import javax.persistence.*

@Entity
class Book(
    val name: String,

    @Enumerated(EnumType.STRING)
    val type: BookType,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다.")
        }
    }

    companion object {
        // 테스트 코드의 유지보수 편리성을 위한 정적 메소드 패턴 (프로퍼티가 추가될 때 여기만 고치면 된다.)
        // 도메인에 대한 fixture 는 자주 사용하지만, dto 에 대한 fixture 는 상황에 맞게 생성한다.
        fun fixture(
            name: String = "책 이름",
            type: BookType = BookType.COMPUTER,
            id: Long? = null,
        ): Book {
            return Book(
                name = name,
                type = type,
                id = id,
            )
        }
    }

    fun getEventScore(): Int {
        return type.score
    }
}