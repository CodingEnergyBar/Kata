/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        // List<String> res = new ArrayList<String>();
        if (root == null)
            return null;

        return addPath(root, new ArrayList<String>());

    }

    List<String> addPath(TreeNode root, List<String> paths) {
        List<String> res = new ArrayList<String>();
        for (String path : paths) {
            res.path
        }

    }
}
// @lc code=end
