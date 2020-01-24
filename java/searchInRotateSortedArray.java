public class Solution {
    /**
     * @param A:      an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean
     */
    public int search(int[] A, int target) {
        // write your code here

        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = A.length - 1;
        int rightEnd = A[A.length - 1];

        while (start + 1 < end) {
            // System.out.println("start "+ start + "end "+ end);
            int mid = (start + end) / 2;

            if (target == A[mid])
                return mid;

            if (target > rightEnd) {

                if (target > A[mid] && A[mid] > rightEnd) {
                    start = mid;
                    continue;
                }
                if (target > A[mid] && A[mid] <= rightEnd) {
                    end = mid;
                    continue;
                }
                if (target < A[mid]) {
                    end = mid;
                    continue;
                }

            } else {
                // target <= rightEnd left hand
                if (target > A[mid]) {
                    start = mid;
                    continue;
                }
                if (target < A[mid] && A[mid] <= rightEnd) {
                    end = mid;
                    continue;
                }
                if (target < A[mid] && A[mid] > rightEnd) {
                    start = mid;
                    continue;
                }
            }
        }
        if (A[start] == target)
            return start;
        if (A[end] == target) {
            return end;
        }

        return -1;

    }
}