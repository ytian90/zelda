package core.bfs;

import java.util.*;

/**
 * LC 127. Word Ladder
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String s : wordList) {
            dict.add(s);
        }
        if (!dict.contains(endWord)) {
            return 0;
        }
        int len = beginWord.length(), level = 1;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                char[] c = s.toCharArray();
                for (int j = 0; j < len; j++) {
                    char originChar = c[j];
                    for (char a = 'a'; a <= 'z'; a++) {
                        c[j] = a;
                        String next = new String(c);
                        if (next.equals(endWord)) {
                            return 1 + level;
                        }
                        if (dict.contains(next)) {
                            dict.remove(next);
                            q.add(next);
                        }
                    }
                    c[j] = originChar;
                }
            }
            level++;
        }
        return 0;
    }
    // TS: O(M * N * M), where M is the length of each word, and N is the total number of words in input list
}
