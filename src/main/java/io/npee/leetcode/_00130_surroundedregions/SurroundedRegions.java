package io.npee.leetcode._00130_surroundedregions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    public static void bfs(char[][] array, int row, int col) {
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};

        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(row, col)));
        // BFS
        while (!queue.isEmpty()) {
            ArrayList<Integer> point = queue.poll();
            int _row = (int)point.get(0);
            int _col = (int)point.get(1);

            // 현재 위치의 값을 임시 값으로 교체
            array[_row][_col] = 'V';

            for (int i = 0; i < 4; i++) {
                // BFS -> board 내부로 한정
                if (_row + dirX[i] < array.length && _row + dirX[i] >= 0 && _col + dirY[i] < array[0].length && _col + dirY[i] >= 0) {
                    // 현재 위치 기준에서 for 문의 상태에 따른 4방위 중 현 위치의 값이 O이면
                    if (array[_row + dirX[i]][_col + dirY[i]] == 'O') {
                        // 그 위치의 값을 마킹해두고
                        array[_row + dirX[i]][_col + dirY[i]] = 'V';
                        // 그 위치도 큐에 넣는다.
                        queue.add(new ArrayList<>(Arrays.asList(_row + dirX[i], _col + dirY[i])));
                    }
                }
            }
        }
    }

    public static void solve(char[][] board) {
        // 리턴값 없음. 인스턴스를 변경해야함
        // 테두리를 구성하는 O와 연결되지 않은 모든 O를 X로 변경하면 된다.
        // 1. 테두리의 모든 O를 순회한다.
        // 2. 발견된 O와 연결된 O를 체크하여 임시 값으로 변경한다.(변경 대상으로 인식하지 않기 위함)
        // 3. 임시 값이 아닌 모든 값을 X로 변경한다.
        // 4. 임시 값은 모두 O로 변경한다.
        // 시간 복잡도: O(2*N*M)
        // 공간 복잡도: O(N*M) BFS queue

        // n x m 행렬의 테두리만 탐색
        // 첫 행
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'O') {
                bfs(board, 0, col);
            }
        }
        // 마지막 행
        for (int col = 0; col < board[0].length; col++) {
            if (board[board.length - 1][col] == 'O') {
                bfs(board, board.length - 1, col);
            }
        }
        // 첫 열
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'O') {
                bfs(board, row, 0);
            }
        }
        // 마지막 열
        for (int row = 0; row < board.length; row++) {
            if (board[row][board[0].length - 1] == 'O') {
                bfs(board, row, board[0].length - 1);
            }
        }


        // O -> X, V -> O
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }

        // print
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        // char[][] board = {{'X','X','X'},{'X','O','O'},{'X','O','O'},{'X','O','X'}, {'X','O','X'}};
        // char[][] board = {{'O'}};
        char[][] board = {{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','O','O','O','O'},{'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},{'X','O','O','X','O','X','O','O','O','O','X','O','O','X','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','O'},{'O','X','X','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','O','O','X','X','O'},{'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},{'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},{'X','O','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','O','O','O','O','X','O','O','O','O','O','X'},{'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','X','O','X','O','O'},{'O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','X','O','O','O','X','O','O','X','O','O','X'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}};
        solve(board);
    }
}
