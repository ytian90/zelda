package core.math;

/**
 * LC 12. Integer to Roman
 */
public class IntegerToRoman {
    // Greedy
    public String intToRoman(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(romans[i]);
            }
            i++;
        }
        return sb.toString();
    }
    // Time and space: O(1)
}
