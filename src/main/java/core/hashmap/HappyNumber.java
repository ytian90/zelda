package core.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 202. Happy Number
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        int curr = n;
        while (!visited.contains(curr)) {
            visited.add(curr);
            int next = 0;
            while (curr > 0) {
                int digit = curr % 10;
                next += digit * digit;
                curr /= 10;
            }
            if (next == 1) {
                return true;
            }
            curr = next;
        }
        return false;
    }
    // TS: O(logN)
}
