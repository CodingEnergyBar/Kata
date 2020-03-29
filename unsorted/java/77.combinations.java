/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(0, k, 1, n, new ArrayList<Integer>());
        return res;

    }

    void dfs(int start, int len, int min, int max, List<Integer> path) {
        if (start == len) {
            res.add(new ArrayList<Integer>(path));
        }
        for (int cur = min; cur <= max; cur++) {
            path.add(cur);
            dfs(start + 1, len, cur + 1, max, path);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

