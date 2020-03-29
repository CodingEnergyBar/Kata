import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null)
            return true;
        if (s == null)
            return false;
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);

    }

    public boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        if (a.val != b.val)
            return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}
// @lc code=end
