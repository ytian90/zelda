package core.binarysearch;

/**
 * LC 1287. Element Appearing More Than 25% In Sorted Array
 */
public class ElementAppearingMoreThan25pInSortedArray {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length, t = n / 4;
        for (int i = 0; i < n - t; i++) {
            if (arr[i] == arr[i + t]) {
                return arr[i];
            }
        }
        return -1;
    }
    // T: O(N)
    // S: O(1)

    // binary search lower and upper bound
    public int findSpecialInteger2(int[] arr) {
        int n = arr.length;
        int[] candidates = {arr[n / 4], arr[n / 2], arr[3 * n / 4]};
        int t = n / 4;
        for (int c : candidates) {
            int lo = lower_bound(arr, c);
            int hi = upper_bound(arr, c) - 1;
            if (hi - lo + 1 > t) {
                return c;
            }
        }
        return -1;
    }

    private int lower_bound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int upper_bound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    // T: O(logN)
    // S: O(1)

}
