/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxInclude(root);
        return res;
    }
    public int maxInclude(TreeNode cur) {
        if(cur == null)
            return 0;
        int left = maxInclude( cur.left);
        int right = maxInclude( cur.right);
        int maxFromChildren =  Math.max(left, right);
        int max = Integer.MIN_VALUE;
        
        res = Math.max(res, cur.val);
        res = Math.max(res, cur.val + left);
        res = Math.max(res, cur.val + left + right);
        res = Math.max(res, cur.val + right);

        // searchMaxPath(TreeNode root)
        int returnMax = cur.val;
        if(left > right && left > 0)
            returnMax += left;
        if(right > left && right > 0)
            returnMax += right;
        return returnMax;
    }
}
// @lc code=end

