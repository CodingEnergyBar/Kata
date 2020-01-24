/*
 * @lc app=leetcode id=617 lang=java
 *
 * [617] Merge Two Binary Trees
 *
 * https://leetcode.com/problems/merge-two-binary-trees/description/
 *
 * algorithms
 * Easy (71.25%)
 * Likes:    2132
 * Dislikes: 146
 * Total Accepted:    218.5K
 * Total Submissions: 305.5K
 * Testcase Example:  '[1,3,2,5]\n[2,1,3,null,4,null,7]'
 *
 * Given two binary trees and imagine that when you put one of them to cover
 * the other, some nodes of the two trees are overlapped while the others are
 * not.
 * 
 * You need to merge them into a new binary tree. The merge rule is that if two
 * nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * Tree 1                     Tree 2                  
 * ⁠         1                         2                             
 * ⁠        / \                       / \                            
 * ⁠       3   2                     1   3                        
 * ⁠      /                           \   \                      
 * ⁠     5                             4   7                  
 * Output: 
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \ 
 * 5   4   7
 * 
 * 
 * 
 * 
 * Note: The merging process must start from the root nodes of both trees.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
    /**
     * @param t1: the root of the first tree
     * @param t2: the root of the second tree
     * @return: the new binary tree after merge
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // Write your code here
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        TreeNode left = mergeTrees(t1.left, t2.left);

        TreeNode right = mergeTrees(t1.right, t2.right);

        t1.val = t1.val + t2.val;
        t1.left = left;
        t1.right = right;

        return t1;
    }
}
// @lc code=end
