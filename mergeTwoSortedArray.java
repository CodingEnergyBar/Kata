public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int[] res = new int[A.length + B.length];
        int index = 0;
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] > B[j]) {
                res[index++] = B[j++];
            } else {
                res[index++] = A[i++];
            }
        }
        while (i < A.length) {
            res[index++] = A[i++];
        }
        while (j < B.length) {
            res[index++] = B[j++];
        }
        return res;
    }
}c