

import java.util.function.BiFunction
import kotlin.collections.HashMap


fun main() {

     var obj = FindSumPairs(intArrayOf(1, 1, 2, 2, 2, 3), intArrayOf(1, 4, 5, 2, 5, 4))
     var param_2 = obj.count(7)
    obj.add(3,2)
    var param_3 = obj.count(8)
    var param_4 = obj.count(4)

}

//class FindSumPairs(nums1: IntArray, nums2: IntArray) {
//
//    var Nums1 = nums1.toMutableList()
//    var Nums2 = nums2.toMutableList()
//
////    val list = mutableMapOf<Int ,Int>()
////
////    var listToRecount = mutableListOf<Int>()
//
//    fun add(index: Int, i: Int) {
//
//        Nums2[index] = Nums2[index] + i
////
////        listToRecount.add(index)
//
//    }
//
//    fun count(tot: Int): Int {
//
//        println("$Nums1, $Nums2")
//
//        var s = 0
//
//        Nums1.forEach { its ->
//
//            Nums2.forEach {
//
//                if (its + it == tot) {
//                    s++
//                }
//
//            }
//
//        }
//
//        println(s)
//
//        return s
//
//    }
//
//}

class FindSumPairs(private val nums1: IntArray, private val nums2: IntArray) {

    private val map: MutableMap<Int, Int> = HashMap()

    fun add(index: Int, `val`: Int) {

        map.merge(
            nums2[index], -1
        ) { a, b -> Integer.sum(a, b) } //decrease index value count

        println(map)

        nums2[index] += `val` //update index value

        map.merge(
            nums2[index], 1
        ) { a, b -> Integer.sum(a, b) } //increase index value count

    }

    fun count(tot: Int): Int {

        var res = 0

        nums1.forEach {

            res += map.getOrDefault(tot - it, 0)

        }

        return res
    }

    init {

        nums2.forEach {

            map.merge(it, 1) {
                a, b -> Integer.sum(a, b)
            }

        }


    }
}

//fun count(tot: Int): Int {
//
//        println("$Nums1, $Nums2")
//
//        var s = 0
//
//        if (list.isNullOrEmpty()) {
//
//            Nums2.forEachIndexed { j, itOne ->
//
//                var v = 0
//
//                Nums1.forEachIndexed { i, it ->
//
//                    if (it + itOne == tot) {
//
//                        s++
//
//                        v++
//
//                    }
//
//                }
//
//                if (v != 0) {
//                    list[j] = v
//                }
//
//            }
//
//        } else {
//
//            var v = 0
//
//
//            println("Y" + list.toString())
//
//              listToRecount.forEach {
//
//                  Nums1.forEach { itOne ->
//
//                      if (Nums2[it] + itOne == tot) {
//
//                          v++
//
//                      }
//
//                  }
//
//                  list.replace(it, v)
//
//              }
//
//            println("Y" + list.toString())
//
//
//            list.forEach {
//
//                s += it.value
//
//            }
//
//            listToRecount = mutableListOf()
//
//        }
//
//        println(s)
//
//        return s
//
//    }