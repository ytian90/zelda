package core.array.twopointers;

/**
 * LC 2109. Adding Spaces to a String
 */
public class AddingSpacesToAString {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, j = spaces.length - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
            if (j >= 0 && spaces[j] == i) {
                j--;
                sb.append(" ");
            }
        }
        return sb.reverse().toString();
    }
    // TS: O(N)

    // brutal force
    public String addSpaces2(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int n = spaces.length;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sb.append(s, 0, spaces[i]);
            } else {
                sb.append(s, spaces[i - 1], spaces[i]);
            }
            sb.append(" ");
        }
        sb.append(s.substring(spaces[n - 1]));
        return sb.toString();
    }
    // TS: O(N)

}
