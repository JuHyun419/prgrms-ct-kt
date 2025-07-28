package lv2

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
class 의상 {
    fun solution(clothes: Array<Array<String>>): Int {
        val clothesCount = mutableMapOf<String, Int>()

        for (cloth in clothes) {
            val type = cloth[1]
            clothesCount[type] = clothesCount.getOrDefault(type, 0) + 1
        }

        var answer = 1

        for (count in clothesCount.values) {
            answer *= (count + 1)
        }

        return answer - 1
    }

    fun solution2(clothes: Array<Array<String>>): Int =
        clothes
            .groupBy { it[1] }
            .values
            .fold(1) { acc, group -> acc * (group.size + 1) } - 1
}
