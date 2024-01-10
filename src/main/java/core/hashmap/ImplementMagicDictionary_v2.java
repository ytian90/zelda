package core.hashmap;

/**
 * LC 676. Implement Magic Dictionary
 */
public class ImplementMagicDictionary_v2 {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;

    public ImplementMagicDictionary_v2() {
        this.root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            TrieNode node = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        TrieNode node = root;
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            for (int j = 0; j < 26; j++) {
                if ((char) (j + 'a') == c || node.children[j] == null) {
                    continue;
                }
                if (canFind(searchWord, node.children[j], i + 1)) {
                    return true;
                }
            }
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return false;
    }

    private boolean canFind(String s, TrieNode node, int start) {
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }
    // TS: O(N), where N is the total number of letters in dictionary

}
