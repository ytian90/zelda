package core.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 691. Stickers to Spell Word
 */
public class StickersToSpellWord {
    public int minStickers(String[] stickers, String target) {
        int[][] map = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            map[i] = build(stickers[i]);
        }
        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);
        return dfs(map, memo, target);
    }

    private int dfs(int[][] map, Map<String, Integer> memo, String target) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int min = Integer.MAX_VALUE;
        int[] targetMap = build(target);
        for (int[] m : map) {
            if (m[target.charAt(0) - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (targetMap[j] > 0) {
                    sb.append(String.valueOf((char) ('a' + j)).repeat(Math.max(0, targetMap[j] - m[j])));
                }
            }
            int curr = dfs(map, memo, sb.toString());
            if (curr != -1) {
                min = Math.min(curr, min);
            }
        }
        int res = (min == Integer.MAX_VALUE) ? -1 : 1 + min;
        memo.put(target, res);
        return res;
    }

    private int[] build(String word) {
        int[] res = new int[26];
        for (char c : word.toCharArray()) {
            res[c - 'a']++;
        }
        return res;
    }
    // T: O(2 ^ L * N), where L is length of target, N is number of words in sticker.
    // we need to calculate all possible subsets of the target in memo and O(N) to iterating all words in stickers
    // S: O(2 ^ L)

}
