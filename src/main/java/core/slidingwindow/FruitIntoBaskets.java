package core.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LC 904. Fruit Into Baskets
 */
public class FruitIntoBaskets {
    // brutal force
    public static int totalFruit(int[] fruits) {
        int maxPick = 0, n = fruits.length;
        for (int left = 0; left < n; left++) {
            Set<Integer> basket = new HashSet<>();
            int right = left;
            while (right < n) {
                if (!basket.contains(fruits[right]) && basket.size() == 2) {
                    break;
                }
                basket.add(fruits[right]);
                right++;
            }
            maxPick = Math.max(maxPick, right - left);
        }
        return maxPick;
    }
    // T: O(N ^ 2)
    // S: O(N)

    public int totalFruit2(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, maxPick = 0, n = fruits.length;
        for (int right = 0; right < n; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxPick = Math.max(maxPick, right - left + 1);
        }
        return maxPick;
    }
    // T: O(N)
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1,2,1}));
    }
}
