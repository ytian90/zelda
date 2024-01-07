package core.dfs;

/**
 * LC 529. Minesweeper
 */
public class Minesweeper {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0) {
            return board;
        }
        int i = click[0], j = click[1], n = board.length, m = board[0].length;
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
        } else {
            dfs(board, i, j, n, m);
        }
        return board;
    }

    private void dfs(char[][] board, int i, int j, int n, int m) {
        int mineCount = countMine(board, i, j, n, m);
        if (mineCount > 0) {
            board[i][j] = (char) (mineCount + '0');
        } else {
            board[i][j] = 'B';
            for (int[] d : dirs) {
                int x = i + d[0], y = j + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'E') {
                    continue;
                }
                dfs(board, x, y, n, m);
            }
        }
    }

    private int countMine(char[][] board, int x, int y, int n, int m) {
        int res = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'M') {
                    res++;
                }
            }
        }
        return res;
    }
    // TS: O(N * M)

}
