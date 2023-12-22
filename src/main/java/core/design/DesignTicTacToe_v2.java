package core.design;

public class DesignTicTacToe_v2 {
    int n;
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public DesignTicTacToe_v2(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currPlayer = (player == 1) ? 1 : -1;
        rows[row] += currPlayer;
        cols[col] += currPlayer;
        if (row == col) {
            diagonal += currPlayer;
        }
        if (row + col == n - 1) {
            antiDiagonal += currPlayer;
        }
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }
        return 0;
    }
    // T: O(1)
    // S: O(N)
}
