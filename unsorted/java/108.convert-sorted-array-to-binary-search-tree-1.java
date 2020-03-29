/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    TreeNode buildTreeNode(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = buildTreeNode(nums, start, mid - 1);
        cur.right = buildTreeNode(nums, mid + 1, end);
        return cur;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTreeNode(nums, 0, nums.length - 1);

    }
}
// @lc code=end
