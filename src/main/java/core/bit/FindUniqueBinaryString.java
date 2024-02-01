package core.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 1980. Find Unique Binary String
 */
public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            char c = nums[i].charAt(i);
            sb.append(c == '0' ? '1' : '0');
        }
        return sb.toString();
    }
    // T: O(N)
    // S: O(1)

    public String findDifferentBinaryString2(String[] nums) {
        Set<Integer> set = new HashSet<>();
        for (String s : nums) {
            set.add(Integer.parseInt(s, 2));
        }
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                StringBuilder res = new StringBuilder(Integer.toBinaryString(i));
                while (res.length() < n) {
                    res.insert(0, "0");
                }
                return res.toString();
            }
        }
        return "";
    }
    // T: O(N ^ 2)
    // S: O(N)
}
