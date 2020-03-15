/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] A, int K) {
        int l=0, r=-1;
        int res = 0;
        while(l < A.length){
            if(r+1<A.length && A[r+1] == 1){
                r++;
            }else if(r+1<A.length && A[r+1] == 0 && K >0){
                r++;
                K--;
            }else{
                if(A[l] == 0)
                    K++;
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
// @lc code=end

