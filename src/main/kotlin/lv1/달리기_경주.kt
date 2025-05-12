package lv1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871?language=kotlin
 */
class 달리기_경주 {

    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val nameToRank: MutableMap<String, Int> = mutableMapOf()
        val rankToName: MutableMap<Int, String> = mutableMapOf()

        players.forEachIndexed { index, player ->
            nameToRank[player] = index
            rankToName[index] = player
        }

        callings.forEach { calling ->
            val callingPlayerRank = nameToRank[calling]!!
            val frontPlayerRank = callingPlayerRank - 1
            val frontPlayer = rankToName[frontPlayerRank]!!

            // 해설진이 부른 선수(추월한 선수)와 추월당한 선수의 순위 변경
            nameToRank[calling] = frontPlayerRank
            nameToRank[frontPlayer] = callingPlayerRank

            rankToName[callingPlayerRank] = frontPlayer
            rankToName[frontPlayerRank] = calling
        }

        return (0 until players.size).map { rankToName[it]!! }.toTypedArray()
    }
}

fun main() {
    val s = 달리기_경주()
    val result = s.solution(
        players = arrayOf("mumu", "soe", "poe", "kai", "mine"),
        callings = arrayOf("kai", "kai", "mine", "mine")
    )

    // ["mumu", "kai", "mine", "soe", "poe"]
    println(result.toList())
}
