package core.bfs;

import java.util.*;

/**
 * LC 1424. Diagonal Traverse II
 */
public class DiagonalTraverse2 {
    // bfs
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            res.add(nums.get(curr.row).get(curr.col));
            if (curr.col == 0 && curr.row + 1 < nums.size()) {
                q.add(new Node(curr.row + 1, 0));
            }
            if (curr.col + 1 < nums.get(curr.row).size()) {
                q.add(new Node(curr.row, curr.col + 1));
            }
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = res.get(i);
        }
        return r;
    }
    // T: O(N)
    // S: O(sqrt(N)), largest anti-diagonal line

    class Node{
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int[] findDiagonalOrder2(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = 0;
        for (int row = nums.size() - 1; row >= 0; row--) {
            for (int col = 0; col < nums.get(row).size(); col++) {
                int diagonal = row + col;
                if (!map.containsKey(diagonal)) {
                    map.put(diagonal, new ArrayList<>());
                }
                map.get(diagonal).add(nums.get(row).get(col));
                n++;
            }
        }
        int[] res = new int[n];
        int i = 0;
        int curr = 0;
        while (map.containsKey(curr)) {
            for (int num : map.get(curr)) {
                res[i++] = num;
            }
            curr++;
        }
        return res;
    }
    // TS: O(N)

}
