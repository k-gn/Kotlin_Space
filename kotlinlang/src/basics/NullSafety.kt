package basics

/*
    - 기본 코틀린의 변수에는 null을 지정할 수 없게 되어있습니다.
    - 만약 변수가 null이 될 수도 있게 하려면, 타입의 끝에 ?표시를 붙여 두어야만 합니다.
 */
fun main() {
    var neverNull: String = "이 변수는 null이 될 수 없습니다"
    // neverNull = null

    var nullable: String? = "이 변수는 null이 될 수 있습니다"
    nullable = null

    var inferredNonNull = "컴파일러 타입추론은 null-불가로 봅니다"
    // inferredNonNull = null

    strLength(neverNull)
    // strLength(nullable)
}

fun strLength(notNull: String): Int {
    return notNull.length
}

fun describeString(maybeString: String?): String {
    return if (maybeString != null && maybeString.isNotEmpty()) {
        "문자열 길이: ${maybeString.length}"
    } else {
        "빈 문자열이거나 null입니다"
    }
}