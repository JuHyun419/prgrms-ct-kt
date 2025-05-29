package lv1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 */
class 성격_유형_검사하기 {
    private val scores = mapOf(
        1 to 3,
        2 to 2,
        3 to 1,
        5 to 1,
        6 to 2,
        7 to 3
    )

    private val personalityScore = mutableMapOf<String, Int>()

    fun solution(survey: Array<String>, choices: IntArray): String {
        for (i in choices.indices) {
            if (choices[i] == 4) continue

            val personality = getPersonality(choices, i, survey)
            val score = scores[choices[i]] ?: 0
            personalityScore[personality] = personalityScore.getOrDefault(personality, 0) + score
        }

        return buildString {
            append(compare("R", "T", personalityScore))
            append(compare("C", "F", personalityScore))
            append(compare("J", "M", personalityScore))
            append(compare("A", "N", personalityScore))
        }
    }

    private fun getPersonality(choices: IntArray, index: Int, survey: Array<String>): String {
        return if (choices[index] < 4)
            survey[index].substring(0, 1)
        else
            survey[index].substring(1)
    }

    private fun compare(first: String, second: String, scores: Map<String, Int>): String {
        val firstScore = scores.getOrDefault(first, 0)
        val secondScore = scores.getOrDefault(second, 0)

        return if (firstScore >= secondScore) first else second
    }
}

fun main() {
    val survey = arrayOf("AN", "CF", "MJ", "RT", "NA")
    val choices = intArrayOf(5, 3, 4, 4, 5)
    val solution = 성격_유형_검사하기()
    println(solution.solution(survey, choices))
}

class Tester(
    val type: String,
    var score: Int,
) {

    fun addScore(score: Int) {
        this.score += score
    }
}
