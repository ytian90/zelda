package core.trie;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.1point3acres.com/bbs/thread-1002379-1-1.html
 */
public class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean endOfWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.endOfWord = false;
        }
    }

    TrieNode root;
    String input;

    public Trie() {
        this.root = new TrieNode();
        this.input = new String();
    }

    public void add(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.endOfWord = true;
    }
    // TS: O(N), where N is the total number of letters

    public void insert(List<String> inputs) {
        for (String s : inputs) {
            add(s);
        }
    }

    public boolean find(String word) {
        input += word;
        TrieNode curr = root;
        for (char c : input.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        if (curr != null && curr.endOfWord) {
            input = "";
            return true;
        } else {
            return false;
        }
    }
    // T: O(K), where K is the total length of input

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert(Arrays.asList("leet", "code", "x"));
        System.out.println(trie.find("x"));
        System.out.println(trie.find("c"));
        System.out.println(trie.find("o"));
        System.out.println(trie.find("d"));
        System.out.println(trie.find("e"));
    }
}
