package com.group.libraryapp.dto.book.request;

import org.jetbrains.annotations.NotNull;

public class BookRequest {

  private String name;

  public BookRequest() {

  }

  public BookRequest(String name) {
    this.name = name;
  }

  @NotNull
  public String getName() {
    return name;
  }

}
