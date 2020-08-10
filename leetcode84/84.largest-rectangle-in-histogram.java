package leetcode84;
/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

import java.util.*;

// @lc code=start
class Solution {
    // public int largestRectangleArea1(int[] heights) {
    //     int res = 0, n=heights.length;
    //     // 我们只需在这些局部峰值出进行处理，为啥不用在非局部峰值处统计呢，这是因为非局部峰值处的情况，后面的局部峰值都可以包括，
    //     for(int i=0; i<n; i++){
    //         if(i+1<n && heights[i] <= heights[i+1]){
    //             continue;
    //         }
    //         int minH = heights[i];
    //         for(int j=i; j>=0; --j){
    //             minH = Math.min(minH, heights[j]);
    //             int area = minH * (i-j + 1);
    //             res = Math.max(res, area);
    //         }

    //     }
    //     return res;
    // }

    public int largestRectangleArea(int[] heights) {

        int[] height = new int[heights.length+1];
        for(int i=0; i<heights.length;i++)
            height[i] = heights[i];
        // 我们只需在这些局部峰值出进行处理，为啥不用在非局部峰值处统计呢，这是因为非局部峰值处的情况，后面的局部峰值都可以包括，
        int res=0;
        Stack<Integer> st = new Stack<>();
        // List<Integer> height = Arrays.asList(heights);
        // height.add(0);
        for (int i = 0; i < height.length; ++i) {
            if (st.empty() || height[st.peek()] < height[i]) {
                st.push(i);
            } else {
                int cur = st.peek(); st.pop();
                res = Math.max(res, height[cur] * (st.empty() ? i : (i - st.peek() - 1)));
                --i;
            }     
        }
        return res;
    
    }
    public static void main(String[] args) {
        int[] heights =  {2,1,5,6,2,3};
        System.out.println(new Solution().largestRectangleArea(heights));
        
    }
}
// @lc code=end

