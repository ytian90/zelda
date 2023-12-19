package core.string;

/**
 * LC 791. Custom Sort String
 */
public class CustomSortString {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; i++) {
                sb.append(c);
            }
            count[c - 'a'] = 0;
        }
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < count[c - 'a']; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    // T: O(N + M), where N is the length of s, M is the length of order
    // S: O(N)
}
