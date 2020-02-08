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
    // public boolean isValidBST(TreeNode root) {
    // if (root == null)
    // return true;
    // System.out.println("hahah ");
    // if (root.left != null && root.left.val >= root.val)
    // return false;
    // if (root.right != null && root.right.val <= root.val)
    // return false;
    // return isValidSubBST(root.left, root.val, root.val) &&
    // isValidSubBST(root.right, root.val, root.val);

    // }

    // boolean isValidSubBST(TreeNode root, int min, int max) {
    // System.out.println("here");
    // if (root == null)
    // return true;
    // if (root.left != null && (root.left.val >= root.val || root.left.val <= min))
    // return false;
    // if (root.right != null && (root.right.val <= root.val || root.right.val >=
    // max))
    // return false;
    // boolean res = isValidSubBST(root.left, min, root.val) &&
    // isValidSubBST(root.right, root.val, max);
    // System.out.println("root val is " + root.val + " and \n res is :" + res);
    // return res;

    }

    // 拍平了
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if (root.val >= maxVal || root.val <= minVal)
            return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
// @lc code=end
