package core.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LC 825. Friends Of Appropriate Ages
 */
public class FriendsOfAppropriateAges {
    // hashmap
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : ages) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                if (request(a, b)) {
                    if (a == b) {
                        res += map.get(a) * (map.get(b) - 1);
                    } else {
                        res += map.get(a) * map.get(b);
                    }
                }
            }
        }
        return res;
    }

    private boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a);
    }
    // TS: O(N)

    // sorting + binary search
    public int numFriendRequests2(int[] ages) {
        int res = 0;
        Arrays.sort(ages);
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            int lower = findIndex(ages, age/2 + 7);
            int upper = findIndex(ages, age);
            res += Math.max(upper - lower - 1, 0); // -1 remove itself
        }
        return res;
    }

    private int findIndex(int[] a, int target) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
    // T: O(N * logN)
    // S: O(N)
}
