open class Dog(
    val name: String,
    var age: Int,
    type: String,
) {

    var type: String = type
        protected set
}