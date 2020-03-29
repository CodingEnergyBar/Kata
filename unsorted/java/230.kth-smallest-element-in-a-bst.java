/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {

        List<TreeNode> array = getBSTArray(root);

    }
    
    List<TreeNode> getBSTArray(TreeNode root){
        if(root == null) return null;
        List<TreeNode>
    }
}
// @lc code=end
