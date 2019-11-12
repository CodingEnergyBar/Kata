/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    
    public int closestValue(TreeNode root, double target) {
        int[] closestValue = new int[]{root.val};
        // write your code here
        traversal(root, target, closestValue);
        return closestValue[0];
    }
    void traversal(TreeNode root, double target,  int[] res){
        if(root == null)
            return;
        if(root.val == target){
            res[0] = root.val;
            return;
        }
        else if(root.val > target){
            //  System.out.println("root.val " + root.val);
            if( Math.abs(res[0] - target) > Math.abs(root.val - target)){
                res[0] = root.val;
            }
              traversal(root.left, target, res);
        }else{
            // System.out.println("root.val " + root.val);
            if(Math.abs(res[0] - target) > Math.abs(root.val - target)){
                res[0] = root.val;
            }
             traversal(root.right, target, res);
        }
        
    }
}