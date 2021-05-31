fun main() {

    println(subsetXORSum(intArrayOf(5, 1, 6)))

}

fun subsetXORSum(nums: IntArray): Int {
    return helper(nums, 0, 0)
}

fun helper(nums: IntArray, ind: Int, xor: Int): Int {
    if (ind == nums.size) return xor
    var res = xor
    for (i in ind until nums.size) res += helper(nums, i + 1, xor xor nums[i])
    return res
}

