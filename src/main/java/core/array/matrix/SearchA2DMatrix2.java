package core.array.matrix;

/**
 * LC 240. Search A 2D Matrix 2
 */
public class SearchA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
    // T: O(N + M)
    // S: O(1)
}
