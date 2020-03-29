/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char a: s.toCharArray()){
            if(a == '('){
                stack.push(')');
            }else if(a == '{'){
                stack.push('}');
            }else if(a == '['){
                stack.push(']');
            }else{
                // another special case
                if(stack.isEmpty()) 
                    return false;
                    
                if(stack.peek() != a)
                    return false;
                else{
                    stack.pop();
                }
            }

        }
        return stack.isEmpty();

        
    }
}
// @lc code=end

