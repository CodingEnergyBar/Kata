/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.46%)
 * Likes:    2393
 * Dislikes: 3680
 * Total Accepted:    781.6K
 * Total Submissions: 3.1M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 * 
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int sign = x<0? -1: 1;

        if(x == Integer.MIN_VALUE){
            return 0;
        }
        long res = 0;
        if(x < 0){
            x = -x;
        }
        while(x != 0){
            res = res * 10 + x % 10;
            if(res > Integer.MAX_VALUE){
                return 0;
            }
            x = x /10;
        }
        return (int)res * sign;

    }
}
// @lc code=end

