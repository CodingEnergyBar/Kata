import java.util.*;

/*
 * @lc app=leetcode id=475 lang=java
 *
 * [475] Heaters
 */

// @lc code=start
class Solution {
    //每个 house 找最近的heater
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);

        int start = 0;
        int curMin = 0;
        for(int i=0; i<houses.length; i++){
            start = findClosestHeater(start, heaters.length-1, houses[i], heaters);
            if(Math.abs(heaters[start] - houses[i]) > curMin){
                curMin = Math.abs(heaters[start] - houses[i]);
            }
        }
        return curMin;
    }

    // index start, end 
    int findClosestHeater(int start, int end, int house, int[] heater){
        while(start + 1 < end){
            int mid = (start + end) / 2;
            if(heater[mid] == house)
                return mid;
            if(heater[mid] > house){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(Math.abs(heater[start] - house) < Math.abs(heater[end] - house))
            return start;
        return end;
    }
}
// @lc code=end

