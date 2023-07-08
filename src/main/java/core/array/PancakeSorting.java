package core.array;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 969. Pancake Sorting
 */
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int val = arr.length; val > 0; val--) {
            int index = find(arr, val);
            if (index == val - 1) {
                continue;
            }
            if (index != 0) {
                res.add(index + 1);
                flip(arr, index + 1);
            }
            res.add(val);
            flip(arr, val);
        }
        return res;
    }

    private int find(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) {
                return i;
            }
        }
        return -1;
    }

    private void flip(int[] a, int k) {
        int i = 0, j = k - 1;
        while (i < j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }
    // T: O(N ^ 2)
    // S: O(N)
}
