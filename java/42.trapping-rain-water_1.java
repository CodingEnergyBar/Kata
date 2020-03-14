/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftGreater = new int[len];
        int [] rightGreater = new int[len];

        Stack<Integer> decreaseStack = new Stack<>();
        for(int i=0; i<len; i++){
            while(!decreaseStack.isEmpty() && height[decreaseStack.peek()] < height[i]){
                int resIndex = decreaseStack.pop();
                rightGreater[resIndex] = i;
            }
            decreaseStack.push(i);
        }
        while(!decreaseStack.isEmpty()){
            int resIndex = decreaseStack.pop();
            rightGreater[resIndex] = -1;
        }
        // left 
        for(int i=len-1; i>=0; i--){
            while(!decreaseStack.isEmpty() && height[decreaseStack.peek()] < height[i]){
                int resIndex = decreaseStack.pop();
                leftGreater[resIndex] = i;
            }
            decreaseStack.push(i);
        }
        while(!decreaseStack.isEmpty()){
            int resIndex = decreaseStack.pop();
            leftGreater[resIndex] = -1;
        }
        //    System.out.println("leftGreater");
        // System.out.println(Arrays.toString(leftGreater));
     
        // System.out.println("rightGreater");
        // System.out.println(Arrays.toString(rightGreater));
        int water = 0;
        Set<String> visited = new HashSet<>();
        for(int i=0; i<len; i++){
            int rIndex = rightGreater[i];
            int lIndex = leftGreater[i];
            
            if(rIndex != -1 && lIndex != -1 && !visited.contains(lIndex + " " + rIndex)){
              
                visited.add(lIndex + " " + rIndex);
                int w = Math.abs(rIndex - lIndex) - 1;
                int h = Math.min(height[rIndex], height[lIndex]) - height[i];
                            // System.out.println("i: " + i + " w: " + w + " h: " + h);
                water += w * h;
    
            }
        }
        return water;




        
    }
}
// @lc code=end

