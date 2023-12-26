package core.binarytree;

import java.util.*;

public class temp {
    Map<Character, Map<Character, Integer>> graph = new HashMap<>();
    Map<String, Integer> memo = new HashMap<>();

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        for (int i = 0; i < original.length; i++) {
            graph.putIfAbsent(original[i], new HashMap<>());
            graph.get(original[i]).put(changed[i], cost[i]);
        }

        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            char s = source.charAt(i), t = target.charAt(i);
            if (s != t) {
                if (!graph.containsKey(s)) {
                    return -1;
                }
                String key = s + "-" + t;
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



    class Pair{
        char dest;
        int val;
        Pair(char dest,int val){
            this.dest=dest;
            this.val=val;
        }
    }

    public long minimumCost2(String source, String target, char[] orignal, char[] changed, int[] cost) {
        int n=orignal.length;
        ArrayList<Pair>[] graph = new ArrayList[26];

        for(int i=0;i<26;i++) graph[i]=new ArrayList<>();

        for(int i=0;i<n;i++){
            graph[orignal[i]-'a'].add(new Pair(changed[i],cost[i]));
        }
        Map<String,Integer> map = new HashMap<>();

        long dist=0;
        for(int i=0;i<source.length();i++){
            char src=source.charAt(i);
            char dest=target.charAt(i);

            String str=src+""+dest;
            if(map.containsKey(str)) dist+=map.get(str);
            else{
                int d=shortestpath2(graph,src,dest);
                if(d==-1) return -1;
                map.put(str,d);
                dist+=d;
            }
        }
        return dist;

    }

    public int shortestpath2(ArrayList<Pair>[] graph, char src, char dest) {
        int[] distance = new int[26];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src - 'a'] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        pq.add(new Pair(src, 0));

        Set<Character> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            char node = curr.dest;
            int dista = curr.val;

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);

            for (Pair neighbor : graph[node - 'a']) {
                char nextNode = neighbor.dest;
                int weight = neighbor.val;

                if (distance[node - 'a'] + weight < distance[nextNode - 'a']) {
                    distance[nextNode - 'a'] = distance[node - 'a'] + weight;
                    pq.add(new Pair(nextNode, distance[nextNode - 'a']));
                }
            }
        }

        return (distance[dest - 'a'] == Integer.MAX_VALUE) ? -1 : distance[dest - 'a'];
    }



    public static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        if (m == n) {
            return (m - 1) * (m - 1);
        }
        int i = 0, j = 0, res = -1;
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        while (i < hFences.length && j < vFences.length) {
            int x = hFences[i];
            int y = vFences[j];
            if (x == y) {
                res = Math.max((x - 1) * (x - 1), res);
                i++;
                j++;
            } else if (x < y) {
                i++;
            } else {
                j++;
            }
        }
        while (i < hFences.length) {
            if (hFences[i] == n) {
                res = Math.max(res, (n - 1) * (n - 1));
            }
            i++;
        }
        while (j < vFences.length) {
            if (vFences[j] == m) {
                res = Math.max(res, (m - 1) * (m - 1));
            }
            j++;
        }
        return res;
    }

//    public static void main(String[] args) {
//        System.out.println(maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2})); // 4
//        System.out.println(maximizeSquareArea(6, 7, new int[]{2}, new int[]{4})); // -1
//        System.out.println(maximizeSquareArea(4, 4, new int[]{2}, new int[]{2,3})); // 9
//        System.out.println(maximizeSquareArea(8, 5, new int[]{5, 4}, new int[]{4})); // 16
//        System.out.println(maximizeSquareArea(3, 9, new int[]{2}, new int[]{8,6,5,4})); // -1
//        System.out.println(maximizeSquareArea(9, 3, new int[]{8,6,5,4}, new int[]{2})); // -1
//    }
}
