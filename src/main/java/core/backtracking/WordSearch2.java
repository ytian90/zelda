package core.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  LC 212. Word Search II
 */
public class WordSearch2 {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    // Trie + Backtracking
    public List<String> findWords(char[][] board, String[] words) {
        buildTrie(words);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(board, i, j, root, res);
            }
        }
        return res;
    }

    private void helper(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.children[c - 'a'] == null) {
            return;
        }
        p = p.children[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null; // deduplicate
        }
        board[i][j] = '#';
        for (int[] d : DIRS) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                continue;
            }
            helper(board, x, y, p, res);
        }
        board[i][j] = c;
    }

    TrieNode root = new TrieNode();

    private void buildTrie(String[] words) {
        for (String word : words) {
            buildTrie(word);
        }
    }

    private void buildTrie(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.word = word;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    // T: O(N * 3 ^ L), where N is total number of cells in board, L is the maximum length of words
    // S: O(M), where M is the total number of letters in dict
}
