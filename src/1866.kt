import java.util.*

fun main() {

    println(rearrangeSticks(14, 2))

}

fun rearrangeSticks(n: Int, k: Int): Int {

    val s = mutableListOf<Int>()

    for (i in 1..n) {

        s.add(i)

    }

    val list = mutableListOf<MutableList<Int>>()

    val km = mutableListOf<Int>()
    km.addAll(s)
    val arr = km.toIntArray()
//    arr.addAll(s)
    var count = fuctorial(arr.size)
    val max = arr.size - 1
    var shift = max
    while (count > 0) {
        val t = arr[shift]
        arr[shift] = arr[shift - 1]
        arr[shift - 1] = t
        list.add(arr.toMutableList())
        count--
        if (shift < 2) {
            shift = max
        } else {
            shift--
        }
    }

    println(list)

    var ret = 0

//    list.forEach {
//
//        var previous = 0
//
//        var s = 0
//
//        it.forEachIndexed { index, i ->
//
//            if (i < previous) {
//                s++
//            }
//
//        }
//
//        if (k == s) {
//            ret++
//        }
//
//    }

    return 0

}

fun fuctorial(n: Int): Int {
    return if (n > 0) n * fuctorial(n - 1) else 1
}


//object SwapNeighbours {
//    @JvmStatic
//    fun main(args: Array<String>) {
//        val arr = intArrayOf(1, 2, 3)
//        var count = fuctorial(arr.size)
//        val max = arr.size - 1
////        println("Вариантов $count")
//        var shift = max
//        while (count > 0) {
//            val t = arr[shift]
//            arr[shift] = arr[shift - 1]
//            arr[shift - 1] = t
////            print(arr)
//            count--
//            if (shift < 2) {
//                shift = max
//            } else {
//                shift--
//            }
//        }
//    }
//
//    fun print(arr: IntArray?) {
//        println(Arrays.toString(arr))
//    }
//
//    fun fuctorial(n: Int): Int {
//        return if (n > 0) n * fuctorial(n - 1) else 1
//    }
//}