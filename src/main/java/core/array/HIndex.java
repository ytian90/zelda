package core.array;

import java.util.Arrays;

/**
 * LC 274. H-Index
 */
public class HIndex {
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int i = 0, n = citations.length;
        while (i < n && citations[n - 1 - i] > i) {
            i++;
        }
        return i;
    }
    // T: O(N * logN)
    // S: O(1)

    public static int hIndex2(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
    // T/S: O(N)

    public static void main(String[] args) {
        System.out.println(hIndex2(new int[]{3, 0, 6, 5, 1}));
    }

}
