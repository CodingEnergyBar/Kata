/*
 * @lc app=leetcode id=995 lang=java
 *
 * [995] Minimum Number of K Consecutive Bit Flips
 *
 * https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/description/
 *
 * algorithms
 * Hard (46.21%)
 * Likes:    216
 * Dislikes: 27
 * Total Accepted:    8.4K
 * Total Submissions: 18.1K
 * Testcase Example:  '[0,1,0]\n1'
 *
 * In an array A containing only 0s and 1s, a K-bit flip consists of choosing a
 * (contiguous) subarray of length K and simultaneously changing every 0 in the
 * subarray to 1, and every 1 in the subarray to 0.
 * 
 * Return the minimum number of K-bit flips required so that there is no 0 in
 * the array.  If it is not possible, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [0,1,0], K = 1
 * Output: 2
 * Explanation: Flip A[0], then flip A[2].
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [1,1,0], K = 2
 * Output: -1
 * Explanation: No matter how we flip subarrays of size 2, we can't make the
 * array become [1,1,1].
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = [0,0,0,1,0,1,1,0], K = 3
 * Output: 3
 * Explanation:
 * Flip A[0],A[1],A[2]: A becomes [1,1,1,1,0,1,1,0]
 * Flip A[4],A[5],A[6]: A becomes [1,1,1,1,1,0,0,0]
 * Flip A[5],A[6],A[7]: A becomes [1,1,1,1,1,1,1,1]
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 30000
 * 1 <= K <= A.length
 * 
 */

// @lc code=start
class Solution {
    public int minKBitFlips(int[] A, int K) {
        // 滚动数组
        int[][] f = new int[A.length+1][2];

        // for(int[] arr: f){
        //     Arrays.fill(arr, new int[2]);
        // }
        int len = A.length;
        if(A.length <= 1){
            return 0;
        }
        // 0 相当于虚拟位s

        // if(A[0] == 0){
        //     f[0][1] = 1; 
        // }else{
        //     f[0][0] = 1;
        // }

        for(int i=1; i<=A.length; i++){
            //n-1为0 的:
            //目前这位 是 0: f[i-1]

            // 即将要成为的
            int willBe = 0;
            for(; willBe <=1 ;willBe++){ //[0..1]
                int flip = (A[i-1] == willBe)? 0 : 1;
                //i代表 i-1 为 willBe 的时候的最少翻转次数
                 f[i][willBe] = f[(i-1)][willBe] + flip;
            }

            System.out.println("willBe " + willBe + " " + Arrays.deepToString(f));
        }
        return Math.min(f[len][0], f[len][1]);

//         willBe 2 [[0, 0], [0, 1], [0, 0], [0, 0]]
// willBe 2 [[0, 0], [0, 1], [1, 1], [0, 0]]
// willBe 2 [[0, 0], [0, 1], [1, 1], [1, 2]]

    }
}
// @lc code=end

