package lintcode92;
class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    int capacity;
    int max;
    // public int backPack(int m, int[] A) {
    //     // write your code here
    //     this.capacity = m;
    //     this.max = 0;
    //     dfs(A, 0, 0);
    //     return this.max;
    // }
    // void dfs(int[]A, int p, int curSum){
    //     if(p == A.length){
    //           max = Integer.max(max, curSum);
    //                       return;

    //     }


      
    //     if(curSum + A[p] > capacity) {
    //             max = Integer.max(max, curSum);
    //           dfs(A, p+1, curSum);
         
         
    //       };
    //         dfs(A, p+1, curSum+A[p]);
    // }
    
      public int backPack(int m, int[] A) {
        //   the max size with i products, in requirement j
        int M = A.length, N = m;
        int dp[][] = new int[M+1][m];
        for(int i=0; i<M; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<m; j++){
            dp[0][j] = 0;
        }
    
       
        for(int i=1; i<=M;i++){ //[0, i)
         for(int j=1; j<N; j++){
                if(j - A[i] >= 0)
                    dp[i][j] = Math.max(dp[i-1][j] + A[i], dp[i-1][j - A[i]]);
                dp[i][j] = dp[i-1][j];
            }
        }
     
        return dp[M-1][N-1];
      }
}