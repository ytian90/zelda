package core.array.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 1868. Product of Two Run-Length Encoded Arrays
 */
public class ProductOfTwoRunLengthEncodedArrays {
    public static List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();
        int p = 0, q = 0;
        int[] curr = new int[2];
        while (p < encoded1.length) {
            int len = Math.min(encoded1[p][1], encoded2[q][1]);
            int num = encoded1[p][0] * encoded2[q][0];
            if (curr[1] == 0) {
                curr = new int[]{num, len};
            } else if (curr[0] == num) {
                curr[1] += len;
            } else {
                res.add(Arrays.asList(curr[0], curr[1]));
                curr = new int[]{num, len};
            }
            encoded1[p][1] -= len;
            encoded2[q][1] -= len;
            if (encoded1[p][1] == 0) {
                p++;
            }
            if (encoded2[q][1] == 0) {
                q++;
            }
        }
        if (curr[1] != 0) {
            res.add(Arrays.asList(curr[0], curr[1]));
        }
        return res;
    }
    // TS: O(N + M)

    public static void main(String[] args) {
        System.out.println(findRLEArray(new int[][]{{1,3}, {2,3}}, new int[][]{{6,3}, {3,3}}));
        System.out.println(findRLEArray(new int[][]{{1,3}, {2,1}, {3,2}}, new int[][]{{2,3}, {3,3}}));
    }

}
