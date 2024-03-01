package core.string;

/**
 * LC 58. Length of Last Word
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n - 1;
        while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
            i--;
        }
        int res = 0;
        while (i >= 0 && !Character.isWhitespace(s.charAt(i))) {
            i--;
            res++;
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
