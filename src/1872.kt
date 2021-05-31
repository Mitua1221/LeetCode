import kotlin.math.abs

fun main() {

    val s = Solution().stoneGameOne(intArrayOf(-1,2,-3,4,-5))

    println(s)

//    println("RETURN = ${stoneGameOne(intArrayOf(7, -6, 5, 10, 5, -2, -6))}")

}

private class Solution {

    fun stoneGameOne(stones: IntArray): Int {
        var list = stones.toMutableList()

        var aliceScore = 0
        var bobScore = 0

        val pair = aliceTurn(aliceScore, bobScore, list)

        return pair.first - pair.second
    }

    private fun aliceTurn(aliceScore: Int, bobScore: Int, list: MutableList<Int>): Pair<Int, Int> {

        println("alice - $aliceScore, $bobScore, $list")

        var listMax = mutableListOf(0)

        list.forEach {

            listMax.add(listMax.last() + it)

        }
        listMax = listMax.drop(1) as MutableList

        var deltaRet = 0
        var indexRet = 0
        var aliceScorerRet = 0
        var bobScorerRet = 0

        listMax.forEachIndexed { index, it ->

            if (index > 0) {
                var newList = list.drop(index) as MutableList

                if (newList.size > 1) {
                    newList[0] = it
                } else {
                    newList = mutableListOf(it)
                }

                val pair = bobTurn(aliceScore + it, bobScore, newList)
                if (pair.first - pair.second > deltaRet) {
                    deltaRet = pair.first - pair.second
                    indexRet = index
                    aliceScorerRet = pair.first
                    bobScorerRet = pair.second
                }
            }

        }

        return Pair(aliceScorerRet, bobScorerRet)

    }

    private fun bobTurn(aliceScore: Int, bobScore: Int, list: MutableList<Int>): Pair<Int, Int> {

        println("bob - $aliceScore, $bobScore, $list")

        var listMax = mutableListOf(0)

        list.forEach {

            listMax.add(listMax.last() + it)

        }
        listMax = listMax.drop(1) as MutableList

        var deltaRet = 0
        var indexRet = 0
        var aliceScorerRet = 0
        var bobScorerRet = 0

        listMax.forEachIndexed { index, it ->

            if (index > 0) {

                var newList = list.drop(index) as MutableList

                if (newList.size > 1) {
                    newList[0] = it
                } else {
                    newList = mutableListOf(it)
                }

                val pair = aliceTurn(aliceScore, bobScore + it, newList)
                if (pair.first - pair.second < deltaRet) {
                    deltaRet = pair.first - pair.second
                    indexRet = index
                    aliceScorerRet = pair.first
                    bobScorerRet = pair.second
                }
            }

        }




    return Pair(0,0)

    //        var listInt = mutableListOf(0)
//
//        list.forEach {
//
//            listInt.add(listInt.last() + it)
//
//            aliceTurn(list)
//
//        }
//
//        listInt = listInt.drop(2) as MutableList
//
//        var delta = aliceScore - bobScore
//        var minimum = delta
//        var indexRet = 0
//
//        listInt.forEachIndexed { index, it ->
//            if (abs(delta - it) < minimum) {
//                minimum = abs(delta - it)
//                indexRet = index
//            }
//        }
//
//        bobScore += listInt[indexRet]
//
//        list = list.drop(indexRet + 1) as MutableList
//
//        if (list.size > 1) {
//            list[0] = listInt[indexRet]
//        } else {
//            list = mutableListOf(listInt[indexRet])
//        }

    }
}

private fun stoneGame(stones: IntArray): Int {

    var list = stones.toMutableList()

    var aliceScore = 0
    var bobScore = 0
    var aliceTurn = true

    while (true) {

        if (aliceTurn) {

            var listInt = mutableListOf(0)

            list.forEach {

                listInt.add(listInt.last() + it)

            }

            println(listInt)

            listInt = listInt.drop(2) as MutableList

            aliceScore += listInt.maxOrNull()!!

            list = list.drop(listInt.indexOf(listInt.maxOrNull()) + 1) as MutableList

            if (list.size > 1) {
                list[0] = listInt.maxOrNull()!!
            } else {
                list = mutableListOf(listInt.maxOrNull()!!)
            }

            aliceTurn = false
        } else {

            var listInt = mutableListOf(0)

            list.forEach {

                listInt.add(listInt.last() + it)

            }

            listInt = listInt.drop(2) as MutableList

            var delta = aliceScore - bobScore
            var minimum = delta
            var indexRet = 0

            listInt.forEachIndexed { index, it ->
                if (abs(delta - it) < minimum) {
                    minimum = abs(delta - it)
                    indexRet = index
                }
            }

            bobScore += listInt[indexRet]

            list = list.drop(indexRet + 1) as MutableList

            if (list.size > 1) {
                list[0] = listInt[indexRet]
            } else {
                list = mutableListOf(listInt[indexRet])
            }

            aliceTurn = true
        }

        if (list.size == 1) {
            break
        }

    }

    println("$list, $aliceScore, $bobScore,")

    return aliceScore - bobScore

}