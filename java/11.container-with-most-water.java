/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        System.out.println("i " + i);
        System.out.println("j " + j);
        int max = Integer.MIN_VALUE;
        while (i < j) {
            System.out.println("max " + max);
            max = Math.max(max, getCurrentArea(i, j, height));
            if (height[i] <= height[j]) {
                int cur = height[i];
                while (height[i] <= cur && i < j)
                    i++;
            } else {
                int cur = height[j];
                while (height[j] <= cur && i < j)
                    j--;
            }
            System.out.println("i " + i);
            System.out.println("j " + j);

        }
        return max;
    }

    int getCurrentArea(int i, int j, int[] height) {
        int h = Math.min(height[i], height[j]);
        return Math.abs(j - i) * h;
    }

    public static void main(String[] args) {
        int[] test = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("test " + test);
        System.out.println(new Solution().maxArea(test));
    }
}
// @lc code=end
