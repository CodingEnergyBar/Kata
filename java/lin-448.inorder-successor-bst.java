public class Solution {
    /*
     * @param root: The root of the BST.
     * 
     * @param p: You need find the successor node of p.
     * 
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succesor = null;
        // write your code here
        // while(root.val != p.val){

        // if(root.val > p.val){
        // succesor = root;
        // root = root.left;
        // }else{
        // // root < p
        // root = root.right;
        // }

        // }
        // if(root.right != null){
        // root = root.right;
        // while(root != null){
        // succesor = root;
        // root = root.left;
        // }
        // }
        
        //!!!
        while (root != null) {

            if (root.val > p.val) {
                succesor = root;
                root = root.left;
            } else
                // root <= p
                root = root.right;
        }
        return succesor;
    }
}