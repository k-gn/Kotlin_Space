package com.group.libraryapp.util

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull

fun fail(): Nothing {
  throw IllegalArgumentException()
}

// 확장함수를 사용하여 제어할 수 없을 것 같은 JPA 함수의 리턴타입을 제어할 수 있다. (CrudRepositoryExtensions.kt)
// CrudRepository 안에 함수가 마치 존재하는 것 처럼 사용할 수 있다.
fun <T, ID> CrudRepository<T, ID>.findByIdOrThrow(id: ID): T {
  return this.findByIdOrNull(id) ?: fail() // 여기서 this = CrudRepository
}