# 130. Surrounded Regions
## Code
```java
public class Solution {
    public void bfs(char[][] array, int row, int col) {
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};

        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(row, col)));

        while (!queue.isEmpty()) {
            ArrayList<Integer> point = queue.poll();
            int _row = point.get(0);
            int _col = point.get(1);

            array[_row][_col] = 'V';

            for (int i = 0; i < 4; i++) {
                if (_row + dirX[i] < array.length && _row + dirX[i] >= 0 && _col + dirY[i] < array[0].length && _col + dirY[i] >= 0) {
                    if (array[_row + dirX[i]][_col + dirY[i]] == 'O') {
                        array[_row + dirX[i]][_col + dirY[i]] = 'V';
                        queue.add(new ArrayList<>(Arrays.asList(_row + dirX[i], _col + dirY[i])));
                    }
                }
            }
        }
    }

    public void solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'O') {
                bfs(board, row, 0);
            }
        }

        for (int row = 0; row < board.length; row++) {
            if (board[row][board[0].length - 1] == 'O') {
                bfs(board, row, board[0].length - 1);
            }
        }

        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'O') {
                bfs(board, 0, col);
            }
        }

        for (int col = 0; col < board[0].length; col++) {
            if (board[board.length - 1][col] == 'O') {
                bfs(board, board.length - 1, col);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
```
## Result
![img.png](img.png)

## Complexity
### Time complexity
O(2 * N * M)
### Space complexity
O(N * M) BFS queue