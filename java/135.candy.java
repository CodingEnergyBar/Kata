/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int[] memo = new int[ratings.length];
        Arrays.fill(memo, 1);
        for(int i=0; i<ratings.length-1;i++){
            if(ratings[i+1] > ratings[i]){
                memo[i+1] = memo[i] + 1;
            }
            //  System.out.println(Arrays.toString(memo));
        }
        for(int j=ratings.length-1; j>=1; j--){
            // 两个细节: 区间上别绕不清: j[len-1...1]
            // 因为前一遍的遍历, 已经有一部分的 满足, 检查一下memo 的信息[1,3,4,5,2]
            if(ratings[j-1] > ratings[j] && memo[j-1] <= memo[j]){
                memo[j-1] = memo[j] + 1;
            }
            // System.out.println(Arrays.toString(memo));
           
        }
        int sum=0;
        for(int c: memo){
            sum+= c;
        }
        return sum;
    }
}
// @lc code=end

