package core.graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * LC 1584. Min Cost to Connect All Points
 */
public class MinCostToConnectAllPoints {
    // Kruskal's algorithm: Union Find + PriorityQueue
    // TS: O(N ^ 2)
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, res = 0;
        // [distance, x, y]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.add(new int[]{calculateDistance(points, i, j), i, j});
            }
        }
        int connected = 0;
        UnionFind uf = new UnionFind(n);
        while (connected < n - 1) {
            int[] e = pq.poll();
            if (uf.find(e[1]) != uf.find(e[2])) {
                res += e[0];
                connected++;
                uf.union(e[1], e[2]);
            }
        }
        return res;
    }

    private int calculateDistance(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }


    class UnionFind {
        int[] root;

        public UnionFind(int n) {
            this.root = new int[n];
            for (int i = 0; i < n; i++) {
                this.root[i] = i;
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
            if (x != y) {
                return false;
            }
            root[x] = y;
            return true;
        }
    }

    // Prim's algorithm
    public int minCostConnectPoints2(int[][] points) {
        int n = points.length, res = 0;
        Set<Integer> mst = new HashSet<>();
        mst.add(0);
        int[] distance = new int[n];
        for (int i = 1; i < n; i++) {
            distance[i] = calculateDistance(points, 0, i);
        }
        while (mst.size() < n) {
            int next = -1;
            for (int i = 0; i < n; i++) {
                if (mst.contains(i)) {
                    continue;
                }
                if (next == -1 || distance[next] > distance[i]) {
                    next = i;
                }
            }
            mst.add(next);
            res += distance[next];
            for (int i = 0; i < n; i++) {
                if (!mst.contains(i)) {
                    distance[i] = Math.min(distance[i], calculateDistance(points, i, next));
                }
            }
        }
        return res;
    }
    // T: O(N ^ 2)
    // S: O(N)


}
