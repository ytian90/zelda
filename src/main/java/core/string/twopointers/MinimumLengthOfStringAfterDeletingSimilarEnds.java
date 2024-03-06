package core.string.twopointers;

/**
 * LC 1750. Minimum Length of String After Deleting Similar Ends
 */
public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    public int minimumLength(String s) {
        int lo = 0, hi = s.length() - 1;
        while (lo < hi && s.charAt(lo) == s.charAt(hi)) {
            char c = s.charAt(lo);
            while (lo <= hi && s.charAt(lo) == c) {
                lo++;
            }
            while (lo < hi && s.charAt(hi) == c) {
                hi--;
            }
        }
        return hi - lo + 1;
    }
    // T: O(N)
    // S: O(1)
}
