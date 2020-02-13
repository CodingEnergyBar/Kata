import java.util.Comparator;

/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start
class Solution {
    int[] memo;

    public int candy(int[] ratings) {
        // sum 从两面开始, 最两边的 只需要看一边
        // 总能找到个最小的, 先有个锚点

        memo = new int[ratings.length];
        Arrays.fill(memo, -1);

        for (int i = 0; i < ratings.length; i++) {
            if (!dependOnNeigbor(ratings, i, i - 1) && !dependOnNeigbor(ratings, i, i + 1)) {
                memo[i] = 1;
            }
        }

        int res = 0;
        for (int i = 0; i < ratings.length; i++) {
            res += candy(ratings, i);
        }
        return res;

    }

    int candy(int[] ratings, int index) {
        if (index < 0 || index >= ratings.length) {
            return 0;
        }
        if (memo[index] != -1)
            return memo[index];

        int res = 1;
        if (dependOnNeigbor(ratings, index, index - 1) && dependOnNeigbor(ratings, index, index + 1))
            res = Math.max(candy(ratings, index - 1), candy(ratings, index + 1)) + 1;
        else if (dependOnNeigbor(ratings, index, index - 1))
            res = candy(ratings, index - 1) + 1;
        else if (dependOnNeigbor(ratings, index, index + 1))
            res = candy(ratings, index + 1) + 1;

        memo[index] = res;
        return res;

    }

    boolean dependOnNeigbor(int[] ratings, int index, int neighbor) {
        if (neighbor < 0 || neighbor > ratings.length - 1)
            return false;
        if (ratings[index] > ratings[neighbor])
            return true;
        return false;

    }

}
// @lc code=end
