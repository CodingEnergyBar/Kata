import java.util.LinkedList;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char a : s.toCharArray()) {
            if (a == '(' || a == '[' || a == '{')
                stack.push(a);
            else {
                if (stack.isEmpty())
                    return false;
                char c = (char) stack.pop();
                if (a == ')' && c == '(')
                    continue;
                if (a == '}' && c == '{')
                    continue;
                if (a == ']' && c == '[')
                    continue;
                return false;
            }
        }
        return stack.isEmpty();

    }
}
// @lc code=end
