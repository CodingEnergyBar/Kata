/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
int[] memo;

public int longestOnes(int[] A, int K) {
    memo = new int[A.length];
    for (int i = 0; i < A.length; i++) {
        // [1...len-1]
        if (A.length - i <= K)
            memo[i] = (A.length - i);
        memo[i] = A[i] == 1 ? 1 : 0;
    }
    // [0...len-K-1, len-K... len-1]
    for (int j = A.length - K - 1; j >= 0; j--) {
        int res = 0;
        int k = K;
        //最好的 strategy 不一定是碰到了一个0 就该
        for (int l = j; l < A.length && k > 0; l++) {
            if (A[l] == 0) {
                k--;
            }
            res++;
        }

        memo[j] = Math.max(memo[j + 1], res);
    }

    return memo[0];
}
}
// @lc code=end
