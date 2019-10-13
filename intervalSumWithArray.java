/**
 * Definition of Interval: public classs Interval { int start, end; Interval(int
 * start, int end) { this.start = start; this.end = end; } }
 */

public class Solution {
    /**
     * @param A:       An integer list
     * @param queries: An query list
     * @return: The result list
     */
    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        // write your code here
        List<Long> res = new ArrayList(queries.size());
        if (A == null || A.length == 0)
            return res;

        // take care of the +1 technique
        long[] sum = new long[A.length];

        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
        }

        // 0, 1, 3, 10,
        // SUM[END+1] - SUM[START]
        // A0+A1+A2 - A0
        // A1 + A2

        for (Interval i : queries) {
            int start = i.start;
            int end = i.end;

            // end - start + a[start]
            res.add(sum[end] - sum[start] + A[start]);
        }
        return res;

    }
}