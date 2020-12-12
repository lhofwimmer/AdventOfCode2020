package days

object Day8 : Day {
    override fun run() {
        val lines = Helpers.getInput(8)
        val instructionSet = mutableListOf<Triple<Int, String, Int>>()

        lines.forEach { line ->
            instructionSet.add(Triple(0, line.split(" ")[0], line.split(" ")[1].toInt()))
        }

        var changeIterator = 0
        while(true) {
            val unCorrupted = instructionSet.toMutableList()
            val uncorruptedName = when(instructionSet[changeIterator].second) {
                "jmp" -> "nop"
                "nop" -> "jmp"
                else -> instructionSet[changeIterator].second
            }
            unCorrupted[changeIterator] = Triple(unCorrupted[changeIterator].first,uncorruptedName,unCorrupted[changeIterator].third)

            val result = runProgram(unCorrupted)
            if(result.first) {
                println("ACC sum when correct: ${result.second}")
                break
            }
            changeIterator++
        }
    }

    private fun runProgram(instructionSet: MutableList<Triple<Int,String,Int>>) : Pair<Boolean,Int> {
        var acc = 0
        var i = 0
        while(true) {
            if(i >= instructionSet.size) return Pair(true, acc)
            var (numVisits, instruction, value) = instructionSet[i]

            instructionSet[i] = instructionSet[i].copy(first = ++numVisits)
            if(numVisits > 1) return Pair(false, acc)
            when(instruction) {
                "acc" -> {
                    acc+=value
                    i++
                }
                "nop" -> {i++}
                "jmp" -> {i+=value}
            }
        }
    }
}