package clazz

open class Shape(open val vertexCount: Int) {
    init {
        println("init Shape")
    }

    open fun draw() {
        println("draw Shape ${vertexCount}")
    }
}

class Rectangle(override val vertexCount: Int) : Shape(vertexCount) {
    init {
        println("init Rectangle")
    }

    override fun draw() {
        super.draw()
        println("draw Rectangle ${vertexCount}")
    }
}

fun main() {

    val shape = Rectangle(10)

    shape.draw()
}