/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        else {
            return isMirror(root.left, root.right);
        }
    }

    boolean isMirror(TreeNode a, TreeNode b) {
        // if (a == null && b == null)
        // return true;
        // if (a == null || b == null)
        // return false;
        if (a == null || b == null)
            return a == b;
        if (a.val != b.val)
            return false;
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}
// @lc code=end
