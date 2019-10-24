public class Solution {
    /**
     * @param num:    a string contains only digits 0-9
     * @param target: An integer
     * @return: return all possibilities
     */
    public List<String> addOperators(String num, int target) {
        // write your code here
        List<String> res = new ArrayList();
        dfs(num, 0, 0, 0, target, "", res);
        return res;

    }

    void dfs(String num, int start, long sum, long lastF, int target, String path, List<String> res) {
        if (start == num.length()) {
            if (target == sum) {
                res.add(path);
            }
            return;
        }

        for (int i = start; i < num.length(); i++) {
            String curStr = num.substring(start, i + 1);
            // here is parseLong
            long cur = Long.parseLong(curStr);

            if (start == 0) {
                // i+1 instead of i
                dfs(num, i + 1, sum + cur, cur, target, path + curStr, res);
            } else {
                // +
                dfs(num, i + 1, sum + cur, cur, target, path + "+" + curStr, res);
                // -
                dfs(num, i + 1, sum - cur, -cur, target, path + "-" + curStr, res);
                // *
                dfs(num, i + 1, sum - lastF + lastF * cur, lastF * cur, target, path + "*" + curStr, res);
            }
            if (cur == 0) {
                break;
            }
        }
    }
}