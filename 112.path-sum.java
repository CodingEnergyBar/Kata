import sun.font.TrueTypeGlyphMapper;

/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum){
        if(root == null) 
            return false;
        return helper(root, sum);
    }
    boolean helper(TreeNode root, int sum){
        if (root.left == null && root.right == null) {
            if (sum == root.val)
                return true;
            else
                return false;
        }
        boolean left=false, right= false;
        if(root.left != null) left = helper(root.left, sum - root.val);
        if(root.right !=null) right = helper(root.right, sum - root.val);
        return left || right;
    }
}
/* shorter version -->  root == null reutrn false
         1
        /
       2
    
       null

         1
        / \
       2   2
*/
// public boolean hasPathSum(TreeNode root, int sum) {
//     // recursion method
//     if (root == null) return false;
//     if (root.left == null && root.right == null && root.val == sum) return true;
//     return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
// }
// @lc code=end

