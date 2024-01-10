package core.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 246. Strobogrammatic Number
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            if (map.containsKey(c)) {
                sb.append(map.get(c));
            } else {
                return false;
            }
        }
        return sb.reverse().toString().equals(num);
    }
    // T: O(N)
    // S: O(1)
}
