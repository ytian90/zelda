package core.binarysearch;

/**
 * LC 1901. Find a Peak Element II
 */
public class FindAPeakElement2 {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int startCol = 0, endCol = m - 1;
        while (startCol <= endCol) {
            int maxRow = 0, midCol = startCol + (endCol - startCol) / 2;
            for (int row = 0; row < n; row++) {
                maxRow = mat[row][midCol] > mat[maxRow][midCol] ? row : maxRow;
            }
            boolean leftIsBig = startCol <= midCol - 1 && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
            boolean rightIsBig = midCol + 1 <= endCol && mat[maxRow][midCol + 1] > mat[maxRow][midCol];
            if (!leftIsBig && !rightIsBig) {
                return new int[]{maxRow, midCol};
            } else if (leftIsBig) {
                endCol = midCol - 1;
            } else {
                startCol = midCol + 1;
            }
        }
        return new int[]{};
    }
    // T: O(N * logM)
    // S: O(1)
}
