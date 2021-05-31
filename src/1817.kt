fun main() {

    println(findingUsersActiveMinutes(
        logs = arrayOf(intArrayOf(1,1),intArrayOf(2,2),intArrayOf(2,3)),
        k = 4
    ).toMutableList())

}

fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {

    val list = mutableMapOf<Int,MutableList<Int>>()

    logs.forEach {

        if (list[it[0]] == null) {
            list[it[0]] = mutableListOf(it[1])
        } else {
            list[it[0]]?.add(it[1])
        }

    }

    val ret = MutableList(5) { _ -> 0 }

    list.forEach {
        val s = it.value.distinct().size
        ret[s-1]++
    }

    return ret.toIntArray()

}