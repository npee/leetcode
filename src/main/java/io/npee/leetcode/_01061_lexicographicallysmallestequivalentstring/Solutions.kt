package io.npee.leetcode._01061_lexicographicallysmallestequivalentstring

var minChar = -1

fun dfs(src: Int, adjMatrix: Array<Array<Int?>>, visited: Array<Int?>, component: MutableList<Int>) {
    visited[src] = 1
    component.add(src)
    minChar = minOf(minChar, src)
    for (i in 0 until 26) {
        if (adjMatrix[src][i] != -1 && visited[i] == -1) {
            dfs(i, adjMatrix, visited, component)
        }
    }
}

fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
    val adjMatrix = Array(26) { Array<Int?>(26) { -1 } }
    for (i in s1.indices) {
        adjMatrix[s1[i] - 'a'][s2[i] - 'a'] = 1
        adjMatrix[s2[i] - 'a'][s1[i] - 'a'] = 1
    }

    val mappingChar = IntArray(26) { it }

    val visited = Array<Int?>(26) { -1 }
    for (c in 0 until 26) {
        if (visited[c] == -1) {
            val component = mutableListOf<Int>()
            minChar = 27
            dfs(c, adjMatrix, visited, component)
            for (vertex in component) {
                mappingChar[vertex] = minChar
            }
        }
    }

    val ans = StringBuilder()

    for (c in baseStr) {
        ans.append((mappingChar[c - 'a'] + 'a'.code).toChar())
    }
    return ans.toString()

}