/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        if(height == null && height.length = 0)
            return 0;
       
        int i=0, j=height.length-1;
        int res = getArea(height, i, j);
        while(i < j){
            if(height[i] > height[j]){
                j--;
            }else{// height[i] <= height[j] 
                i++;
            }
            res =  Math.max(res, getArea(height, i, j));
        }
        return res;

    }
    int getArea(int[] height, int i, int j){
        int h = Math.min(height[i], height[j]);
        return h * Math.abs(j-i);
    }
}
// @lc code=end

