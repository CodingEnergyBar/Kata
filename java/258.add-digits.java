/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int res = 0, tmp = num;
            while (tmp != 0) {
                res += tmp % 10;
                tmp = tmp / 10;
            }
            num = res;
        }
        return num;

    }
}
// @lc code=end
