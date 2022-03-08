package io.npee.leetcode._00797_allpathsfromsourcetotarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>(Arrays.asList(0));

        dfs(graph, 0, res, path);

        return res;
    }
    public void dfs(int[][] graph, int n, List<List<Integer>> res, List<Integer> path) {
        if (n == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int next : graph[n]) {
            path.add(next);
            dfs(graph, next, res, path);
            path.remove(path.size() - 1);
        }
    }
}
