/*

https://leetcode.com/problems/rotating-the-box/


 */

fun main() {

    val s = charArrayOf('*','*', '*','*', '#', '#', '.', '.', '*', '.', '.', '.', '#', '#', '*')

    rotateTheBox(arrayOf(s, s, s))
//    rotateTheBox(arrayOf(charArrayOf('#','#', '.', '.', '#'), charArrayOf('#','#', '.',  '.', '#')))

}


fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {

    val length = box[0].size - 1 //ширина - 1
    val wight = box.size - 1 //высота - 1

    println("$length, $wight")

    val array = mutableListOf(mutableListOf<Char>())


    for (i in 0..length) {

        if (i != 0) {
            array.add(mutableListOf<Char>())
        }

        for (j in wight downTo 0) {

            array[i].add(box[j][i])

        }

    }

    //sort

    for (i in 0..wight) {

        var loc: Int? = null

        for (j in length downTo 0) {

            if (loc == null) loc = j

            if (array[j][i] == '#' || array[j][i] == '*') {


                if (array[j][i] == '#') {
                    array[j][i] = '.'
                    array[loc][i] = '#'
                    loc = loc - 1
                } else {
                    loc = j - 1
                }


            }

        }

    }

    println(array)

    val retarr = mutableListOf(charArrayOf())

    array.forEach {
        val arr = it.toCharArray()
        retarr.add(arr)
    }

    println(retarr)



    return retarr.drop(1).toTypedArray()

}