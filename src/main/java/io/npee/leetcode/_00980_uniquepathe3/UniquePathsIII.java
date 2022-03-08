package io.npee.leetcode._00980_uniquepathe3;

public class UniquePathsIII {
    static int available = 1, res = 0;
    public static int uniquePathsIII(int[][] grid) {
        // DFS 시작 값 세팅(출발 지점, 갈 수 있는 셀 개수)
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
        System.out.println("시작: (" + startX + ", " + startY + ")");
        dfs(grid, startX, startY);

        return res;
    }

    public static void dfs(int[][] grid, int x, int y) {
        // 1: start vertex
        // 2: end vertex
        // 0: available vertex
        // -1: unavailable vertex
        // input 그리드가 인접 행렬로 주어지므로 인접행렬을 이용하자.
        // 해석:
        // 시작 정점부터 도착 정점까지의 경로의 경우의 수를 구한다.
        // 조건 1. 유효한 정점을 모두 방문한다.
        // 조건 2. 간선을 한 번씩만 이용해야 한다.
        // 풀이:
        // 4-direction check
        // 방문한 곳은 별도로 체크
        // 도착 정점에 도달했으면서 0이 없을 때 까지 탐색
        // 문제 없이 도달한 경우 결과++, 그리드 초기화
        // 실패(최근 브랜치로 이동):
        // 벽을 만난 경우
        // 0이 남아있는데 갈 수 있는 방향이 없는 경우
        // 0이 남아있는데 도착지점에 도달한 경우

        // 벽이거나 이미 방문한 곳이면 return
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            System.out.println("해당 위치로는 갈 수 없다.. (" + x + ", "+ y +")");
            return;
        } else if (grid[x][y] == -1) {
            System.out.println("해당 위치에는 장애물이 있다.. (" + x + ", "+ y +")");
            return;
        } else if (grid[x][y] == -2) {
            System.out.println("지나온 곳이다.. (" + x + ", "+ y +")");
            return;
        }

        // 남은 셀이 0개이면서 도착 지점에 도달했으면 res 값 증가 후 return
        if (grid[x][y] == 2) {
            if (available == 0) {
                res++;
            }
            return;
        }

        // 좌표 찍으면서 빈 칸 줄이기
        grid[x][y] = -2;
        System.out.println("좌표 찍기 (" + x + ", "+ y +")");
        available--;

        // dfs in 4 directions
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        // 순회 끝나면 0으로 되돌리면서 빈 칸 늘리기
        grid[x][y] = 0;
        available++;

    }

    public static void main(String[] args) {
        // int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        int result = uniquePathsIII(grid);
        System.out.println("result = " + result);
    }
}
