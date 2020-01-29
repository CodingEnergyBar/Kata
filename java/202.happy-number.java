import java.util.Set;

/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        record.add(n);
        // 个位数: 退出的条件是产生了循环!!
        while (n != 1) {
            n = process(n);
            if (record.contains(n))
                return false;
            record.add(n);
        }
        return true;
    }

    int process(int n) {
        int res = 0;
        while (n != 0) {
            int d = n % 10;
            res += d * d;
            n /= 10;
        }
        // System.out.println("res " + res);
        return res;
    }
}
// @lc code=end
