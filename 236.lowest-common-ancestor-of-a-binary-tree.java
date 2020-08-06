/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        TreeNode leftSearchAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSearchAncestor = lowestCommonAncestor(root.right, p, q);
        if((leftSearchAncestor != null && rightSearchAncestor != null) || root == p || root == q)
            return root;
        if(leftSearchAncestor != null)
            return leftSearchAncestor;
        if(rightSearchAncestor!= null)
            return rightSearchAncestor;
        return null;
        
    }
}
// @lc code=end

