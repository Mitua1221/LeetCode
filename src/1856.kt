/*
https://leetcode.com/problems/maximum-subarray-min-product/
 */


fun main() {

    println(maxSumMinProduct(intArrayOf(3,1,5,6,4,2)))
//2,147,483,647
}


fun maxSumMinProduct(nums: IntArray): Int {

    var sum: Long = 0

    for (index in nums.indices) {

        val list = mutableListOf<Int>()

        nums.forEach { list.add(it) }

        list.removeAt(index)

        val newSum: Long = list.fold(0) { total, next -> total + next }

        if (newSum > sum) sum = newSum

    }

    sum *= 2

    var ret: Int = 0

    if (sum > 2_147_483_647) {
        val ret = sum % 1_000_000_000
    } else {
        ret = sum.toInt()
    }

    return ret
}