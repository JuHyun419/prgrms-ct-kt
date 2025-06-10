package lv1

class 햄버거_만들기 {
    fun solution(ingredient: IntArray): Int {
        val ingredients = mutableListOf<Int>()

        var answer: Int = 0

        for (i in ingredient) {
            ingredients.add(i)

            if (ingredients.isBurger()) {
                ingredients.removeBurger()
                answer++
            }
        }

        return answer
    }

    private fun List<Int>.isBurger(): Boolean {
        if (size < 4) return false

        val burgerIngredients = takeLast(4)
        return burgerIngredients == listOf(BREAD, VEGETABLE, MEAT, BREAD)
    }

    private fun MutableList<Int>.removeBurger() {
        repeat(4) { removeLast() }
    }

    companion object {
        private const val BREAD = 1
        private const val VEGETABLE = 2
        private const val MEAT = 3
    }
}
