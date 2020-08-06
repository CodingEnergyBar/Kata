public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: the minimize travel distance
     */
    public int minTotalDistance(int[][] grid) {
        // Write your code here
        //1,0,0,0,1
        //0,0,0,0,0
        //0,0,1,0,0
        
        //1,1,0,0,1
        //1,0,1,0,0
        //0,0,1,0,1
        
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        int R = grid.length;
        if(R == 0) return 0;
        int C = grid[0].length;
        if(C == 0) return 0;
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(grid[i][j] == 1){
                    xList.add(i);
                    yList.add(j);
                }
            }
        }
        Collections.sort(xList);
        Collections.sort(yList);
        int xM = xList.get(xList.size()/2); 
        int yM = yList.get(yList.size()/2); 
        
        int res = 0;
        for(int i=0; i<xList.size(); i++){
            res += Math.abs(xList.get(i) - xM);
            res += Math.abs(yList.get(i) - yM);
        }

        return res;

        
    }
}