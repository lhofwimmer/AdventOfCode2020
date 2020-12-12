package days

object Day6 : Day {
    override fun run() {
        val lines = Helpers.getInputByGroups(6)

        part1(lines)
        part2(lines)
    }

    private fun part1(lines: List<String>) {
        println("Number of unique entries: " + lines.map { group ->
            getDistinctAnswers(group).size
        }.sum())
    }

    private fun part2(lines: List<String>) {
        println("Total number of intersects: " + lines.map { group ->
            val people = group.split("\r\n").map { it.toCharArray() }

            people.reduce { acc, e ->
                acc.intersect(e.toList()).toCharArray()
            }.size
        }.sum())
    }

    private fun getDistinctAnswers(group: String) : List<Char> {
        val answers = group.toCharArray().filter { it != '\r' && it != '\n' }
        return answers.distinct()
    }
}