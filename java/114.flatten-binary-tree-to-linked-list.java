/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
    public TreeNode flatten(TreeNode root) {
        if(root == null)
            return null;
            // return the last node of right 
        TreeNode leftLast = flatten(root.left);
        TreeNode rightLast = flatten(root.right);


        TreeNode returnNode = root;
       
        if(leftLast != null){
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
            returnNode = leftLast;
        }
        if(rightLast != null)
            returnNode = rightLast;
        return returnNode;
    }
}
// @lc code=end

