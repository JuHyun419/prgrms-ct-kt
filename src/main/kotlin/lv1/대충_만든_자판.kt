package lv1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/160586?language=kotlin
 */
class 대충_만든_자판 {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val keyPressMap = createMinKeyPress(keymap)

        return calculateMinimalKeyPresses(targets, keyPressMap)
    }

    private fun createMinKeyPress(keymap: Array<String>): Map<Char, Int> {
        val map = mutableMapOf<Char, Int>()

        for (key in keymap) {
            key.forEachIndexed { index, ch ->
                val pressCount = index + 1
                map[ch] = minOf(map.getOrDefault(ch, 101), pressCount)
            }
        }

        return map
    }

    private fun calculateMinimalKeyPresses(targets: Array<String>, keyPressMap: Map<Char, Int>): IntArray {
        return targets.map { target -> calculateMinimalKeyPress(target, keyPressMap) }.toIntArray()
    }

    private fun calculateMinimalKeyPress(target: String, keyPressMap: Map<Char, Int>) =
        target.map { keyPressMap[it] ?: return -1 }.sum()
}
