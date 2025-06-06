package io.npee.leetcode._03403_Findthelexicographicallylargeststringfromtheboxi

fun answerString(word: String, numFriends: Int): String {
    // x <= n - numFriends + 1
    // x <= n - i

    if (numFriends == 1) {
        return word
    }

    val n = word.length
    var result = ""

    for (i in 0 until n) {
        val substring = word.substring(i, minOf(i + n - numFriends + 1, n))
        if (result <= substring) {
            result = substring
        }
    }
    return result
}