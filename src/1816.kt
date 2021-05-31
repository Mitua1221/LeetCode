fun main() {

    println(truncateSentence("chopper is not a tanuki", 5))

}

fun truncateSentence(s: String, k: Int): String {

    return s.split(" ").dropLast(s.split(" ").size - k).toString().filterNot { it == '[' || it == ']' || it == ',' }

}