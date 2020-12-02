package days

import java.io.File

object Day2 : Day {
    override fun run() {
        val regex = """(\d*)\s*-(\d*)\s*(.):\s(.*)""".toRegex()
        val lines = File("src/main/resources/Day2.txt").readLines()
        var numValidPasswords = 0

        lines.forEach { line ->
            val content = regex.matchEntire(line)!!
            val (first, second,letter,password) = content.destructured

//            part 1
//            val occurrences = password.count {
//                it == letter.first()
//            }

//            if (occurrences >= from.toInt() && occurrences <= to.toInt()) numValidPasswords++

            var isCorrect = false
            if(password[first.toInt()-1] == letter.first()) isCorrect = !isCorrect
            if(password[second.toInt()-1] == letter.first()) isCorrect = !isCorrect

            if(isCorrect) numValidPasswords++
        }

        println("number of correct passwords: $numValidPasswords")
    }
}