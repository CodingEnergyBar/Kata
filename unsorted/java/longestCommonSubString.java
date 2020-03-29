public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] T = new int[A.length()][B.length()];

        int max = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    int pre = 0;
                    if (i >= 1 && j >= 1) {
                        pre = T[i - 1][j - 1];
                    }

                    T[i][j] = 1 + pre;
                } else {
                    T[i][j] = 0;
                }
                if (T[i][j] > max) {
                    max = T[i][j];
                }
            }
        }
        return max;
    }
}