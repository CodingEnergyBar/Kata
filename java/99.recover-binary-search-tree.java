/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    public void recoverTree(TreeNode root) {
        List<TreeNode> record = new ArrayList<>();
        inOrderTraverse(root, record); 
        // find two special points
        List<TreeNode> specials = new ArrayList<>();
        int len = record.size();

        
        for(int i=0; i<len; i++){
            if(i == 0 && record.get(i) > record.get(i+1)){
                specials.add(record.get(i));
                i++;
                continue;
            }
            
            if(i == len-1 && record.get(i-1) > record.get(i)){
                specials.add(record.get(i));
                continue;
            }

            if(record.get(i) < record.get(i-1)){
                specials.add(record.get(i));
            }
        }
        System.out.println(specials.toString());
        swap(specials.get(0), specials.get(1));
        
        

        
    }

  
    void inOrderTraverse(TreeNode root, List<TreeNode> record){
        if(root.left!=null){
            inOrderTraverse(root.left, record);
        }
        if(root!=null)
            record.add(root);
        if(root.right != null){
            inOrderTraverse(root.right, record);
        }
    }
}
// @lc code=end

