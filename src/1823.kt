import kotlin.system.measureNanoTime

fun main() {
    val timeInNanos = measureNanoTime {
        println(findTheWinner(10, 9))
    }
    println("(The operation took $timeInNanos ns)")
}

fun findTheWinner(n: Int, k: Int): Int {

    val list = mutableListOf<Int>()

    for (i in 1..n) {
        list.add(i)
    }

    var index = list.indexOf(k)
    var last = 0

    while (true) {

        println(list)

        if (list.size > 1) {
            while (index > list.lastIndex) {
                index -= list.lastIndex + 1
            }
            last = list[index]
            list[index] = 0
        } else {
            last = list[0]
            list[0] = 0
        }

        if (index + k > list.lastIndex) {
            index = index + k - list.lastIndex - 1
            list.removeAll { it == 0 }
        } else {
            index += k
        }

        if (list.all { it == 0 }) break

    }

    return last

}