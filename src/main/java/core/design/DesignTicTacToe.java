package core.design;

/**
 * LC 348. Design Tic-Tac-Toe
 */
public class DesignTicTacToe {
    // base solution
    private int[][] board;
    private int n;

    public DesignTicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkRow(row, player) ||
                checkCol(col, player) ||
                row == col && checkDiagonal(player) ||
                row + col == n - 1 && checkAntiDiagonal(player)) {
            return player;
        }
        return 0;
    }

    private boolean checkRow(int row, int player) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][i] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][n - 1 - i] != player) {
                return false;
            }
        }
        return true;
    }
    // T: O(N)
    // S: O(N ^ 2)

}
