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
        // Arrays.sort(A);

        List<Long> res = new ArrayList(queries.size());

        for (int i = 0; i < queries.size(); i++) {
            Interval cur = queries.get(i);
            Long sum = getIntervalSum(A, cur.start, cur.end);
            res.add(i, sum);
        }
        return res;

    }

    Long getIntervalSum(int[] A, int start, int end) {
        long sum = 0;
        for (int i = start; i <= end; i++) {

            sum += (long) A[i];
        }
        return sum;
    }
}