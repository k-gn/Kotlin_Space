package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import com.group.libraryapp.dto.book.response.BookStatResponse
import com.group.libraryapp.util.fail
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository,
) {

    @Transactional
    fun saveBook(request: BookRequest) {
        val newBook = Book(request.name, request.type)
        bookRepository.save(newBook)
    }

    @Transactional
    fun loanBook(request: BookLoanRequest) {
        val book = bookRepository.findByName(request.bookName) ?: fail()
        if (userLoanHistoryRepository.findByBookNameAndStatus(request.bookName, UserLoanStatus.LOANED) != null) {
            throw IllegalArgumentException("진작 대출되어 있는 책입니다.")
        }

        val user = userRepository.findByName(request.userName) ?: fail()
        user.loanBook(book.name)
    }

    @Transactional
    fun returnBook(request: BookReturnRequest) {
        val user = userRepository.findByName(request.userName) ?: fail()
        user.returnBook(request.bookName)
    }

    @Transactional(readOnly = true)
    fun countLoanedBook(): Int {
        return userLoanHistoryRepository.countByStatus(UserLoanStatus.LOANED).toInt()
    }

    @Transactional(readOnly = true)
    fun getBookStatistics(): List<BookStatResponse> {
        /*
            상황에 따라 다르겠지만 count or grouping 은
            애플리케이션 단에서 모든 데이터를 가져와 처리하는 것 보다
            보통 DB 에서 가져올 때 처리를 하는 방법이
            네트워크, 애플리케이션 등의 부하를 줄일 수 있다.
            추가로 인덱스를 이용해 튜닝할 여지도 있다.

            데이터의 양, 트래픽, 다른 요구사항에 따라 다른 방법을 사용해야 할 수도 있다.
            - 대용량 통계 처리 배치를 이용한 구조
            - 이벤트 발행과 메시징 큐를 이용한 구조
            (다양한 시스템 아키텍처에 대한 고민이 필요하다.)
         */
        return bookRepository.getStats()

        /*return bookRepository.findAll() // List<Book>
            .groupBy { book -> book.type } // Map<BookType, List<Book>>
            .map { (type, books) -> BookStatResponse(type, books.size) } // List<BookStatResponse>*/

        /*val results = mutableListOf<BookStatResponse>()
        val books = bookRepository.findAll();
        for (book in books) {
            results.firstOrNull { dto -> book.type == dto.type }?.plusOne()
                ?: results.add(BookStatResponse(book.type, 1))
        }
        return results;*/
    }
}