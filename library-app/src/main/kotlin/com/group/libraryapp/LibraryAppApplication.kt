package com.group.libraryapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LibraryAppApplication

// 코틀린은 top line 에 여러 클래스와 함수를 만들 수 있고, 함수인 경우 static 으로 감지된다.
fun main(args: Array<String>) {
    // 코틀린에서 제공하는 SpringApplicationExtensions.kt 의 runApplication 을 사용한다.
    runApplication<LibraryAppApplication>(*args) // vararg 함수의 매개변수에 배열 인자 전달 시 *(스프레드 연산자) 필수
}