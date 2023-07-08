package core.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 297. Serialize and Deserialize Binary Tree
 */
public class SerializeAndDeserializeBinaryTree {
    private static final String SPLITTER = "/";
    private static final String NN = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.deleteCharAt(0).toString();
    }

    private void build(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(SPLITTER).append(NN);
            return;
        }
        sb.append(SPLITTER).append(node.val);
        build(node.left, sb);
        build(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split("/")));
        return build(q);
    }

    private TreeNode build(Queue<String> q) {
        String s = q.poll();
        if (NN.equals(s)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = build(q);
        root.right = build(q);
        return root;
    }
    // TS: O(N)

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();
        TreeNode n0 = new TreeNode(1);
        n0.left = new TreeNode(2);
        n0.right = new TreeNode(3);
        n0.right.left = new TreeNode(4);
        n0.right.right = new TreeNode(5);
        String data = obj.serialize(n0);
        System.out.println(data);
        obj.deserialize(data);
    }

}
