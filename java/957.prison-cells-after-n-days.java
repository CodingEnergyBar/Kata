/*
 * @lc app=leetcode id=957 lang=java
 *
 * [957] Prison Cells After N Days
 */

// @lc code=start
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(cells.length <= 2)
            return cells;
        
        for(int i=0; i<N; i++){
            changeAfterOneDay(cells);
        }
        return cells;
    }
    void changeAfterOneDay(int [] cells){
        for(int i=1; i<cells.length -1 ;i++){
            int prev = cells[i-1];
            int next =  cells[i+1];
            if(prev == next)
                cells[i] = 1;
            else  
                cells[i] = 0;

        }
    }
}
// @lc code=end

