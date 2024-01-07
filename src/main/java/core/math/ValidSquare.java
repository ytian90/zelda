package core.math;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 593. Valid Square
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (samePoint(p1, p2) || samePoint(p1, p3) || samePoint(p1, p4) ||
                samePoint(p2, p3) || samePoint(p2, p4) || samePoint(p3, p4)) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(dist(p1, p2));
        set.add(dist(p1, p3));
        set.add(dist(p1, p4));
        set.add(dist(p2, p3));
        set.add(dist(p2, p4));
        set.add(dist(p3, p4));
        return set.size() == 2; // square line and diagonal line
    }

    private boolean samePoint(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    private int dist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }
    // TS: O(1)
}
