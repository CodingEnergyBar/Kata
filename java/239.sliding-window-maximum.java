/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // size <= k
        Deque<Integer> q = new LinkedList<>();
        //intialize
        for(int i=0; i< k; i++){
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.pollLast();
            }
            q.offerLast(i);
        }
        if(nums.length == 0 || nums.length < k){
            return new int[0];
        }
        // if k == 1
        int res[] = new int[nums.length - k + 1];
        res[0] = nums[q.peekFirst()];
        // System.out.println(q.toString());
        
        
        for(int i=1; i<nums.length - k + 1; i++){
            //i
            int tail = i + k - 1;
            //不是 size 因为 size 可能温衡, 是角标
            while(!q.isEmpty() && q.peekFirst() + k <= tail){
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[tail]){
                q.pollLast();
            }
            q.offerLast(tail);
            
            // System.out.println(q.toString());
            res[i] = nums[q.peekFirst()];
        }
        return res;
        
    }
}
// @lc code=end

