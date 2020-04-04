/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 *
 * https://leetcode.com/problems/happy-number/description/
 *
 * algorithms
 * Easy (48.70%)
 * Likes:    1484
 * Dislikes: 341
 * Total Accepted:    335K
 * Total Submissions: 687.8K
 * Testcase Example:  '19'
 *
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 
 * 
 * 
 * Input: 19
 * Output: true
 * Explanation: 
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set <Integer> set = new HashSet();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = getHappy(n);
        }
        // System.out.println(n);
        // System.out.println(set.toString());
        
        return n == 1;
    }
    
    int getHappy(int n){
        int res = 0;
        while(n != 0){
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}
// @lc code=end

