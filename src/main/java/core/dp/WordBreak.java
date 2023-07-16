package core.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LC 139. Word Break
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        Set<String> dict = new HashSet<>(wordDict);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dict.contains(sub) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    // T: O(N ^ 3), 2 nested loop and substring method
    // S: O(N)

    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"))); // need 2 loops for this use case
    }
}
