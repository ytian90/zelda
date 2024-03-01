package core.binarytree;

import core.utils.TreePrint;

/**
 * LC 1028. Recover a Tree From Preorder Traversal
 */
public class RecoverATreeFromPreorderTraversal {
    int index = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        return helper(traversal, 0);
    }

    private TreeNode helper(String s, int level) {
        int i = 0;
        while (index < s.length() && s.charAt(index + i) == '-') {
            i++;
        }
        if (i != level) {
            return null;
        }
        int next = i + index;
        int val = 0;
        while (next < s.length() && Character.isDigit(s.charAt(next))) {
            val = 10 * val + (s.charAt(next) - '0');
            next++;
        }
        index = next;
        TreeNode node = new TreeNode(val);
        node.left = helper(s, level + 1);
        node.right = helper(s, level + 1);
        return node;
    }
    // TS: O(N)

    public static void main(String[] args) {
        RecoverATreeFromPreorderTraversal o = new RecoverATreeFromPreorderTraversal();
        TreePrint.printTreeNode(o.recoverFromPreorder("1-2--3--4-5--6--7"));
    }

}
