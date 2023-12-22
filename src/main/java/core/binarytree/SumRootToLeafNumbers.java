package core.binarytree;

/**
 * LC 129. Sum Root to Leaf Numbers
 */
public class SumRootToLeafNumbers {
    int res = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        num = 10 * num + root.val;
        if (root.left == null && root.right == null) {
            res += num;
        }
        dfs(root.left, num);
        dfs(root.right, num);
    }
    // T: O(N)
    // S: O(H)

}
