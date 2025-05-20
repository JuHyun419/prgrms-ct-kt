package lv1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/388351
 */
class 유연근무제 {

    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer = 0

        for (i in schedules.indices) {
            val scheduleTime = schedules[i]
            val logs = timelogs[i]
            var currentDay = startday
            var pass = true

            for (log in logs) {
                val dayOfWeek = currentDay % 7

                if (isWeekend(dayOfWeek)) {
                    currentDay++
                    continue
                }

                if (isLate(scheduleTime, log)) {
                    pass = false
                    break
                }
                currentDay++
            }

            if (pass) answer++
        }

        return answer
    }

    private fun isWeekend(day: Int): Boolean = day == SATURDAY || day == SUNDAY

    private fun isLate(scheduleTime: Int, log: Int): Boolean {
        return convertToMinutes(log) > convertToMinutes(scheduleTime) + 10
    }

    private fun convertToMinutes(time: Int): Int {
        val hour = time / 100
        val minute = time % 100
        return hour * 60 + minute
    }

    companion object {
        private const val SATURDAY = 6
        private const val SUNDAY = 0
    }
}

fun main() {
    val s = 유연근무제()
    val schedules = intArrayOf(700, 800, 1100)
    val timelogs = arrayOf(
        intArrayOf(710, 2359, 1050, 700, 650, 631, 659),
        intArrayOf(800, 801, 805, 800, 759, 810, 809),
        intArrayOf(1105, 1001, 1002, 600, 1059, 1001, 1100)
    )

    val result = s.solution(schedules, timelogs, 5)

    println(result)
}
