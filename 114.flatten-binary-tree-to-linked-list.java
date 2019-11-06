/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (44.06%)
 * Likes:    1765
 * Dislikes: 238
 * Total Accepted:    264K
 * Total Submissions: 597.6K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 
 * The flattened tree should look like:
 * 
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
 * 
 * 
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
/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        helper(root);

    }

    TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        // should be last of the tree node
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);

        if (leftLast != null) {
            // here is the start
            leftLast.right = root.right;
            // start
            root.right = root.left;
            root.left = null;
        }

        // else{
        // // leftLast == null
        // root.right = root.right
        // // leftLast = null...
        // root.left = null;
        // }

        if (rightLast != null) {
            return rightLast;
        }
        if (leftLast != null)
            return leftLast;

        return root;
    }
}
// @lc code=end

