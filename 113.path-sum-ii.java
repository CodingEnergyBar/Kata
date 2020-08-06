import java.util.*;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        searchSum(res, new ArrayList<Integer>(), root, sum);
        return res;
    }
    void searchSum(List<List<Integer>> res, List<Integer> path, TreeNode root, int rest){
        if(root == null)
            return;
        path.add(root.val);
        rest = rest - root.val;
        if(root.left == null && root.right == null){
            if(rest == 0){
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
                return;
            }
        }
        searchSum(res, path, root.left, rest);
        searchSum(res, path, root.right, rest);
        path.remove(path.size() - 1);
    }
}
// @lc code=end

