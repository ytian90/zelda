package core.string;

/**
 * LC 266. Palindrome Permutation
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int singleCount = 0;
        for (int i : count) {
            if (i % 2 == 1) {
                singleCount++;
            }
        }
        return singleCount < 2;
    }
    // T: O(N)
    // S: O(1)
}
