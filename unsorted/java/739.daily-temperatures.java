/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i=0; i<T.length;i++){
            // if(stack.isEmpty() ||  T[i] <= T[stack.peek()]){
               
            // }else{
                while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                    int large = i;
                    int r = stack.pop(); 
                    res[r] = (i - r);
                }
            // }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int r = stack.pop();
            res[r] = 0;
        }
        return res;

        
    }
}
// @lc code=end

