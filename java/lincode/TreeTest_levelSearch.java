import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class TreeTest_levelSearch
{
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList result = new ArrayList();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //only operate a the head
        queue.offer(root);

        while(!queue.isEmpty()){
            // buffer
            ArrayList<Integer> level = new ArrayList<Integer>();

            int size = queue.size();
            for(int i=0; i<size;i++){
                TreeNode head = queue.poll();
                // not # but size
                level.add(head.val);
                if(head.left != null)
                    queue.offer(head.left);
                if(head.right != null)
                    queue.offer(head.right);
            }
            result.add(level);
        }
        return result;
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
        TreeTest_levelSearch tt = new TreeTest_levelSearch();

        tt.levelOrder(nodes[0]);
    }
}