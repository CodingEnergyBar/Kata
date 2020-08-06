/*
 * @lc app=leetcode id=563 lang=java
 *
 * [563] Binary Tree Tilt
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
    int tiltSum = 0;
    
    public int findTilt(TreeNode root){
        findSum(root);
        return tiltSum;
    }

    public int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);

        // int curTilt = 0, rightVal = 0, leftVal = 0;
        // if (root.right != null){
        //     rightVal = root.right.val;
        // } 
        // if (root.left != null){
        //     leftVal = root.left.val;
        // }
        tiltSum += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }

}
// @lc code=end

