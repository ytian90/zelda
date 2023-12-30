package core.stack;

/**
 * LC 1209. Remove All Adjacent Duplicates in String II
 */
public class RemoveAllAdjacentDuplicatesInString2 {
    public static String removeDuplicates(String s, int k) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; j++, i++) {
            res[i] = res[j];
            if (i - k + 1 >= 0 && sameChar(res, i - k + 1, i)) {
                i -= k;
            }
        }
        return new String(res, 0, i);
    }

    private static boolean sameChar(char[] s, int i, int j) {
        for (int k = i; k <= j; k++) {
            if (s[k] != s[i]) {
                return false;
            }
        }
        return true;
    }
    // TS: O(N)

    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }

}
