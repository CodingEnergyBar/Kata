import java.util.Map;

/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // c[k] + d[l] => map (sum, freq)
        Map<Integer, Integer> cdsum = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                cdsum.put(sum, cdsum.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                int complement = -sum;
                if (cdsum.containsKey(complement)) {
                    res += cdsum.get(complement);
                }
            }
        }
        return res;

    }
}
// @lc code=end
