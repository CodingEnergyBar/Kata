package leetcode224;
import java.util.*;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        long num = 0;
        char pre_op = '+';
        Stack<Long> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                num = 10 * num + (cur - '0');
            }
            if(cur == '+' || cur == '-' || cur == '*' || cur == '/' || i == s.length()-1){
                if(pre_op == '+') stack.push(num);
                else if(pre_op == '-') stack.push(-num);
                else if(pre_op == '*'){
                    long pre = stack.pop();
                    stack.push(pre * num);
                }else if(pre_op == '/'){
                    long pre = stack.pop();
                    stack.push(pre / num);
                }
                pre_op = cur;
                num = 0;
            }
        }
        long res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return (int)res;
    }
    public static void main(String[] args) {
        // String s = "1 + 1";
        String s = "2147483647";
        System.out.println(new Solution().calculate(s));
    }
}
// @lc code=end

