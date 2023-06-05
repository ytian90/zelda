package core.string;

/**
 * LC 387. First Unique Character in a String
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] c = s.toCharArray();
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[c[i] - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counter[c[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
    // T: O(N)
    // S: O(1)
}
