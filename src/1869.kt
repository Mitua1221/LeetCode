fun main() {

    println(checkZeroOnes("0"))

}

fun checkZeroOnes(s: String): Boolean {

    val a = s.toCharArray()

    var prev: Int? = null
    var zerolength = 0
    var topzeroes = 0
    var oneslength = 0
    var topones = 0

    a.forEach {

        if (it == '0') {

            if (prev == 1 || prev == null) {
                prev = 0
                zerolength = 0
            }

            zerolength += 1

            if (topzeroes < zerolength) {
                topzeroes = zerolength
            }

        } else {

            if (prev == 0 || prev == null) {
                prev = 1
                oneslength = 0
            }

            oneslength += 1

            if (topones < oneslength) {
                topones = oneslength
            }

        }

    }

    return topones > topzeroes

}