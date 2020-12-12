import java.io.File

object Helpers {
    fun getInput(day: Int): List<String> {
        return File("src/main/resources/Day$day.txt").readLines()
    }

    fun getInputByGroups(day: Int): List<String> {
        return File("src/main/resources/Day$day.txt")
            .readText()
            .split("\r\n\r\n")
    }
}