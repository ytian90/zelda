package core.backtracking;

import java.util.*;

/**
 * LC 51. N-Queens
 */
public class NQueens {
    // same diag has same value of row - col
    // same anti-diag has same value of row + col
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] b : board) {
            Arrays.fill(b, '.');
        }
        List<List<String>> res = new ArrayList<>();
        helper(board, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), res);
        return res;
    }

    private void helper(char[][] board, int row, Set<Integer> cols, Set<Integer> diag, Set<Integer> antiDiag, List<List<String>> res) {
        int n = board.length;
        if (row == n) {
            res.add(buildBoard(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            int currDiag = row - col;
            int currAntiDiag = row + col;
            if (cols.contains(col) || diag.contains(currDiag) || antiDiag.contains(currAntiDiag)) {
                continue;
            }
            cols.add(col);
            diag.add(currDiag);
            antiDiag.add(currAntiDiag);
            board[row][col] = 'Q';
            helper(board, row + 1, cols, diag, antiDiag, res);
            cols.remove(col);
            diag.remove(currDiag);
            antiDiag.remove(currAntiDiag);
            board[row][col] = '.';
        }
    }

    private List<String> buildBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] b : board) {
            res.add(new String(b));
        }
        return res;
    }
    // T: O(N!)
    // S: O(N ^ 2)

}
