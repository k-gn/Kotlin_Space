package collections

/*
   맵은 키-값 쌍으로 이뤄진 컬렉션입니다. 각 키는 고유해야 하고, 쌍으로 연결된 값을 가져올 때 사용합니다.
   맵을 만들려면 mapOf()나 mutableMapOf() 함수를 씁니다.
   중위함수 to를 쓰면 좀 더 간결하게 맵을 만들 수 있습니다.
   변경가능(mutable) 맵의 읽기전용 뷰를 얻으려면 Map으로 캐스팅하면 됩니다.
 */

const val POINTS_X_PASS: Int = 15 // const val -> static final (상수)
val EZPassAccounts: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)
val EZPassReport: Map<Int, Int> = EZPassAccounts

fun updatePointsCredit(accountId: Int) {
    if (EZPassAccounts.containsKey(accountId)) {
        println("업데이트 $accountId...")
        EZPassAccounts[accountId] = EZPassAccounts.getValue(accountId) + POINTS_X_PASS
    } else {
        println("에러: 계정이 없습니다 (id: $accountId)")
    }
}

fun accountsReport() {
    println("EZ-Pass 현황:")
    EZPassReport.forEach { (k, v) -> println("ID $k: 포인트 $v") }
}

fun main() {
    accountsReport()
    updatePointsCredit(1)
    updatePointsCredit(1)
    updatePointsCredit(5)
    accountsReport()
}
