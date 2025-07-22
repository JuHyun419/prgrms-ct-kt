package lv2

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */
class 귤_고르기 {
    fun solution(k: Int, tangerine: IntArray): Int {
        val sortedCounts = tangerine
            .groupBy { it }
            .values
            .map { it.size }
            .sortedDescending()

        var remaining = k
        var types = 0

        for (count in sortedCounts) {
            remaining -= count
            types++

            if (remaining <= 0) break
        }

        return types
    }
}
