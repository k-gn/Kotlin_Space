package com.group.libraryapp.dto.book.request;

import org.jetbrains.annotations.NotNull;

public class BookLoanRequest {

  private String userName;
  private String bookName;

  public BookLoanRequest() {

  }

  public BookLoanRequest(
      String userName,
      String bookName
  ) {
    this.userName = userName;
    this.bookName = bookName;
  }

  @NotNull
  public String getUserName() {
    return userName;
  }

  @NotNull
  public String getBookName() {
    return bookName;
  }

}
