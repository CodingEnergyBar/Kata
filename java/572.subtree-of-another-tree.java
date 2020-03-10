/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null)
            return true;
        if(s ==  null)
            return false;
        return isTheSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    boolean isTheSame(TreeNode a, TreeNode b){
        if(b == null && a == null)
            return true;
        if(b == null || a == null)
            return false;
        if(a.val != b.val)
            return false;
        return isTheSame(a.left, b.left) && isTheSame(a.right, b.right);
    }
}
// @lc code=end

