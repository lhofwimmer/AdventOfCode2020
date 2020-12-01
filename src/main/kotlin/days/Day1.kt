package days

import java.io.File

object Day1 : Day {
    override fun run() {
        val numbers = File("src/main/resources/Day1.txt").readLines().map { it.toInt() }
        val correctSum = 2020

        numbers.forEach { num1 ->
            numbers.forEach { num2 ->
                numbers.forEach { num3 ->
                    if (num2 != num1 && num2 != num3 && (num1 + num2 + num3) == correctSum) {
                        println("Correct answer: $num1 * $num2 * $num3 = ${num1 * num2 * num3}")
                    }
                }
            }
        }
    }
}