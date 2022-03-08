package io.npee.leetcode._00797_allpathsfromsourcetotarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsFromSourceToTarget {
    // 초기화 하면 안되고 현재 경로
    //Input
    //[[4,3,1],[3,2,4],[3],[4],[]]
    //Output
    //[[0,4],[0,3,4],[0,1,3,4],[0,2,3,4],[0,4]]
    //Expected
    //[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

    // 탐색 완료 시 path 원본을 추가하면 0만 있는 리스트가 추가됨. 사본을 추가해야 함
    //Input
    //[[1,2],[3],[3],[]]
    //Output
    //[[0],[0]]
    //Expected
    //[[0,1,3],[0,2,3]]
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // Input: 정점 n에서 출발하여 다른 정점에 도착하는 간선의 집합
        // 0부터 시작하여 n-1 까지 가는 모든 경로를 찾아야 한다.
        // 모든 경로를 조사하여 마지막 노드가 n-1인 경우의 경로를 리스트에 추가
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>(Arrays.asList(0));

        dfs(graph, 0, res, path);

        return res;
    }

    public static void dfs(int[][] graph, int n, List<List<Integer>> res, List<Integer> path) {
        // 마지막 정점에 도달하는 경우의 경로의 사본을 결과 리스트에 추가하고 이번 경로에 대한 탐색을 종료한다.
        if (n == graph.length - 1) {
            for (Integer integer : path) {
                System.out.print(integer + " ");
            }
            System.out.println();
            res.add(path);
            return;
        }
        // n-1 번째 정점에서 갈 수 있는 모든 경우를 순회한다.
        for (int next : graph[n]) {
            path.add(next);
            dfs(graph, next, res, path);
            // path = new ArrayList<>(Arrays.asList(0)); // 초기화 -> X
            path.remove(path.size() - 1); // 이번 정점 탐색 포기(끝에서 1개만 제거)
        }
    }

    public static void main(String[] args) {
        // int[][] graph = {{1,2},{3},{3},{}};
        // int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        int[][] graph = {{1,2},{3},{3},{}};
        List<List<Integer>> result = allPathsSourceTarget(graph);
        // Input: graph = [[1,2],[3],[3],[]]
        // Output: [[0,1,3],[0,2,3]]
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
