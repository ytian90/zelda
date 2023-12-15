package core.array.twopointers;

/**
 * LC 408. Valid Word Abbreviation
 */
public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            char c = abbr.charAt(j);
            if (Character.isDigit(c)) {
                if (c == '0') {
                    return false;
                }
                int start = j;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    j++;
                }
                int steps = Integer.parseInt(abbr.substring(start, j));
                i += steps;
            } else {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return i == word.length() && j == abbr.length();
    }
    // T: O(N + M)
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("internationalization", "i5a11o1"));
        System.out.println(validWordAbbreviation("a", "01"));
    }

}
