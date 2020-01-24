public class Solution {
    /*
     * @param A: An integer array.
     * 
     * @return: nothing
     */
    public void rerange(int[] A) {
        if (A.length <= 2)
            return;
        // partition
        int pos = 0, neg = 0;
        for (int a : A) {
            if (a > 0)
                pos++;
            if (a < 0)
                neg++;
        }
        int posBehind = 1; // positive to the second half
        if (neg > pos)
            posBehind = -1; // negative to the second half

        int left = 0, right = A.length - 1;
        while (left <= right) {
            while (left <= right && A[left] * posBehind < 0)
                left++;
            while (left <= right && A[right] * posBehind > 0)
                right--;
            if (left <= right) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            }
        }

        // then
        int p1 = 0, p2 = A.length - 1;
        if (neg != pos)
            p2 = A.length - 2;
        while (p1 < p2) {
            swap(A, p1, p2);
            p1 += 2;
            p2 -= 2;
        }
    }

    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}