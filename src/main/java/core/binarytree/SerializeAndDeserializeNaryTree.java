package core.binarytree;

import java.sql.Array;
import java.util.*;

/**
 * LC 428. Serialize and Deserialize N-ary Tree
 */
public class SerializeAndDeserializeNaryTree {
    private static final String SPLITTER = "/";
    private static final String NN = "N";

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.deleteCharAt(0).toString();
    }

    private void build(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append(SPLITTER).append(NN);
            return;
        }
        sb.append(SPLITTER).append(node.val);
        int size = node.children == null || node.children.isEmpty() ? 0 : node.children.size();
        sb.append(SPLITTER).append(size);
        if (size > 0) {
            for (Node child : node.children) {
                build(child, sb);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split("/")));
        return build(q);
    }

    private Node build(Queue<String> q) {
        String s = q.poll();
        if (NN.equals(s)) {
            return null;
        }
        Node root = new Node(Integer.parseInt(s));
        int size = Integer.parseInt(q.poll());
        root.children = new ArrayList<>();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                root.children.add(build(q));
            }
        }
        return root;
    }
    // TS: O(N)

    public static void main(String[] args) {
        Node n0 = new Node(1);
        n0.children = new ArrayList<>();
        n0.children.add(new Node(3));
        n0.children.add(new Node(2));
        n0.children.add(new Node(4));
        n0.children.get(0).children = new ArrayList<>();
        n0.children.get(0).children.add(new Node(5));
        n0.children.get(0).children.add(new Node(6));

        SerializeAndDeserializeNaryTree obj = new SerializeAndDeserializeNaryTree();
        String data = obj.serialize(n0);
        System.out.println(data);
        Node node = obj.deserialize(data);
        System.out.println();
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}
