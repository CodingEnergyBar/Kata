import java.util.*;

public class TreeTest
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null) return null;
        if(root == A || root == B) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if(left != null && right != null) return root;
        if(left != null ) return left;
        if(right != null) return right;
        return null;
    }
   
    public static void main(String[] args) {
        Integer[] data = {4,3,7,null,null,5,6};
        TreeNode[] nodes = new TreeNode[data.length];
        //构建tree
        for(int i=0; i < data.length; i++){
            nodes[i] = data[i]==null ? null : new TreeNode(data[i].intValue());
        }

        Tree tree = new Tree();
        tree.createTreeAsLevel(nodes);
        // 创建tree
        TreeTest tt = new TreeTest();
        TreeNode res = tt.lowestCommonAncestor(nodes[0], nodes[5], nodes[6]);
    }
}