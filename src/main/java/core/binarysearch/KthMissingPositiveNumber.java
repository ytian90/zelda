package core.binarysearch;

/**
 * LC 1539. Kth Missing Positive Number
 * similar to LC 1060. Missing Element in Sorted Array
 */
public class KthMissingPositiveNumber {
    public static int findKthPositive(int[] arr, int k) {
        if (k <= arr[0] - 1) {
            return k;
        }
        k -= arr[0] - 1;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int currMiss = arr[i] - arr[i - 1] - 1;
            if (k <= currMiss) {
                return arr[i - 1] + k;
            }
            k -= currMiss;
        }
        return arr[n - 1] + k;
    }
    // T: O(N)
    // S: O(1)

    public int findKthPositive2(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // If number of positive integers
            // which are missing before arr[pivot]
            // is less than k -->
            // continue to search on the right.
            if (arr[mid] - mid - 1 < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        // At the end of the loop, left = right + 1,
        // and the kth missing is in-between arr[right] and arr[left].
        // The number of integers missing before arr[right] is
        // arr[right] - right - 1 -->
        // the number to return is
        // arr[right] + k - (arr[right] - right - 1) = k + left
        return lo + k;
    }
    // T: O(logN)
    // S: O(1)

    public int findKthPositive3(int[] arr, int k) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] - mid - 1 < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        // when exit the while loop, lo == hi, which equals to the number of missing number used, so Kth positive will be lo + k
        return lo + k;
    }
    // T: O(logN)
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,7,11}, 5));
        System.out.println(findKthPositive(new int[]{5,6,7,8,9}, 9));
    }

}
