/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return buildTree(nums, 0, nums.length-1);
        
    }
    //[start..end]
    TreeNode buildTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left =  buildTree(nums, start, mid-1);
        root.right =  buildTree(nums, mid+1, end);
        return root;
    }
}
// @lc code=end

