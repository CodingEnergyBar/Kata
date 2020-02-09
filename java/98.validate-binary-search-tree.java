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
        // min max
        return isValidBST(root, null, null);

    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && min >= root.val) || (max != null && max <= root.val)) {
            // System.out.println("heree");
            return false;
        }
        return (isValidBST(root.left, min, root.val)) && isValidBST(root.right, root.val, max);
    }
}
// @lc code=end
