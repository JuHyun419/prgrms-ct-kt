package lv1

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370
 */
class 개인정보_수집_유효기간 {

    private val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")

    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val termsMap = toMap(terms)
        val todayDate = LocalDate.parse(today, formatter)

        return privacies.mapIndexedNotNull { index, privacy ->
            val (privacyDate, term) = privacy.split(" ")
            val expireMonths = termsMap[term] ?: return@mapIndexedNotNull null

            val collectedDate = LocalDate.parse(privacyDate, formatter)
            val expireDate = calculateExpireDate(collectedDate, expireMonths)

            if (isExpire(todayDate, expireDate)) index + 1 else null
        }.toIntArray()
    }

    private fun toMap(terms: Array<String>): Map<String, Int> {
        return terms.associate {
            val (type, period) = it.split(" ")
            type to period.toInt()
        }
    }

    private fun calculateExpireDate(startDate: LocalDate, monthsToAdd: Int): LocalDate {
        val rawExpire = startDate.plusMonths(monthsToAdd.toLong()).minusDays(1)

        return rawExpire.withDayOfMonth(minOf(rawExpire.dayOfMonth, 28))
    }

    private fun isExpire(today: LocalDate, expire: LocalDate): Boolean = today.isAfter(expire)
}

fun main() {
    val s = 개인정보_수집_유효기간()

    val result = s.solution(
        today = "2022.05.19",
        terms = arrayOf("A 6", "B 12", "C 3"),
        privacies = arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")
    )

    print(result.toString())
}
