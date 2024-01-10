package core.string;

/**
 * LC 8. String to Integer (atoi)
 */
public class StringToIntegerATOI {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        int sign = 1;
        if (i < n && s.charAt(i) == '+') {
            i++;
        } else if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = 10 * num + digit;
            i++;
        }
        return sign * num;
    }
    // T: O(N)
    // S: O(1)
}
