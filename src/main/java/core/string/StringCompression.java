package core.string;

/**
 * LC 443. String Compression
 */
public class StringCompression {
    public int compress(char[] chars) {
        int i = 0, res = 0;
        while (i < chars.length) {
            int len = 1;
            while (i + len < chars.length && chars[i] == chars[i + len]) {
                len++;
            }
            chars[res++] = chars[i];
            if (len > 1) {
                for (char c : Integer.toString(len).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += len;
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
