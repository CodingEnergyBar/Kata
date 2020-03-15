/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n);
        // visited[], 必须是 boolean 而不是 int
        boolean[] visited = new boolean[n];

        int step = 0;
        while(!queue.isEmpty()){
         
            int size = queue.size();
               step++;
            for(int i=0; i<size; i++){
                int rest = queue.poll();
                
                for(int j=1; j*j <= rest; j++){
                    if(j*j == rest){
                        return step;
                    }else{
                        int r = rest - j*j;
                        if(!visited[r]){
                            visited[r] = true;
                        queue.offer(r);
                        }
                    }
                }
            
            }
        }
        return step;

    }
    
}
// @lc code=end

