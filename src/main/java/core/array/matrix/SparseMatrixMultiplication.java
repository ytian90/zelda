package core.array.matrix;

/**
 * LC 311. Sparse Matrix Multiplication
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int x = mat1.length, y = mat1[0].length, z = mat2[0].length;
        int[][] res = new int[x][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (mat1[i][j] != 0) {
                    for (int k = 0; k < z; k++) {
                        if (mat2[j][k] != 0) {
                            res[i][k] += mat1[i][j] * mat2[j][k];
                        }
                    }
                }
            }
        }
        return res;
    }
    // T: O(X * Y * Z)
    // S: O(X * Z)
}
