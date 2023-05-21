package core.array.matrix;

/**
 * LC 48. Rotate Image
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int top = 0, bottom = n - 1;
        while (top < bottom) {
            int[] t = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = t;
            top++;
            bottom--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
    // T: O(N * M)
    // S: O(M)
}
