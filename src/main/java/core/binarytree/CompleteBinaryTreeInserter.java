package core.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 919. Complete Binary Tree Inserter
 */
public class CompleteBinaryTreeInserter {
    List<TreeNode> nodes;

    public CompleteBinaryTreeInserter(TreeNode root) {
        this.nodes = new ArrayList<>();
        this.nodes.add(root);
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).left != null) {
                nodes.add(nodes.get(i).left);
            }
            if (nodes.get(i).right != null) {
                nodes.add(nodes.get(i).right);
            }
        }
    }
    // TS: O(N)

    public int insert(int val) {
        int n = nodes.size();
        TreeNode curr = new TreeNode(val);
        nodes.add(curr);
        // Node tree[i] has left child tree[2 * i + 1] and tree[2 * i + 2]
        if (n % 2 == 1) {
            nodes.get((n - 1) / 2).left = curr;
        } else {
            nodes.get((n - 1) / 2).right = curr;
        }
        return nodes.get((n - 1) / 2).val;
    }
    // TS:O (1)

    public TreeNode get_root() {
        return nodes.get(0);
    }

}
