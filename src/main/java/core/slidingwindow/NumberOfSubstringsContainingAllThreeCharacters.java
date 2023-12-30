package core.slidingwindow;

/**
 * LC 1358. Number of Substrings Containing All Three Characters
 */
public class NumberOfSubstringsContainingAllThreeCharacters {
    public static int numberOfSubstrings(String s) {
        int[] count = {0, 0, 0};
        int start = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(start) - 'a']--;
                start++;
            }
            res += start; // add substring count from 0 to start
        }
        return res;
    }
    // T: O(N)
    // S: O(1)

    public int numberOfSubstrings2(String s) {
        int[] last = {-1, -1, -1};
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
            res += 1 + Math.min(Math.min(last[0], last[1]), last[2]);
        }
        return res;
    }
    // T: O(N)
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }

}
