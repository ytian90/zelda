package core.string.twopointers;

/**
 * LC 1768. Merge Strings Alternately
 */
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        if (i != word1.length()) {
            sb.append(word1.substring(i));
        }
        if (j != word2.length()) {
            sb.append(word2.substring(j));
        }
        return sb.toString();
    }
    // TS: O(N + M)
}
