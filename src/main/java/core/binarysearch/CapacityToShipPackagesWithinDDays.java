package core.binarysearch;

/**
 * LC 1011. Capacity To Ship Packages Within D Days
 */
public class CapacityToShipPackagesWithinDDays {
    // binary search + dfs
    public static int shipWithinDays(int[] weights, int days) {
        int totalWeight = 0;
        for (int i : weights) {
            totalWeight += i;
        }
        int lo = 1, hi = totalWeight;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, 0, days, 1, mid, 0)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static boolean canShip(int[] weights, int pos, int days, int currDay, int capacity, int currWeight) {
        if (currDay > days) {
            return false;
        }
        if (pos == weights.length) {
            return true;
        }
        boolean res = false;
        if (currWeight + weights[pos] <= capacity) {
            res = res || canShip(weights, pos + 1, days, currDay, capacity, currWeight + weights[pos]);
        } else {
            res = res || canShip(weights, pos, days, currDay + 1, capacity, 0);
        }
        return res;
    }
    // T: O(N + logN * 2 ^ N)
    // S: O(N)

    // binary search
    public int shipWithinDays2(int[] weights, int days) {
        int totalWeight = 0;
        int maxWeight = 0;
        for (int i : weights) {
            totalWeight += i;
            maxWeight = Math.max(maxWeight, i);
        }
        int lo = maxWeight, hi = totalWeight;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, days, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int currDays = 1, currWeight = 0;
        for (int i : weights) {
            currWeight += i;
            if (currWeight > capacity) {
                currDays++;
                currWeight = i;
            }
        }
        return currDays <= days;
    }
    // T: O(N + N * logN)
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }

}
