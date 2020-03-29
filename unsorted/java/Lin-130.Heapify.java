public class Solution {
    /*
     * @param A: Given an integer array
     * 
     * @return: nothing
     */
    public void heapify(int[] A) {
        // min-heap

        // write your code here
        // get the non-leaf node
        for (int i = A.length / 2; i >= 0; i--) {
            shiftDown(i, A);
        }
    }

    void shiftDown(int node, int[] A) {
        int shift = node;
        int left = node * 2 + 1;
        int right = node * 2 + 2;

        if (right < A.length && A[right] < A[shift]) {
            shift = right;
        }
        if (left < A.length && A[left] < A[shift]) {
            shift = left;
        }
        if (shift != node) {
            int tmp = A[node];
            A[node] = A[shift];
            A[shift] = tmp;
            shiftDown(shift, A);
        }

    }
}