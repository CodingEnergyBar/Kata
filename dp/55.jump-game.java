import jdk.internal.agent.resources.agent;

/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (33.28%)
 * Likes:    3191
 * Dislikes: 284
 * Total Accepted:    377K
 * Total Submissions: 1.1M
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 */

// @lc code=start
class Solution {
    //    public boolean canJump(int[] nums) {
        // 能否到达 ai 到最后一步, , 
        // xx, 只需要知道怎么从 ai 到达的下面的可能性就可以了
        // 如何 找到 ai 满足条件
        //  ai > n-i
        // 那就是在每个 n 到向后忘, n---> 0, 找到 a[j] > i-j 即可
        // 且 a[i] 也为 可以
        
    //     int[] dp = new int[nums.length+1];
    //     dp[0] =  1;
    //     //注意边界:
    //     for(int i=0; i<=nums.length;i++){
    //          System.out.println("i: " + i);
    //         for(int j=i-1; j>=0; j--){
    //             System.out.println("j: " + j);
    //             if(nums[j] >= i-j){
    //                 //不要改 nums[i]
    //                 dp[i] = 1;
    //                 break;
    //             }
    //         }
    //      System.out.println("----------- " + i);
    //     }
    //     return dp[nums.length] == 1;
    // }

    public boolean canJump(int[] A) {
        // 这里不是 A.length+1: 
        // 想边界值: you are initially positioned at the first index of the array.
        // nums[nums.len-1]里的最后一个值没有意义: 不会再从最后一个往后跳了
        
        boolean[] can = new boolean[A.length];
        can[0] = true;
        
        for (int i = 1; i < A.length; i++) {
            //这里直接从0 到 j
            for (int j = 0; j < i; j++) {
                if (can[j] && j + A[j] >= i) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[A.length - 1];
    }
    // 九章还有 greedy 的算法

}
// @lc code=end

