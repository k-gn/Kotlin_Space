package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import java.lang.IllegalArgumentException
import javax.persistence.*

/*
    1. Setter 는 열어두어도 되도록 사용하지 말 것
        - setter 대신 좋은 이름의 함수를 사용하는 것이 더 클린하다.
        - 팀과의 컨벤션을 정하고 잘 맞추면 된다!
    2. 생성자 안에 모든 프로퍼티를 작성하거나, 어떠한 명확한 기준을 가지고 생성자 프로퍼티와 class body 프로퍼티를 구분하여 작성하면 된다.
    3. JPA Entity 는 순환참조로 인한 이슈가 발생하기 쉬워 Data class 를 지양하자.
 */
@Entity
// tip. 생성자에 constructor 키워드를 생략하지 않고 붙여 사용하면, 해당 생성자가 호출되는 곳을 추적하기 쉬워진다.
class User constructor(
    var name: String,

    val age: Int?,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val userLoanHistories: MutableList<UserLoanHistory> = mutableListOf(), // 가변 컬렉션

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    // init 블럭은 주 생성자의 일부로 부 생성자보다 먼저 호출된다.
    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다.")
        }
    }

    fun updateName(name: String) {
        this.name = name
    }

    fun loanBook(bookName: String) {
        this.userLoanHistories.add(UserLoanHistory(this, bookName))
    }

    fun returnBook(bookName: String) {
        // 첫번째 true 원소 찾기
        this.userLoanHistories.first { history -> history.bookName == bookName }.doReturn();
    }
}