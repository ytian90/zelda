package core.string;

/**
 * LC 415. Add Strings
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, p = num1.length() - 1, q = num2.length() - 1;
        while (p >= 0 || q >= 0) {
            int x = p >= 0 ? num1.charAt(p) - '0' : 0;
            int y = q >= 0 ? num2.charAt(q) - '0' : 0;
            int val = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            sb.append(val);
            p--;
            q--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    // T: O(max(N, M))
    // S: O(max(N, M))
}
