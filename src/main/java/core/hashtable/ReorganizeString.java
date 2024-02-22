package core.hashtable;

/**
 * LC 767. Reorganize String
 */
public class ReorganizeString {
    public static String reorganizeString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int maxCount = 0, maxPos = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxPos = i;
            }
        }
        int n = s.length();
        if (maxCount > (n + 1) / 2) {
            return "";
        }
        char[] res = new char[n];
        int index = 0;
        while (count[maxPos] != 0) {
            res[index] = (char) (maxPos + 'a');
            index += 2;
            count[maxPos]--;
        }
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (index >= n) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }
        return String.valueOf(res);
    }
    // TS: O(N)

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }
}
