package gradle.kotlin.latest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AppTest {
    @Test
    fun appHasAGreeting() {
        val classUnderTest = App(emptyMap())
        assertThat(classUnderTest.greeting).isNotNull
    }

    @Test
    fun `given a matrix when printing it then it should show died cells as dots and alives ones as asterisk` (){
        val matrix = mutableMapOf (
            0 to mutableMapOf(0 to false, 1 to false, 2 to false, 3 to false, 4 to false, 5 to false, 6 to false, 7 to false),
            1 to mutableMapOf(0 to false, 1 to false, 2 to false, 3 to true, 4 to true, 5 to false, 6 to false, 7 to false),
            2 to mutableMapOf(0 to false, 1 to false, 2 to false, 3 to true, 4 to true, 5 to false, 6 to false, 7 to false),
            3 to mutableMapOf(0 to false, 1 to false, 2 to false, 3 to false, 4 to false, 5 to false, 6 to false, 7 to false)
        )


        val classUnderTest = App(matrix)
        val actualMatrix = classUnderTest.renderGame()

        matrix.forEach { row, columnMap ->
            columnMap.forEach { column, value ->
                if (value) {
                    assertThat(actualMatrix[row]!![column]).isEqualTo("*")
                } else {
                    assertThat(actualMatrix[row]!![column]).isEqualTo(".")
                }
            }
        }

        classUnderTest.printGame()
    }
}
