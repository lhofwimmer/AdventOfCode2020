package days

import Helpers

object Day3 : Day {
    private val lines = Helpers.getInput(3)

    override fun run() {

        val right1 = traverseSlope(1).toLong()
        val right3 = traverseSlope(3).toLong()
        val right5 = traverseSlope(5).toLong()
        val right7 = traverseSlope(7).toLong()
        val right1down2 = traverseSlope(1, true).toLong()

        val result: Long = (right1*right3*right5*right7*right1down2)
        println("$right1 * $right3 * $right5 * $right7 * $right1down2 = $result")
    }

    private fun traverseSlope(rightBy: Int, take2: Boolean = false) : Int {
        var currentPosition = 0
        var numTreesEncountered = 0

//        whack shit
//        for (i in 0..2 step 2)

        lines.forEachIndexed { i, line ->
            if((take2 && i % 2 == 0) || !take2) {
                val char = line[currentPosition]
                if(char == '#') numTreesEncountered++

                currentPosition += rightBy
                if(currentPosition >= line.length) currentPosition -= line.length
            }
        }

        return numTreesEncountered
    }
}