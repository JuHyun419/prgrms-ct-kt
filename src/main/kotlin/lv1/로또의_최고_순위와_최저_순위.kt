package lv1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/77484?language=kotlin
 */
class 로또의_최고_순위와_최저_순위 {

    private val rank = mapOf(
        6 to 1,
        5 to 2,
        4 to 3,
        3 to 4,
        2 to 5
    )

    fun solution(lottos: IntArray, winNums: IntArray): IntArray {
        val unknowns = lottos.count { it == 0 }
        val matched = lottos.count { it != 0 && winNums.contains(it) }

        val max = getRank(matched + unknowns)
        val min = getRank(matched)

        return intArrayOf(max, min)
    }

    private fun getRank(matchCount: Int) = rank.getOrDefault(matchCount, 6)
}
