fun main() {

    println(longestBeautifulSubstring("aeiou"))

}

fun longestBeautifulSubstring(word: String): Int {

    val array = word.toCharArray()
    var max = 0

    var map = mutableMapOf('a' to 0, 'e' to 0, 'i' to 0, 'o' to 0, 'u' to 0)

    var c = 0

    var ind = 0

    loop@ for (index in array.indices) {

        var s = 0

        if (index>=ind) {



//        println(++c)

        for (i in index until array.size) {

            if (i<array.size-1) {

                if (array[i].toInt() <= array[i+1].toInt()) {

                    s++

//                    println("${array[i]}, ${s}")

                    map.merge(array[i], 1) {
                            a, b -> Integer.sum(a, b)
                    }

                } else {
                    s++

                    map.merge(array[i], 1) {
                            a, b -> Integer.sum(a, b)
                    }

                    ind = i
                    println("Ind $ind")

                    break
                }
            } else {

                if (array.size > 1) {
                    if (array[i-1].toInt() <= array[i].toInt()) {

                        s++

                        map.merge(array[i], 1) {
                                a, b -> Integer.sum(a, b)
                        }


//                        break
                        if (s>max && map.all { it.value != 0 }) {
                            max = s
                        }

                        map = mutableMapOf('a' to 0, 'e' to 0, 'i' to 0, 'o' to 0, 'u' to 0)

                        break@loop

                    }
                }

            }

        }

        if (s>max && map.all { it.value != 0 }) {
            max = s
        }

        map = mutableMapOf('a' to 0, 'e' to 0, 'i' to 0, 'o' to 0, 'u' to 0)

    }}

    return max

}