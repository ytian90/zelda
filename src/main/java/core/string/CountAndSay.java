package core.string;

/**
 * LC 38. Count and Say
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = helper(s);
        }
        return s;
    }

    private String helper(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int count = 0;
            while (i < s.length() && c == s.charAt(i)) {
                i++;
                count++;
            }
            sb.append(count);
            sb.append(c);
        }
        return sb.toString();
    }
    // T: O(N)
    // S: O(1)
}
