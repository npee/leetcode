package io.npee.leetcode._02942_findwordscontainingcharacter

fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
    return words.mapIndexedNotNull { index, word ->
        if (word.contains(x)) index else null
    }
}
