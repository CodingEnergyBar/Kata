/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    // boolean result = false;
    int memo[];

    public boolean wordBreak(String s, List<String> wordDict) {
        // -1 0 1
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);

        return dfs(0, s, wordDict) == 1;

    }

    // [start...end)
    int dfs(int start, String s, List<String> wordDict) {

        if (start == s.length()) {
            return 1;
        }
        if (memo[start] != -1)
            return memo[start];
        int result = 0;
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))) {
                if (dfs(i, s, wordDict) == 1)
                    result = 1;
            }
        }
        memo[start] = result;
        return result;
    }
}
// @lc code=end
