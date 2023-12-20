package core.stack;

/**
 * LC 921. Minimum Add to Make Parentheses Valid
 */
public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int extraOpen = 0;
        int extraClose = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                extraOpen++;
            } else if (c == ')') {
                if (extraOpen > 0) {
                    extraOpen--;
                } else {
                    extraClose++;
                }
            }
        }
        return extraOpen + extraClose;
    }
    // T: O(N)
    // S: O(1)
}
