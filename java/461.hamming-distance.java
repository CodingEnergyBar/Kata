/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        while (x > 0 || y > 0) {
            int bx = x % 2;
            int by = y % 2;
            if (bx != by)
                res += 1;
            x = x / 2;
            y = y / 2;
        }
        return res;

    }
}
// @lc code=end
