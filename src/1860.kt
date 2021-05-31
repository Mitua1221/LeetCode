
/*
https://leetcode.com/problems/incremental-memory-leak/
 */

fun main() {

    println(memLeak(8, 11))

}

fun memLeak(memory1: Int, memory2: Int): IntArray {

    var one: Int = memory1
    var two: Int = memory2

    var i = 1

    while (true) {

        if (one >= two) {
            one -= i

            if (one < 0) {
                one += i
                break
            }

        } else {
            two -= i

            if (two < 0) {
                two += i
                break
            }

        }

        i++

    }

    println("$i, $one, $two")


    return intArrayOf(i, one, two)

}