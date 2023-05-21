package core.math;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 13. Roman to Integer
 */
public class RomanToInteger {
    // right to left
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1,
                'V', 5, 'X', 10,
                'L', 50, 'C', 100,
                'D', 500,  'M', 1000);

        int res = 0, prev = 0;
        for (char c : new StringBuilder(s).reverse().toString().toCharArray()) {
            int curr = map.get(c);
            res += curr < prev ? -curr : curr;
            prev = map.get(c);
        }
        return res;
    }
    // TS: O(1)

    // left to right
    public int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0, prev = 0;
        for (char c : s.toCharArray()) {
            int curr = map.get(c);
            res += (curr > prev) ? curr - 2 * prev : curr;
            prev = curr;
        }
        return res;
    }
    // TS: O(1)

}
