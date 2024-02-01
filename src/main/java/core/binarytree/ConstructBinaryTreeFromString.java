package core.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 536. Construct Binary Tree from String
 */
public class ConstructBinaryTreeFromString {
    // dfs
    int p;

    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        return dfs("(" + s + ")");
    }

    private TreeNode dfs(String s) {
        int start = p + 1;
        int end = start + 1;
        while (end < s.length() && Character.isDigit(s.charAt(end))) {
            end++;
        }
        int val = Integer.parseInt(s.substring(start, end));
        TreeNode node = new TreeNode(val);
        p = end;
        if (s.charAt(p) == '(') {
            node.left = dfs(s);
            if (s.charAt(p) == '(') {
                node.right = dfs(s);
            }
        }
        p++;
        return node;
    }
    // TS: O(N)

    // stack
    public TreeNode str2tree2(String s) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int i = 0, start = i; i < s.length(); i++, start = i) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            } else if (Character.isDigit(c) || c == '-') {
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                }
                TreeNode node = new TreeNode(Integer.parseInt(s.substring(start, i + 1)));
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left == null) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
                stack.push(node);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }
    // TS: O(N)

    // dfs without optimization
    public static TreeNode str2tree3(String s) {
        return helper(s);
    }

    private static TreeNode helper(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int firstLeft = s.indexOf('(');
        int val = firstLeft == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstLeft));
        TreeNode node = new TreeNode(val);
        if (firstLeft == -1) {
            return node;
        }
        int start = firstLeft, balance = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else if (s.charAt(i) == ')') {
                balance--;
            }
            if (balance == 0 && start == firstLeft) {
                node.left = helper(s.substring(start + 1, i));
                start = i + 1;
            } else if (balance == 0) {
                node.right = helper(s.substring(start + 1, i));
            }
        }
        return node;
    }
    // T: O(N ^ 2)
    // S: O(N)

}
