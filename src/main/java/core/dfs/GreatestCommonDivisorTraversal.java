package core.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 2709. Greatest Common Divisor Traversal
 */
public class GreatestCommonDivisorTraversal {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(nums[i], nums[j]) > 1) {
                    list.add(new int[]{i, j});
                }
            }
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] e : list) {
            graph.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            graph.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int curr, boolean[] visited) {
        visited[curr] = true;
        for (int next : graph.getOrDefault(curr, new ArrayList<>())) {
            if (visited[next]) {
                continue;
            }
            dfs(graph, next, visited);
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    // T: O(N ^ 2)
    // S: O(N)

    // union find
    private int getf(int[] f, int x) {
        return f[x] == x ? x : (f[x] = getf(f, f[x]));
    }

    private void merge(int[] f, int[] num, int x, int y) {
        x = getf(f, x);
        y = getf(f, y);
        if (x == y) {
            return;
        }
        if (num[x] < num[y]) {
            int t = x;
            x = y;
            y = t;
        }
        f[y] = x;
        num[x] += num[y];
    }

    public boolean canTraverseAllPairs2(int[] nums) {
        final int n = nums.length;
        if (n == 1) {
            return true;
        }
        int[] f = new int[n], num = new int[n];
        for (int i = 0; i < n; ++i) {
            f[i] = i;
            num[i] = 1;
        }
        Map<Integer, Integer> have = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int x = nums[i];
            if (x == 1) {
                return false;
            }
            for (int d = 2; d * d <= x; ++d) {
                if (x % d == 0) {
                    if (have.containsKey(d)) {
                        merge(f, num, i, have.get(d));
                    } else {
                        have.put(d, i);
                    }
                    while (x % d == 0) {
                        x /= d;
                    }
                }
            }
            if (x > 1) {
                if (have.containsKey(x)) {
                    merge(f, num, i, have.get(x));
                } else {
                    have.put(x, i);
                }
            }
        }
        return num[getf(f, 0)] == n;
    }
}
