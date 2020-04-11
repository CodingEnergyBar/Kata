/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 *
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 *
 * algorithms
 * Hard (29.34%)
 * Likes:    906
 * Dislikes: 30
 * Total Accepted:    123.8K
 * Total Submissions: 418.8K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using
 * 1 cut.
 * 
 * 
 */

// @lc code=start
class Solution {
    boolean [][] calcPalin(char[] s){
        int n = s.length;
        int i, j, mid;
        boolean[][] palin =  new boolean[n][n];
        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                //不同语言不一样, 所以赋值一下比较放心
                palin[i][j] = false;
            }
        }
        // 中心轴
        for(mid =0; mid < n; mid++){
            i = j = mid;
            while (i>= 0 && j < n && s[i] == s[j]){
                palin[i][j] = true;
                --i;
                j++;
            }
            // even length
            i = mid;
            j = mid+1;
            while( i>=0 && j < n && s[i] == s[j]){
                palin[i][j] = true;
                --i;
                j++;
            }
        }
        
        return palin;
    }
    public int minCut(String ss) {
        char[] s = ss.toCharArray();
        int n = s.length;

        if(n == 0)
            return 0;

        boolean[][] isPalin = calcPalin(s);

        int[] f = new int[n+1];
        f[0] = 0;
        int i, j;
        for(i=1; i<=n; i++){
            //这种写法也很好的样子
            f[i] = Integer.MAX_VALUE;
            for(j=0;j< i; j++){
                //注意前 i 个数, 最后一位是 i-1
                if(isPalin[j][i-1])
                 f[i] = Math.min(f[i], f[j] + 1);
            }
        }
        //x-1 刀, x 段
        return f[n] -1;
    }
}
// @lc code=end

