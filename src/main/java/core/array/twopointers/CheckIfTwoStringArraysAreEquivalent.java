package core.array.twopointers;

/**
 * LC 1662. Check If Two String Arrays are Equivalent
 */
public class CheckIfTwoStringArraysAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1 = 0, w2 = 0;
        int s1 = 0, s2 = 0;
        while (w1 < word1.length && w2 < word2.length) {
            if (word1[w1].charAt(s1) != word2[w2].charAt(s2)) {
                return false;
            }
            s1++;
            s2++;
            if (s1 == word1[w1].length()) {
                w1++;
                s1 = 0;
            }
            if (s2 == word2[w2].length()) {
                w2++;
                s2 = 0;
            }
        }
        return w1 == word1.length && w2 == word2.length;
    }
    // T: O(N + M)
    // S: O(1)

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for (String s : word1) {
            sb.append(s);
        }
        String s1 = sb.toString();
        sb = new StringBuilder();
        for (String s : word2) {
            sb.append(s);
        }
        return s1.equals(sb.toString());
    }
    // TS: O(N + M)
}
