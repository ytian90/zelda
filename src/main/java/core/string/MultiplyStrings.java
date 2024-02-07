package core.string;

/**
 * LC 43. Multiply Strings
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] pos = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = multi + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (sb.isEmpty() && p == 0) {
                continue;
            }
            sb.append(p);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
    // T: O(N * M)
    // S: O(N + M)
}
