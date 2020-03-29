/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);

    }

    boolean isValidBST(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null)
            return true;
        if (max != null && root.val >= max.val)
            return false;
        if (min != null && root.val <= min.val)
            return false;
        return isValidBST(root.left, root, min) && isValidBST(root.right, max, root);
    }
}
// @lc code=end
