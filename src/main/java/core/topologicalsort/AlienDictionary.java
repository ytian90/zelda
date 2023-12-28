package core.topologicalsort;

import java.util.*;

/**
 * LC 269. Alien Dictionary
 */
public class AlienDictionary {
    // bfs + topological sort
    public static String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.put(c, new ArrayList<>());
                indegree.put(c, 0);
            }
        }
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char a = word1.charAt(j), b = word2.charAt(j);
                if (a != b) {
                    adj.get(a).add(b);
                    indegree.put(b, indegree.get(b) + 1);
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.add(c);
            }
        }
        while (!q.isEmpty()) {
            char curr = q.poll();
            sb.append(curr);
            for (Character next : adj.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    q.add(next);
                }
            }
        }
        return sb.length() < indegree.size() ? "" : sb.toString();
    }
    // T: O(M), where M is the total length of all the words in the input list
    // S: O(N)

    public static void main(String[] args) {
        System.out.println(alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
    }

}
