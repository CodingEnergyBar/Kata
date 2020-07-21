import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    List<Integer> inOrderList = new ArrayList<>();
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return inOrderList.get(k-1);
    }
    void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        inOrderList.add(root.val);
        if(inOrderList.size() == k)
            return;
        inOrder(root.right);

    }
}
// @lc code=end

