/*
 * @lc app=leetcode id=1011 lang=javascript
 *
 * [1011] Capacity To Ship Packages Within D Days
 *
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 *
 * algorithms
 * Medium (54.88%)
 * Likes:    553
 * Dislikes: 17
 * Total Accepted:    21.6K
 * Total Submissions: 38.8K
 * Testcase Example:  '[1,2,3,4,5,6,7,8,9,10]\n5'
 *
 * A conveyor belt has packages that must be shipped from one port to another
 * within D days.
 * 
 * The i-th package on the conveyor belt has a weight of weights[i].  Each day,
 * we load the ship with packages on the conveyor belt (in the order given by
 * weights). We may not load more weight than the maximum weight capacity of
 * the ship.
 * 
 * Return the least weight capacity of the ship that will result in all the
 * packages on the conveyor belt being shipped within D days.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * Explanation: 
 * A ship capacity of 15 is the minimum to ship all the packages in 5 days like
 * this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * 
 * Note that the cargo must be shipped in the order given, so using a ship of
 * capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6,
 * 7), (8), (9), (10) is not allowed. 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: weights = [3,2,2,4,1,4], D = 3
 * Output: 6
 * Explanation: 
 * A ship capacity of 6 is the minimum to ship all the packages in 3 days like
 * this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: weights = [1,2,3,1,1], D = 4
 * Output: 3
 * Explanation: 
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 * 
 */

// @lc code=start
/**
 * @param {number[]} weights
 * @param {number} D
 * @return {number}
 */
/**
 * @param {number[]} weights
 * @param {number} D
 * @return {number}
 */

/*
Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed. 
*/

var shipWithinDays = function(weights, D) {
    // should not be sorted
    // weights.sort((a,b)=>a-b);
    
    let start = weights[weights.length-1], end = weights.reduce((a,b)=>a+b, 0);
    while(start + 1 < end){
        let mid = Math.floor((start + end)/2);
        if(canConvey(mid)){
            end = mid;
        }else{
            start = mid;
        }
    }
    
    console.log("start", start);
    console.log("end", end);
    console.log("canConvey",canConvey(6))
    if(canConvey(start))
        return start;
    return end;

    
    
    function canConvey(capacity){
        // the first day, you start to carry: 
        let days = 1, curWeight = 0;
        
        for(const weight of weights){
            // weight > capacity also something
            if(days > D || weight > capacity)
                return false;
            if(curWeight + weight <= capacity){
                curWeight += weight;
            }else{
                // not 0, but the weight last time
                // always add weight to the cart 
                curWeight = weight;
                // the days could be adjusted 
                days++;
                
            }
            // console.log("curWeight", curWeight);
            // console.log("days", days);
        }
        return days <= D;
    }
};


// @lc code=end

