import java.util.*;
public class binaryTreePathSum_TreeTest
{
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> binaryTreePathSum(TreeNode root,  int target){
        // write your code here
        if(root == null){
            return null;
        }

        helper(root, target, null, 0);
        return result;
    }
    void helper(TreeNode root, int target, ArrayList<Integer> path, int pathSum){

        if(root == null){
            return;
        }

        int curPathSum = pathSum + root.val;

        ArrayList<Integer> curPath;
        if(path == null){
            curPath  = new ArrayList<Integer>(root.val);
        }else{
            curPath =  new ArrayList<Integer>(path);
            curPath.add(root.val);
        }


        if(curPathSum == target){
            result.add(curPath);
        }

        helper(root.left, target, curPath, curPathSum);
        helper(root.right, target, curPath, curPathSum);

    }
    public static void main(String[] args) {
        Integer[] data = {1,2,4,2,3};
        TreeNode[] nodes = new TreeNode[data.length];
        //构建tree
        for(int i=0; i < data.length; i++){
            nodes[i] = data[i]==null ? null : new TreeNode(data[i].intValue());
        }

        Tree tree = new Tree();
        tree.createTreeAsLevel(nodes);
        // 创建tree
        binaryTreePathSum_TreeTest tt = new binaryTreePathSum_TreeTest();

        tt.binaryTreePathSum(nodes[0], 5);
    }
}