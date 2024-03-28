package core.string;

/**
 * LC 6. Zigzag Conversion
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int n = c.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while (i < n) {
            for (int j = 0; j < numRows && i < n; j++) {
                sb[j].append(c[i++]);
            }
            for (int j = numRows - 2; j >= 1 && i < n; j--) {
                sb[j].append(c[i++]);
            }
        }
        for (int j = 1; j < numRows; j++) {
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }
    // TS: O(N)
}
