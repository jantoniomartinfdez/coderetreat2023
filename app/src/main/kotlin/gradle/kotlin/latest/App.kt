package gradle.kotlin.latest

class App(val matrix: Map<Int, Map<Int, Boolean>>) {
    val greeting: String
        get() {
            return "Hello World!"
        }

    fun renderGame(): MutableMap<Int, MutableMap<Int, String>> {
        val renderedMatrix = mutableMapOf<Int, MutableMap<Int, String>>()

        matrix.forEach { row, columnMap ->
            renderedMatrix[row] = mutableMapOf()
            columnMap.forEach { column, value ->
                if (value) {
                    renderedMatrix[row]?.set(column, "*")
                } else {
                    renderedMatrix[row]?.set(column, ".")
                }
            }
        }

        return renderedMatrix
    }

    fun printGame()
    {
        renderGame().forEach { row, columnMap ->
            columnMap.forEach { column, value ->
                print(value)
            }
            println()
        }
    }
}

fun main() {
    println(App(emptyMap()).greeting)
}
