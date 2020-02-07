/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
public double myPow(double x, int shortn) {

    double res = 1.0;
    double base = x;

    long n = (long) shortn;
    if (n < 0) {
        base = 1.0 / base;

        n = -n;

    }
    while (n != 0) {
        if (n % 2 == 1)
            res = res * base;
        n = n / 2;
        base = base * base;
    }
    return res;

    }
}
// @lc code=end
