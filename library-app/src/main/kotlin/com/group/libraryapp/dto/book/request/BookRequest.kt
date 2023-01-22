package com.group.libraryapp.dto.book.request

import com.group.libraryapp.domain.book.BookType

data class BookRequest(
    var name: String,
    val type: BookType,
) {
}