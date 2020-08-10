import jdk.internal.agent.resources.agent;

/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start
class Solution {
    int res = 0;
    List<Integer> path = new ArrayList<>();
    int[] memo;
    int times = 0;;
    public int combinationSum4(int[] nums, int target) {
        // int n = nums.length, m= target;
        //  int[][] dp = new int[n+1][m+1];
        // //  [0.n) ==>0
        //  int i, j;
        //  for(i=0; i<=n; i++){
        //      dp[i][0] = 1;
        //  }
        //  //dp[0][j] = 0===> 0
        //  for(i=1; i<=n; i++){
        //      for(j=0; j<=m;j++){
        //          //
        //          int amt =nums[i-1];
        //          for(int w=0; w * amt <= j; w++){
        //              dp[i][j] += dp[i-1][j-w*amt];
        //          }
        //      }
        //  }
        //  return dp[n][m];
        memo = new int[target+1];
        Arrays.fill(memo, -1);
        dfs(0, nums, target);
        
        System.out.println("times " + times);
        
        return res;
        
    }
    int dfs(int start, int[] nums, int rest){

        if(memo[rest] != -1)
            return memo[rest];
        
        times++;
        int a = 0;
        for(int i=start; i<nums.length; i++){
            int cur = nums[i];
            if(rest - cur > 0) // 这里是 start 而不是
               a += dfs(start, nums, rest-cur);
            else if(rest - cur == 0){
                a+=1;
                res++;
            }
        }
        memo[rest] = a;
        return a;
    }
}
// @lc code=end

