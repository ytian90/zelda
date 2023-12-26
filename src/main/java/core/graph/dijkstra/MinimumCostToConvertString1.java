package core.graph.dijkstra;

import core.binarytree.temp;

import java.util.*;

/**
 * LC 2976. Minimum Cost to Convert String I
 */
public class MinimumCostToConvertString1 {
    Map<Character, Map<Character, Integer>> graph = new HashMap<>();
    Map<String, Integer> memo = new HashMap<>();

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        for (int i = 0; i < original.length; i++) {
            graph.putIfAbsent(original[i], new HashMap<>());
            graph.get(original[i]).put(changed[i], Math.min(cost[i], graph.get(original[i]).getOrDefault(changed[i], cost[i])));
        }

        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            char s = source.charAt(i), t = target.charAt(i);
            if (s != t) {
                if (!graph.containsKey(s)) {
                    return -1;
                }
                String key = s + "" + t;
                if (memo.containsKey(key)) {
                    res += memo.get(key);
                } else {
                    int curr = helper(s, t);
                    if (curr == -1) {
                        return -1;
                    }
                    memo.put(key, curr);
                    res += curr;
                }
            }
        }
        return res;
    }

    private int helper(char s, char t) {

        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.cost - b.cost);
        pq.add(new Node(s, 0));

        Set<Character> visited = new HashSet<>();
        visited.add(s);

        int[] distance = new int[26];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s - 'a'] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            char ch = curr.ch;
            if (graph.containsKey(ch)) {
                for (Map.Entry<Character, Integer> entry : graph.get(ch).entrySet()) {
                    if (visited.contains(entry.getKey()) && distance[ch - 'a'] + entry.getValue() >= distance[entry.getKey() - 'a']) {
                        continue;
                    }
                    visited.add(entry.getKey());
                    distance[entry.getKey() - 'a'] = distance[ch - 'a'] + entry.getValue();
                    pq.add(new Node(entry.getKey(), distance[entry.getKey() - 'a']));
                }
            }
        }
        return distance[t - 'a'] == Integer.MAX_VALUE ? -1 : distance[t - 'a'];
    }
    // T: O(N ^ 2)
    // S: O(N)

    class Node {
        char ch;
        int cost;

        public Node(char ch, int cost) {
            this.ch = ch;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        temp o = new temp();
        System.out.println(o.minimumCost("abcd", "acbe", new char[]{'a','b','c','c','e','d'}, new char[]{'b','c','b','e','b','e'}, new int[]{2,5,5,1,2,20}));
        System.out.println(o.minimumCost("aaaa", "bbbb", new char[]{'a','c'}, new char[]{'c','b'}, new int[]{1,2}));
        System.out.println(o.minimumCost("abcd", "abce", new char[]{'a'}, new char[]{'e'}, new int[]{10000}));
        System.out.println(o.minimumCost("aabbddccbc", "abbbaabaca", new char[]{'a','b','c','b','a','d'}, new char[]{'d','c','b','d','b','b'}, new int[]{3,8,7,6,7,10}));
    }

}
