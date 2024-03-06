package core.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 247. Strobogrammatic Number II
 */
public class StrobogrammaticNumber2 {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("0", "0");
        map.put("1", "1");
        map.put("8", "8");
        map.put("6", "9");
        map.put("9", "6");
        if (n % 2 == 0) {
            helper("", n, map, res);
        } else {
            helper("0", n, map, res);
            helper("1", n, map, res);
            helper("8", n, map, res);
        }
        return res;
    }

    private void helper(String s, int n, Map<String, String> map, List<String> res) {
        if (s.length() == n) {
            res.add(s);
            return;
        }
        for (String key : map.keySet()) {
            if ("0".equals(key) && s.length() + 2 >= n) {
                continue;
            }
            helper(key + s + map.get(key), n, map, res);
        }
    }
    // TS: O(N * 5 ^ N)

}
