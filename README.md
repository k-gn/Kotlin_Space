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

```
val calendar = Calendar() // kotlin
Calendar calendar = new Calendar(); // java
```

---

- Getter / Setter
  - 코틀린 프로퍼티는 자동으로 지원한다.
  - getter, setter 모두 직접 구현할 수도 있다.
  - read-only 프로퍼티는 setter 정의 불가능

```
  var time: String
  
  get() {
    return time
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


