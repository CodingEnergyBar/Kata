public class Solution {
    /**
     * @param A:      an integer array
     * @param target: An integer
     * @param k:      An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        // Need to add Integer at the behind
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a - target) != Math.abs(b - target)) {
                return (Math.abs(a - target) - Math.abs(b - target));
            } else {
                return a - b;
            }

        });

        for (int a : A) {
            pq.add(a);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}