//import kotlin.system.measureNanoTime
//
//fun main() {
//
//    var s = "[[7,1],[7,12],[7,5],[7,4],[7,2],[8,1],[8,2],[8,3],[8,4],[101,13]]"
//
//    var list = s.drop(2).dropLast(2).split("],[")
//    var array = mutableListOf<IntArray>()
//
//    list.forEach {
//        val arr = it.split(',')
//        val ret = intArrayOf(arr[0].toInt(), arr[1].toInt())
//        array.add(ret)
//    }
//
//    val timeInNanos = measureNanoTime {
//
//        println(getOrder(array.toTypedArray()))
//
//    }
//
//    println("(The operation took $timeInNanos ns)")
//
//
//}
//
//private fun getOrder(tasks: Array<IntArray>): IntArray {
//
//    val ret = mutableListOf<Int>()
//
//    val t = tasks.size
//
//    val map = mutableMapOf<Int, MutableList<Pair<Int, Int>>>() //index, int
//
//    tasks.forEach {
//        if (map[it[0]] == null) {
//            map[it[0]] = mutableListOf(Pair(tasks.indexOf(it), it[1]))
//        } else {
//            val list = map[it[0]]!!
//            list.add(Pair(tasks.indexOf(it), it[1]))
//            list.sortBy { it.second }
//            map[it[0]] = list
//        }
//    }
//
//    println(map)
//
//
//    doIt(map)
//
//
//    return intArrayOf()
//
//}
//
//
//private fun doIt(map: MutableMap<Int, MutableList<Pair<Int, Int>>>) {
//
//    var queue = mutableListOf<Pair<Int, Int>>() //index, int
//
//    var previous = 0
//
//    for (i in 0 until map.size) {
//
//        val s = map.keys.minOrNull()!!
//
//        if (queue.isNotEmpty()) {
//
////            println("//$queue")
//            val e = s - previous
//            while (e > ) {
//                val indexOfMin = queue.indexOf(queue.minByOrNull { it.second })
//
//                val valueOfMin = queue[indexOfMin].second
//
//                queue.removeAt(indexOfMin)
//            }
//
//            val indexOfMin = queue.indexOf(queue.minByOrNull { it.second })
//
//            val valueOfMin = queue[indexOfMin].second
//
//            queue.removeAt(indexOfMin)
//
//            previous = s + valueOfMin
//
//            println("/$queue")
//
//        }
//
//        queue.addAll(map[s] as MutableList)
//
////        queue.sortBy { it.second }
//
//        map.remove(s)
//
////        println(queue)
//
//    }
//
//
//
//}
