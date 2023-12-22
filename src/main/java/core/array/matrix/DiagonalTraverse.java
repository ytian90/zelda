package core.array.matrix;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * LC 498. Diagonal Traverse
 */
public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[]{};
        }
        int n = mat.length, m = mat[0].length;
        int r = 0, c = 0;
        int[] res = new int[n * m];
        for (int i = 0; i < res.length; i++) {
            res[i] = mat[r][c];
            if ((r + c) % 2 == 0) { // up
                if (c == m - 1) r++;
                else if (r == 0) c++;
                else {r--; c++;}
            } else { // down
                if (r == n - 1) c++;
                else if (c == 0) r++;
                else {r++; c--;}
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}})));
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2}, {3,4}})));
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1}})));
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{2,3}})));
    }

}
