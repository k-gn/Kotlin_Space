package com.group.libraryapp.dto.user.response

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus

data class UserLoanHistoryResponse(
  val name: String, // 유저 이름
  val books: List<BookHistoryResponse>
) {
  // 정적 팩토리 메서드를 활용해 DTO 생성 역할을 넘긴다.
  companion object {
    fun of(user: User): UserLoanHistoryResponse {
      return UserLoanHistoryResponse(
        name = user.name,
        books = user.userLoanHistories.map(BookHistoryResponse::of)
      )
    }
  }
}

data class BookHistoryResponse(
  val name: String, // 책의 이름
  val isReturn: Boolean,
) {
  companion object {
    fun of(history: UserLoanHistory): BookHistoryResponse {
      return BookHistoryResponse(
        name = history.bookName,
        isReturn = history.isReturn,
      )
    }
  }
}
