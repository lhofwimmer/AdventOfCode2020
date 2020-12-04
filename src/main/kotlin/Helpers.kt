import java.io.File

object Helpers {
    fun getInput(day: Int): List<String> {
        return File("src/main/resources/Day$day.txt").readLines()
    }
}