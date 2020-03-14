import java.util.PriorityQueue;
import jdk.javadoc.internal.doclets.toolkit.util.Utils.Pair;


/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (b.getValue() != a.getValue()) {
                return b.getValue() - a.getValue();
            } else
                return a.getKey() - b.getKey();
        });
        int[] res = new int[nums.length - k + 1];
        if (nums.length == 0 || nums.length < k)
            return new int[0];

        // initialize
        for (int i = 0; i < k; i++) {
            pq.offer(new Pair<Integer, Integer>(i, nums[i]));
        }
        res[0] = pq.peek().getValue();

        for (int i = 1; i < nums.length - k + 1; i++) {

            pq.offer(new Pair<Integer, Integer>(i + k - 1, nums[i + k - 1]));
            Pair<Integer, Integer> curMax = pq.peek();
            // System.out.println(pq.toString());
            while (curMax.getKey() < i) {
                pq.poll();
                curMax = pq.peek();
            }

            res[i] = curMax.getValue();

        }
        return res;
    }
}

// @lc code=end

