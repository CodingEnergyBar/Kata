/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.72%)
 * Likes:    2227
 * Dislikes: 2468
 * Total Accepted:    355K
 * Total Submissions: 1.5M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */

// @lc code=start
public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        int len = s.length();
        if(len == 0)
            return 0;
        int[] dp = new int[len];
        // Arrays.fill(dp, -1);
    
        for(int i=0; i<len; i++){
            // i-1 i-2
            // i-1]
            // boolean canParse = false;
            String s1 = s.substring(i, i+1);
            Integer i1 = Integer.parseInt(s1);
            if(i1 > 0 && i1 <= 9){
                // canParse = true;
                if(i-1>=0)
                    dp[i] += dp[i-1];
                else
                    dp[i] += 1;
            }
            //i-2]
            if(i-1>=0){
                String s2 = s.substring(i-1, i+1);
                Integer i2 = Integer.parseInt(s2);
                if(i2 >= 10 && i2 <= 26){
                    // canParse = true;
                    if(i-2 >=0)
                        dp[i] += dp[i-2];
                    else
                        dp[i] +=1;
                }
            }
            // if(!canParse){
            //     dp[i] = 0;
            // }
            // System.out.println("dp: " + Arrays.toString(dp));
          
        }
        return dp[len-1];
    }
}
// @lc code=end

