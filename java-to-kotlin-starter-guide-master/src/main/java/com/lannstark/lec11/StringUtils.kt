package com.lannstark.lec11

// 자바에서 abstract class + private constructor 를 사용해 인스턴스화를 막고 유틸성 코드 생성하는 것처럼 코틀린에서 사용하는 방법
// 파일 최상단에 작성하면 편리하다. (정적 메소드처럼 그냥 사용 가능)
fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}