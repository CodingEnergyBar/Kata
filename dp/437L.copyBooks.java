public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int K) {
        // write your code here
        int n = pages.length;
        
        int i, j, k, s;
        // i个人,  j 书, 有点背包的意思
        int[][] f = new int[K+1][n+1];
        
        //0 个抄写员抄 最小时间 --> 最后一个抄写员编号-1
        f[0][0] = 0;
        //0 个抄写员 开始抄写第 j 本书的时间
        for(j=1; j<=n; j++){
            f[0][j] = Integer.MAX_VALUE;
        }
        
        //先列举书
        for(k=1; k<=K; k++){
            // k 个抄写员 抄写0 本书也是初始化的部分
            f[k][0] = 0;
            for(i=1; i<=n; i++){
                f[k][i] = Integer.MAX_VALUE;
                s = 0; // s是 抄写时间 timeZ
                // 列举最后一个抄写员抄写的书的个数, 最后一本书的编号是i
                for(j = i; j>=0; j--){
                    //前 k -1 个 人抄了 j 本书 
                    // 最后一个人抄从 j 到 i 的书
                    if(f[k-1][j] != Integer.MAX_VALUE)
                        f[k][i] = Math.min(f[k][i], Math.max(f[k-1][j],s));
                    //这里也很醉啊, 是 j-1 下个循环的时候才是 j
                    if(j>0) s += pages[j-1];
                }
            }
        }
        return f[K][n];
        
        // for(i=1; i < k; i++){
        //     //i 个抄写员抄写 j 本书的最小花费
        //     for(j=0; j< n; j++){
        //         // 枚举最后一个抄写员抄写的书的个数
        //         // 现在最后一个抄写员抄写书的个数
        //         int minTime  = Integer.MAX_VALUE;
        //         int timeZ = 0;
        //         for(int z=0; z <= j; z++){
        //             timeZ += pages[j-z];
        //             int curTime = f[i-1][j-z];
        //             minTime = Math.min(minTime, curTime)
        //         }
                
        //      }
            
        // }
        
    }
}