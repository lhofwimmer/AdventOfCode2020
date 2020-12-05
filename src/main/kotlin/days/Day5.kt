package days

object Day5 : Day {
    override fun run() {
        val lines = Helpers.getInput(5)
        part1(lines)
        part2(lines)
    }

    private fun part2(lines: List<String>) {
        val allIds = getIds(lines)
        allIds.sorted().forEach { id ->
            if(!allIds.contains(id+1) && allIds.contains(id+2)) {
                println("Your seat is: ${id+1}")
            }
        }
    }

    private fun part1(lines: List<String>) {
        var largest = 0

        getIds(lines).forEach { seatId ->
            if (seatId > largest) largest = seatId
        }

        println("Largest id: $largest")
    }

    private fun getIds(lines: List<String>) : List<Int> {
        return lines.map { line ->
            val colBinary = line.take(7).replace("F", "0").replace("B", "1")
            val rowBinary = line.takeLast(3).replace("R", "1").replace("L", "0")

            val colDecimal = Integer.parseInt(colBinary, 2)
            val rowDecimal = Integer.parseInt(rowBinary, 2)
            colDecimal * 8 + rowDecimal
        }

    }
}