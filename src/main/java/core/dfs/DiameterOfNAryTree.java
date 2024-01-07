package core.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 1522. Diameter of N-Ary Tree
 */
public class DiameterOfNAryTree {
    private int diameter = 0;

    public int diameter(Node root) {
        dfs(root);
        return diameter;
    }

    private int dfs(Node node) {
        if (node == null || node.children.isEmpty()) {
            return 0;
        }
        int maxHeight1 = 0, maxHeight2 = 0;
        for (Node child : node.children) {
            int currHeight = 1 + dfs(child);
            if (currHeight > maxHeight1) {
                maxHeight2 = maxHeight1;
                maxHeight1 = currHeight;
            } else if (currHeight > maxHeight2) {
                maxHeight2 = currHeight;
            }
            diameter = Math.max(diameter, maxHeight1 + maxHeight2);
        }
        return maxHeight1;
    }
    // TS: O(N)

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        System.out.println((-1) % 7 + 1);
    }
}
