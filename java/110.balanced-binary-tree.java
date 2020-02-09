/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {

        return balancedTreeWithDepth(root) != -1;
    }

    // -1 no: [0..depth] yes
    int balancedTreeWithDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depthL = balancedTreeWithDepth(root.left);
        int depthR = balancedTreeWithDepth(root.right);
        if (depthL == -1 || depthR == -1)
            return -1;
        if (Math.abs(depthL - depthR) > 1)
            return -1;
        else
            return Math.max(depthL, depthR) + 1;
    }
}
// @lc code=end
