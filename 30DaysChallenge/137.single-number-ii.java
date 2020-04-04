/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 *
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (48.66%)
 * Likes:    1280
 * Dislikes: 315
 * Total Accepted:    201.6K
 * Total Submissions: 412K
 * Testcase Example:  '[2,2,3,2]'
 *
 * Given a non-empty array of integers, every element appears three times
 * except for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * 
 * Input: [2,2,3,2]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * 
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {

    
        int[] bits  = new int [32];
        int res = 0;
    // Solution 1: 
// for(int num: nums){
//     for(int i=0; i<32; i++){
//         // 数字右移:>> 变小, 摒弃低位, 统计高位
//         bits[i] += (num >> i) & 1;
//         bits[i] %= 3;
//     }
// }

// for(int i = 0; i< 32; i++){
//     if(bits[i] == 1)
//     // 位操作的优先级小于 +, 所以还要有括号, 或者 res += bits << i
//         res = res + (bits[i] << i);
// }


        // 优化, 外层统计位, 内层过滤数
        for(int i=0; i<32; i++){
            // 统一右移 i 位
            for(int num: nums){
                bits[i] +=(num >> i) & 1;
                bits[i] %= 3;
            }
            if(bits[i] == 1)
                res |= bits[i] << i;
        }
        return res;
    }
}
// @lc code=end
cod
