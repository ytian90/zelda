package core.greedy;

/**
 * LC 2864. Maximum Odd Binary Number
 */
public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        int zeroCount = 0, oneCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeroCount++;
            } else if (c == '1') {
                oneCount++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (oneCount > 1) {
            sb.append(1);
            oneCount--;
        }
        while (zeroCount > 0) {
            sb.append(0);
            zeroCount--;
        }
        sb.append(1);
        return sb.toString();
    }
    // TS: O(N)
}
