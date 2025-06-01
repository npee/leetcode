package io.npee.leetcode._03373_maximizethenumberoftargetnodesafterconnectingtreesii

/**
 * DFS
 */
fun maxTargetNodes1(edges1: Array<IntArray>, edges2: Array<IntArray>): IntArray {
    val n = edges1.size + 1
    val m = edges2.size + 1

    val color1 = IntArray(n)
    val color2 = IntArray(m)

    val result1 = build(edges1, color1)
    val result2 = build(edges2, color2)

    // val result = IntArray(n) { 0 }
    val result = IntArray(n)

    for (i in color1.indices) {
        result[i] = result1[color1[i]] + maxOf(result2[0], result2[1])
    }

    return result
}

fun build(edges: Array<IntArray>, color: IntArray): IntArray {
    val n = edges.size + 1
    // val children = List(n) { mutableListOf<Int>() }
    // val children = List(n) { _ -> mutableListOf<Int>() }

    val children = mutableListOf<MutableList<Int>>()
    for (i in 0 until n) {
        children.add(mutableListOf())
    }

    for (edge in edges) {
        children[edge[0]].add(edge[1])
        children[edge[1]].add(edge[0])
    }
    val res = dfs(0, -1, 0, children, color)
    return intArrayOf(res, n - res)
}

fun dfs(node: Int, parent: Int, depth: Int, children: List<List<Int>>, color: IntArray): Int {
    var res = 1 - (depth % 2)
    color[node] = depth % 2 // 노드의 색상 설정 (짝수: 0, 홀수: 1)
    for (child in children[node]) {
        if (child == parent) {
            continue
        }
        res += dfs(child, node, depth + 1, children, color)
    }
    return res
}