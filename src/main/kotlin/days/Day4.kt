package days

import java.io.File

object Day4 : Day {
    override fun run() {
        val content = File("src/main/resources/Day4.txt").readText().split("\r\n\r\n")
        var validPassports = 0

        content.forEach { passport ->
            val required = mutableListOf("byr","iyr","eyr","hgt","hcl","ecl","pid")

            val tokens = passport.split(Regex("""\s+"""))

            tokens.forEach { token ->
                val (key, value) = token.split(":")
                if(validateKey(key, value)) required.remove(key)
            }

            if(required.isEmpty()) validPassports++
        }

        println("Number of valid passports: $validPassports")
    }

    private fun validateKey(key: String, value: String) : Boolean {
        return when(key) {
            "byr" -> {
                value.toInt() in 1920..2002
            }
            "iyr" -> {
                value.toInt() in 2010..2020
            }
            "eyr" -> {
                value.toInt() in 2020..2030
            }
            "hgt" -> {
                when {
                    value.endsWith("cm") -> {
                        value.removeSuffix("cm").toInt() in 150..193
                    }
                    value.endsWith("in") -> {
                        value.removeSuffix("in").toInt() in 59..76
                    }
                    else -> {
                        false
                    }
                }
            }
            "hcl" -> {
                """#[a-f0-9]{6}""".toRegex().matches(value)
            }
            "ecl" -> {
                listOf("amb","blu","brn","gry","grn","hzl","oth").contains(value)
            }
            "pid" -> {
                """[0-9]{9}""".toRegex().matches(value)
            }
            else -> false
        }
    }
}