package lv1

class 숫자_짝꿍 {

    fun solution(X: String, Y: String): String {
        val xCounts = countDigits(X)
        val duplicateNumbers = extractCommonDigits(xCounts, Y)

        return createMaxNumber(duplicateNumbers)
    }

    private fun countDigits(X: String): IntArray {
        return IntArray(10).apply {
            for (char in X) {
                val digit = char.digitToInt()
                this[digit]++
            }
        }
    }

    private fun extractCommonDigits(xCounts: IntArray, Y: String): MutableList<Char> {
        val duplicateDigits = mutableListOf<Char>()

        for (char in Y) {
            val digit = char.digitToInt()
            if (xCounts[digit] > 0) {
                duplicateDigits.add(char)
                xCounts[digit]--
            }
        }

        return duplicateDigits
    }

    private fun createMaxNumber(numbers: MutableList<Char>): String {
        if (numbers.isEmpty()) return "-1"

        val result = numbers.sortedDescending().joinToString("")
        return if (result.all { it == '0' }) "0" else result
    }
}

fun main() {
    val s = 숫자_짝꿍()

    println(s.solution("100", "123450"))
}
