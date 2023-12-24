package core.hashmap;

import java.util.*;

/**
 * LC 133. Clone Graph
 */
public class CloneGraph {
    // map + dfs
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return helper(node, map);
    }

    private Node helper(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        for (Node next : node.neighbors) {
            copyNode.neighbors.add(helper(next, map));
        }
        return copyNode;
    }
    // TS: O(N)

    // map + bfs
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return node;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node next : curr.neighbors) {
                if (!map.containsKey(next)) {
                    map.put(next, new Node(next.val));
                    q.add(next);
                }
                map.get(curr).neighbors.add(map.get(next));
            }
        }
        return map.get(node);
    }
    // TS: O(N)

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
