import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;
    int N;
    int[] nums;
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        N = nums.length;
        visited = new boolean[N];
        this.nums = nums;
        dfs(new ArrayList<>());
        return res;
        
    }
    void dfs(List<Integer> path){
        if(path.size() == N){
            res.add(new ArrayList<>(path));
            return;
        }
        //顺序是 count 的 --> 所以要有 visited
        for(int i= 0; i < N; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            path.add(nums[i]);
            dfs(path);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }
}
// @lc code=end

