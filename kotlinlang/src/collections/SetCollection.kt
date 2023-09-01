package collections

/*
   집합은 순서는 무관하되 중복값이 없는 컬렉션입니다. setOf() 함수나 mutableSetOf() 함수를 써서 집합을 만들 수 있습니다.
 */

val openIssues: MutableSet<String> =
    mutableSetOf("uniqueDescr1", "uniqueDescr2", "uniqueDescr3")

fun addIssue(uniqueDesc: String): Boolean {
    return openIssues.add(uniqueDesc)
}

fun getStatusLog(isAdded: Boolean): String {
    return if (isAdded) "잘 남겼습니다." else "중복 이슈입니다."
}

fun main() {
    val aNewIssue: String = "uniqueDescr4"
    val anIssueAlreadyIn: String = "uniqueDescr2"

    val aNewIssueStat = getStatusLog(addIssue(aNewIssue))
    val anIssueAlreadyInStat = getStatusLog(addIssue(anIssueAlreadyIn))
    println("이슈 $aNewIssue $aNewIssueStat")
    println("이슈 $anIssueAlreadyIn $anIssueAlreadyInStat")
}