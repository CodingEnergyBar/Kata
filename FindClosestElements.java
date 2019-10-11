public class Solution {
    /**
     * @param A:      an integer array
     * @param target: An integer
     * @param k:      An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {

        // write your code here
        // find min but max tree here

        PriorityQueue<Integer> findMin = new PriorityQueue<Integer>((a, b) -> {
            int diff = Math.abs(b - target) - Math.abs(a - target);
            if (diff == 0)
                diff = b - a;
            return diff;
        }); // but find the max in the pool;

        for (int i = 0; i < A.length; i++) {
            findMin.add(A[i]);
            if (findMin.size() > k) {
                findMin.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = findMin.poll();
        }

        return res;
    }
}