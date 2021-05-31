import kotlin.system.measureNanoTime

fun main() {

    val timeInNanos = measureNanoTime {
        println(reinitializePermutation(10000000))
    }
    println("(The operation took $timeInNanos ns)")


}

fun reinitializePermutation(n: Int): Int {

    var list = mutableListOf<Int>()

    for (i in 0 until n) {
        list.add(i)
    }

    val beginList = mutableListOf<Int>()
    beginList.addAll(list)

var s = 0

    while (true) {

        val newList = mutableListOf<Int>()
        newList.addAll(list)

        newList.forEachIndexed { index, it ->

            if (index % 2 == 0) {
                newList[index] = list[index / 2]
            } else {
                newList[index] = list[n / 2 + (index - 1) / 2]
            }

        }

        if (newList == beginList) {
            s++
            break
        } else {
            s++
            list = newList
        }

    }

    return s
}