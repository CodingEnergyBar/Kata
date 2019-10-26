import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (36.58%)
 * Likes:    2584
 * Dislikes: 204
 * Total Accepted:    415.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        // it is possible to add in[]
        // arrays sort, copyof,
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        List<int[]> res = new LinkedList();

        for (int i = 0; i < intervals.length; i++) {
            if (res.size() == 0) {
                res.add(intervals[i]);
                continue;
            }
            int[] last = res.get(res.size() - 1);
            // System.out.println("last " + Arrays.toString(last));
            // else end >'= start
            if (last[1] >= intervals[i][0]) {
                last[1] = Math.max(intervals[i][1], last[1]);
            } else {
                res.add(intervals[i]);
            }
            // System.out.println("res " + Arrays.deepToString(res.toArray()));
        }
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end
