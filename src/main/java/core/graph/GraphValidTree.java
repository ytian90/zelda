package core.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC 261. Graph Valid Tree
 */
public class GraphValidTree {
    // DFS
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        if (hasCycle(adj, 0, -1, visited)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> adj, int curr, int parent, boolean[] visited) {
        visited[curr] = true;
        for (int i : adj.get(curr)) {
            if (visited[i] && parent != i || !visited[i] && hasCycle(adj, i, curr, visited)) {
                return true;
            }
        }
        return false;
    }
    // TS: O(V+E)

    // BFS
    public boolean validTree2(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (visited[curr]) {
                return false;
            }
            visited[curr] = true;
            for (int i : adj.get(curr)) {
                if (!visited[i]) {
                    q.add(i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    // TS: O(V+E)

    // Union Find
    public boolean validTree3(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        UnionFind unionFind = new UnionFind(n);
        for (int[] e : edges) {
            if (!unionFind.union(e[0], e[1])) {
                return false;
            }
        }
        return true;
    }

    class UnionFind {
        private int[] root;

        public UnionFind(int n) {
            this.root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        public int find(int i) {
            while (i != root[i]) {
                i = root[i];
                root[i] = root[root[i]];
            }
            return i;
        }

        public boolean union(int i, int j) {
            int x = find(i);
            int y = find(j);
            if (x == y) {
                return false;
            }
            root[x] = y;
            return true;
        }
    }
    // T: O(V+E)
    // S: O(V)
}
