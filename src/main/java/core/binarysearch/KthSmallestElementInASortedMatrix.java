package core.binarysearch;

/**
 * LC 378. Kth Smallest Element in a Sorted Matrix
 */
public class KthSmallestElementInASortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[n - 1][m - 1];
        int res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (countLessOrEqual(matrix, mid) >= k) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }

    private static int countLessOrEqual(int[][] matrix, int target) {
        int res = 0, m = matrix[0].length, c = m - 1;
        for (int[] mat : matrix) {
            while (c >= 0 && mat[c] > target) {
                c--;
            }
            res += (c + 1);
        }
        return res;
    }
    // T: O((N + M) * logD), where N is row, M is col, D is maximum number in matrix.
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{1,2}, {1,3}}, 1));
        System.out.println(kthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8));
    }
}
