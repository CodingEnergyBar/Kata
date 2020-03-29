/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 *
 * https://leetcode.com/problems/expression-add-operators/description/
 *
 * algorithms
 * Hard (33.69%)
 * Likes:    844
 * Dislikes: 120
 * Total Accepted:    79.7K
 * Total Submissions: 235.1K
 * Testcase Example:  '"123"\n6'
 *
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 * 
 * Example 1:
 * 
 * 
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"] 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * 
 * Example 3:
 * 
 * 
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * 
 * Example 4:
 * 
 * 
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: num = "3456237490", target = 9191
 * Output: []
 * 
 * 
 */

import java.util.*;
// @lc code=start

class Solution {
    int target;

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        this.target = target;
        dfs(0, 0, 0, "", num, res);
        return res;

    }

    void dfs(int start, long lastFactor, long sum, String path, String num, List<String> res) {
        if (start == num.length()) {
            if (sum == this.target)
                res.add(path);
            return;
        }
        // the case for 1 * 0 + 5 is okay
        // could start with 0
        // if(num.charAt(start) == '0')
        // return;

        for (int i = start; i < num.length(); i++) {

            String curFactor = num.substring(start, i + 1);
            // parselong is also a tricky thing
            long cur = Long.parseLong(curFactor);

            // the problem is the next factor 1 * 05
            // if(cur == 0) it is okay to have the one round dfs 0 * + -
            // but it is not okay to have 05 / 056.. for the next round parameters

            if (start == 0) {
                // the first position is by default +
                dfs(i + 1, cur, sum + cur, "" + curFactor, num, res);
            } else {
                // start is others, is a different branch
                // you also need to add signs to lastFactor
                dfs(i + 1, cur, sum + cur, path + "+" + curFactor, num, res);
                dfs(i + 1, -cur, sum - cur, path + "-" + curFactor, num, res);
                // last factor is lastFactor * cur
                dfs(i + 1, lastFactor * cur, sum - lastFactor + lastFactor * cur, path + "*" + curFactor, num, res);
            }
            if (cur == 0) {
                break;
                // break 05 / 056...
            }

        }
    }
}
// @lc code=end
