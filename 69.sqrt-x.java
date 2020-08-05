/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        long start=1, end = x/2, mid;
        // int mid = start + (end - start) / 2; 
        // [)
        while(start < end){
            mid = start + (end - start) / 2;
            long tmp = mid * mid;
             if(isValid(mid, x)){
                return (int) mid;
            }else if(tmp > x){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return (int) start;
    }
    boolean isValid(long mid, long target){
        long s = mid * mid;
        long e = (mid + 1) * (mid + 1);
        return target >= s && target < e;
    }
}
// @lc code=end

