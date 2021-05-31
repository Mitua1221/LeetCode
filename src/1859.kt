/*
https://leetcode.com/problems/sorting-the-sentence/
 */

fun main() {

    println(sortSentence("Myself2 Me1 I4 and3"))

}

fun sortSentence(s: String): String {
    val string = s

    var array = string.split(" ")

    array = array.filter { it.isNotBlank() }

    val secondArray = array.toMutableList()

    array.forEach { secondArray[it.last().toString().toInt() - 1] = it.dropLast(1)}

    return (secondArray.toString().filter { it != '[' && it != ']' && it != ','  })
}

