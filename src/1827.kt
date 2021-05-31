fun main() {
    println(minOperations(intArrayOf(8)))
}

fun minOperations(nums: IntArray): Int {

    val numbers = nums.toMutableList()

    var ret = 0

    numbers.forEachIndexed { index, it ->

        when (index) {
            0 -> {

            }
            in 1 until numbers.size -> {

                if (numbers[index-1] >= it) {
                    ret += (numbers[index - 1] - it) + 1
                    val s = it + (numbers[index-1] - it) + 1
                    numbers[index] = s

                }

            }

        }

    }

    return ret

}