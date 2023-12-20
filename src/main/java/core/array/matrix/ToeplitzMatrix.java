package core.array.matrix;

/**
 * LC 766. Toeplitz Matrix
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && j > 0 && matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    // T: O(N * M)
    // S: O(1)

    //
    /*
    Q1: What if the matrix is stored on disk, and the memory is limited such that
        you can only load at most one row of the matrix into the memory at once?
    A1: Assuming we are dealing with example 1:
    [[1,2,3,4],
    [5,1,2,3],
    [9,5,1,2]]
    We go top down:
    Step 1: load First row 1, 2, 3, 4
    Step 2: 4 is valid so move col 3 pointer forward since thats valid 1, 2 , 3, 3;
    Step 3: 3 & 3 are valid so move col 2 and col 3 : 1, 2, 2, 2;
    Step 4: 2 & 2 & 2 are valid so move col 1, 2, 3 : 1 , 1, 1, null; (drop col 3);
    Step 5: 1 & 1 & 1 are valid so move col 0, 1, 2: 5, 5, null, null (drop col 2);
    Step 6: 5 & 5 are valid so move col 0, 1: 9, null (drop col 1);
    Step 7: 9 is valid;

    return valid;
    At most we have one "row" in memory;
    If you notice a pattern here that when moving from r->l we incrementally compare values;

    Q2: What if the matrix is so large that you can only load up a partial row into the memory at once?
    A2:
    For the follow-up 2, we can only load a partial row at one time. We could split the whole
    matrix vertically into several sub-matrices, while each sub-matrix should have one column
    overlapped. We repeat the same method in follow-up 1 for each sub-matrix.
    [1 2 3 4 5 6 7 8 9 0]              [1 2 3 4]              [4 5 6 7]              [7 8 9 0]
    [0 1 2 3 4 5 6 7 8 9]              [0 1 2 3]              [3 4 5 6]              [6 7 8 9]
    [1 0 1 2 3 4 5 6 7 8]     -->      [1 0 1 2]       +      [2 3 4 5]       +      [5 6 7 8]
    [2 1 0 1 2 3 4 5 6 7]              [2 1 0 1]              [1 2 3 4]              [4 5 6 7]
    [3 2 1 0 1 2 3 4 5 6]              [3 2 1 0]              [0 1 2 3]              [3 4 5 6]

     */

}
