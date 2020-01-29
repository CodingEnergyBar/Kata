import java.util.Map;

/*
 * @lc app=leetcode id=447 lang=java
 *
 * [447] Number of Boomerangs
 */

// @lc code=start
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        // record distance and freq

        for (int i = 0; i < points.length; i++) {
            int[] pi = points[i];
            // for each point get one record:
            Map<Integer, Integer> record = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int d = distance(points[j], points[i]);
                    record.put(d, record.getOrDefault(d, 0) + 1);
                }

            }

            for (Integer freq : record.values()) {
                if (freq >= 2) {
                    // 不是阶乘, 只有两个数
                    // res += getCombination(freq);
                    res += freq * (freq - 1);
                }
            }

        }

        return res;

    }

    int distance(int[] p1, int[] p2) {
        // 有可能越界
        // 点的范围是[-10000, 10000]之间 距离 最大 是 20000 * 20000 < 2 ˆ32 bit
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    int getCombination(int a) {
        int res = 1;
        while (a != 1) {
            res = res * a;
            a--;
        }
        return res;
    }
}
// @lc code=end
