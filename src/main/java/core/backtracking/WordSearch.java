package core.backtracking;

/**
 * LC 79. Word Search
 */
public class WordSearch {
    private static final int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, i, j, word, 1, new boolean[n][m])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, int pos, boolean[][] visited) {
        if (pos == word.length()) {
            return true;
        }
        visited[i][j] = true;
        boolean res = false;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(pos) || visited[x][y]) {
                continue;
            }
            res = res || helper(board, x, y, word, pos + 1, visited);
        }
        visited[i][j] = false;
        return res;
    }
    // T: O(N * 3 ^ M), where N is total number of cells in board, M is the length of word
    // S: O(N)

}
