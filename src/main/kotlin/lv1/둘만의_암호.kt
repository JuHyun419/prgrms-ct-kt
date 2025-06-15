package lv1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/155652
 */
class 둘만의_암호 {
    fun solution(s: String, skip: String, index: Int): String {
        val alphabets = ('a'..'z').filterNot { skip.contains(it) }

        return s.map { ch ->
            val currentIndex = alphabets.indexOf(ch)
            val newIndex = (currentIndex + index) % alphabets.size

            alphabets[newIndex]
        }.joinToString("")
    }
}
