package core.stack;

import java.util.Stack;

/**
 * LC 71. Simplify Path
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] p = path.split("/");
        for (String s : p) {
            if (!stack.isEmpty() && "..".equals(s)) {
                stack.pop();
            } else if (!"".equals(s) && !".".equals(s) && !"..".equals(s)) {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }
    // T: O(N)
    // S: O(N)
}
