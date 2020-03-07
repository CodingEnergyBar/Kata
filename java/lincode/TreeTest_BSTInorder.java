import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTest_BSTInorder
{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cand = null;

        while (root != null) {
            if (p.val >= root.val) {
                //go bigger
                root = root.right;
            } else {
                cand = root;
                root = root.left;
            }
        }

        return cand;
    }
    public static void main(String[] args) {
        Integer[] data = {2,1,3,-1,0};
        TreeNode[] nodes = new TreeNode[data.length];
        //构建tree
        for(int i=0; i < data.length; i++){
            nodes[i] = data[i]==null ? null : new TreeNode(data[i].intValue());
        }

        Tree tree = new Tree();
        tree.createTreeAsLevel(nodes);
        // 创建tree
        TreeTest_BSTInorder tt = new TreeTest_BSTInorder();

        tt.inorderSuccessor(nodes[0], nodes[1]);
    }
}