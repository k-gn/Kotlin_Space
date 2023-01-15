## 변수

> Kotlin

```kotlin
val message: String = "Hello!" // 변경 불가능한 변수 - val

val message = "Hello!" // type 생략 (추론)

var username = "gyunam" // 변경 가능한 변수 - var

var categories = arrayOf("c1", "c2", "c3")
```

---

## 타입

> Number (연산 가능한 타입들의 최상위 타입)

1. Byte
2. Short
3. Int
4. Long (L)

5. Float (6-7 Decimal digits / f)
6. Double (15-16 Decimal digits)

7. U[Type] (UByte, UInt ... / u) - 0 이상의 부호없는 숫자를 의미하는 타입 (음수값이 없기때문에 bit 계산 시 max 값이 더 크다.)

- 기본으로 추론되는 값인 Int

> Boolean (true, false)

```kotlin
val age = 11
age >= 13 && age < 20
age != 20
```

> Char (문자 하나)

```kotlin
val message: Char = 'K'
```
- 특수문자: \t, \n, \\, \$

> String

```kotlin
val name = "gyunam"
val message = "${name}님 안녕하세요~"
var description = """
  $message
  화이팅!!
""".trimIndent()

println(description)
```
> Array

- IntArray, ShortArray, FloatArray 등

```kotlin
val numbers = intArrayOf(2, 5, 6, 12)
val numbers = intArrayOf(3)
```

---

## Function

```kotlin

fun main() {
  // ...
}

fun main(args: Array<String) { // 실행 시 넘어오는 인자를 받는 main
  // ...
  funName(
    name = "name", // named argument 가능 (파라미터 순서를 안지켜도 된다.)
    price = 3000
  )
}

fun funName(
  name: String,
  price: Int, // trailing comma 입력 가능
) {
  // ...
}

fun funName(
  name: String,
  price: Int = 0, // 기본값 허용 
) {
  // ...
}

fun funName(
  name: String,
  price: Int,
): Unit { // : Unit - 반환하는 값이 없음을 나타냄 (생략가능)
  // ...
}

// 식으로 함수 선언
fun add(n1: Int, n2: Int): Int = n1 + n2
fun add(n1: Int, n2: Int) = n1 + n2

// 리턴 함수 선언
fun isEven(number: Int): Boolean {
  return number % 2 == 0
}

// 함수타입 선언 (변수로 받기)
val isEven: (Int) -> Boolean = {
  it % 2 == 0
} 

println(isEven(5))

// 표기 방식 (parameter) -> return type (파라미터명과 타입을 선언할 수 있고, 파라미터는 여러개가 될 수 있다)
// ex) (input: Int) -> Boolean / (Int, Int) -> Int

// 1분 실습
fun double(number: Int) = number * 2

val double: (number: Int) -> Int = {
  number * 2
}

```

## Null

```kotlin

var name: String? = null // ? - null 할당 허용 (nullable type)

```

---

- 코틀린에서 public 자바코드를 호출할 수 있다. 
- 자바에서 코틀린 코드를 호출할 수 있다 (public 명시 안해도됨, get 추가함수 제공)
- 서로 인스턴스 생성하는 문법이 다르다

```kotlin
val calendar = Calendar() // kotlin
Calendar calendar = new Calendar(); // java
```

---

- Getter / Setter
  - 코틀린 프로퍼티는 자동으로 지원한다.
  - getter, setter 모두 직접 구현할 수도 있다.
  - read-only 프로퍼티는 setter 정의 불가능

```kotlin
  var time: String
  
    get() {
      return field
    }

    // setter 정의 전 값이 초기화하거나 getter 가 있어야한다.
    set(value) {
      // ...
      field = value // field - Backing Fields
    }
  
  /*
    var <propertyName> [: <propertyType>]
      [<getter>]
      [<setter>]
  */
```


---

> Condition

```kotlin

val result = 5 > 3

// if 와 when 은 서로 대체할 수 있다.

if (result) {
    // ...
} else if(result) {
    // ...
} else {
    // ...
}

when {
    result -> {
        // ...
    }
    else -> {
        // ...
    }
}

/*
    프로그래밍에서 하나의 값을 반환 (값을 변수에 할당) 하는 것을 expression (식) 이라고 한다.
    발생 가능한 모든 경우에 초기화가 진행될 경우 변수에 선언에서 초기화하지 않아도 예외가 발생하지 않는다.
*/
fun getNum(first: Int, second: Int): Int {
  val num: Int = if(first > second) { // inline 도 가능
    first
  } else {
    second
  }
  return num
}

```

-- 여기서 부턴 자바

if else구문을 쓸 수 있는 모든 상황에 switch문을 쓸 수 있는 건 아니지만, 그와 반대로 모든 switch 구문은 if else문으로 대체될 수 있다.

switch 조건 허용값
- char, byte, short, int, Wrapper class, String enum

case 값은 switch 허용값과 타입이 동일해야한다.

if 보다 switch 가 조금 더 가독성이 좋다.
컴파일러가 최적화할때 switch가 더 유리하다. (특정 코드의 최적화를 위해선 if else문보다 switch구문을 쓰는게 더 적절하다.)
https://devmoony.tistory.com/121

자바14 부터 향상된 switch 문도 제공한다.
(case arrow, break 제거, yield로 반환값을 변수에 할당 가능, 변수에 값을 반환하는 식으로 사용 가능)


---
> Loop

```kotlin

val names: Array<String> = arrayOf("a", "b", "c")
for (name in names) {
    // ...
}

val nameSize = names.size
for (index in 0 until nameSize) { // <= index <
    // ...
}

for (index in 0 .. nameSize) { // <= index <=
  // ...
}

for (index in (nameSize - 1) downTo 0) { // >= index >=
  // ...
}

for (index in (nameSize - 1) downTo 0 step 2) { // +2 씩 띄어가기
  // ...
}

var count = 5

while (count > 0) {
    // ...
    count -= 1
}

do {
  // ...
  count -= 1
} while (count > 0)

for (name in names) { 
  // ...
  if (name == "a") { // == 가능!
      break // 가장 가까운 loop 종료
  }
}

val matrix = arrayOf(
  intArrayOf(1, 2, 3),
  intArrayOf(4, 5, 6)
)

loop@ for (row in matrix) {
  for (column in row) {
    if (column == 2) break@loop // label 가능
  }
}

```

-- 여기서 부턴 자바

label 을 사용해 안쪽 반복문에서 바깥 반복문을 break or continue 할 수 있다.
단, 바깥 반복문과 연결될 정도의 Loop 라면 코드 자체를 수정하는 것도 방법이다.

return 를 함수에서 사용 시 바로 함수를 빠져나간다.
(반복문에서 사용해도 그냥 바로 나간다)

---

> Class

```kotlin

class Weather( // 클래스명과 생성자를 동시에 선언 가능
  val temperature: Int,
  val location: String
)

class Weather constructor( // 클래스명과 생성자를 동시에 선언 가능
  val temperature: Int,
  val location: String
)

class Weather constructor( // 주 생성자
  val temperature: Int,
  val location: String
) {
  // 부 생성자
  constructor(temperature: Int, location: String) : this( // this : 주 생성자로 전달
    temperature,
    location
  ) 
}

class Weather constructor( // 기본값 설정 가능 (생성자를 두개 만든 것과 동일한 효과를 낼 수 있다.)
  val temperature: Int = 0,
  val location: String,
)

class WeatherInfo constructor( 
  val temperature: Int,
  val location: String = "",
)

// 클래스 이름은 대문자 시작, 명사, 카멜케이스

// 초기화와 getter 의 차이 - 사실상 거의 동일하지만, getter 는 함수라서 연산을 수행함 -> 값이 연산에 따라 달라진다. / 초기화는 값이 변할일이 없다.
open class WeatherInfo constructor(
  open val temperature: Int,
  val location: String = "",
) {
    val display = "$temperature - $location"

    // custumGetter
    val displayGetter: String
        get() = "$temperature - $location"
        set(value) {
          if (value == "test value")
            field = value
        }
}

fun main() {
    val weather = Weather(20, "강남구 대치동") // new 없이 생성
}

// 상속
// 코틀린의 최상위 클래스 : Any (open 키워드가 추가되어 있다)
// open : 상속을 허용한다는 의미
class TemperatureInfo(
  override val temperature: Int, // 재정의
) : WeatherInfo(temp, "") { // 부모에게 기본값을 계속 전달해야 할 경우 구조를 변경해야할 필요가 있다.
}


open class Shape(vertexCount: Int) {
  init { // 클래스 생성 시 실행되는 블럭
      // ...
  }
  
  open fun draw() {
      // ..
  }
}

class Rectangle(vertexCount: Int) : Shape(vertexCount) {
  init { // 클래스 생성 시 실행되는 블럭
    // ...
  }

  override fun draw() {
    // ..
    super.draw()
  }
}

```

Obejct : 모든 클래스의 상위클래스 / 기본생성자를 갖고 있다.

코틀린 멀티플랫폼으로 공통적인 코드들을 모듈로 관리할 수 있다.

---

- 생성 시 필요하면 생성자에, 아니면 setter
- 인터페이스는 상태저장 불가능
  - 상태를 저장할 필요가 있다면 클래스 사용


---
### 중요!
1. 코드 리뷰 (개선)은 중요한 개념이다.
2. 함수의 분리를 중요하게 여기자.
3. 함수의 재사용성을 높이자.