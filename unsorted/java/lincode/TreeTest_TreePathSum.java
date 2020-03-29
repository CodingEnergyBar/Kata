import java.util.ArrayList;
import java.util.List;

public class TreeTest_TreePathSum
{
    List result =  new ArrayList<List<Integer>>();

    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // write your code here
        // to root path
        ArrayList <Integer> buffer = new ArrayList<Integer>();
        helper(root, 0, new ArrayList<Integer>(), target);
        return result;
    }
    public void helper(TreeNode root, int level, ArrayList<Integer> arrayPreLevel, int target){
        if(root == null)
            return;

        arrayPreLevel.add(root.val);

        int pathSum = 0;
        List curPath = new ArrayList<Integer>();
        int distanceToTarget = target;
        for(int i= level; i>=0; i--){
            curPath.add(arrayPreLevel.get(i));
            distanceToTarget -=  arrayPreLevel.get(i);
            if (distanceToTarget == 0){
                result.add(curPath);
                break;
            }
        }


        helper(root.left, level+1, arrayPreLevel, target);
        helper(root.right, level+1, arrayPreLevel, target);
        arrayPreLevel.remove(arrayPreLevel.size()-1);

    }
    public static void main(String[] args) {
        Integer[] data = {1,2,3,4,null,2};
        TreeNode[] nodes = new TreeNode[data.length];
        //构建tree
        for(int i=0; i < data.length; i++){
            nodes[i] = data[i]==null ? null : new TreeNode(data[i].intValue());
        }

        Tree tree = new Tree();
        tree.createTreeAsLevel(nodes);
        // 创建tree
        TreeTest_TreePathSum tt = new TreeTest_TreePathSum();

        List res = tt.binaryTreePathSum2(nodes[0], 6);
    }
}