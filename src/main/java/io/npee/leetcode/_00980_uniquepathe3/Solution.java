package io.npee.leetcode._00980_uniquepathe3;

class Solution {
    int available = 1, res = 0;
    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    available++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }
        dfs(grid, startX, startY);

        return res;
    }
    public void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) {
            return;
        }

        if (grid[x][y] == 2) {
            if (available == 0) {
                res++;
            }
            return;
        }

        grid[x][y] = -2;
        available--;

        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);

        grid[x][y] = 0;
        available++;
    }
}