/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        Stack <Integer> dStack = new Stack<>();
        int totalWater = 0;
        for(int i=0; i < height.length; i++){
            int last = 0;
            // 这里是小于/ 小于等于都可以 囧
            while(!dStack.isEmpty() && height[dStack.peek()] < height[i]){
                int pre = dStack.pop();
                totalWater += (height[pre] - height[last]) * (i - pre - 1);
                last = pre;
            }
            if(!dStack.isEmpty()){
                // height[dStack.peek()] >= height[i])
                totalWater += (height[i] - height[last]) * (i - dStack.peek() -1);
            }
            dStack.push(i);
        }
        //最后一层是咋回事??)

        return totalWater;
        
    }
}
// @lc code=end

