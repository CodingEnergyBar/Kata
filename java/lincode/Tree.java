
public class Tree {

    public void createTreeAsLevel(TreeNode[] nodes){
        int n = nodes.length;
        int flag = 0;//按层构造时一个值为null，则它之后的孩子序号应该相应减2flag
        for(int i=0; 2*i+1 < n-1; i++){
            if(nodes[i] != null){
                nodes[i].left = nodes[2*i+1-2*flag];
                nodes[i].right = 2*i+2 == n ? null : nodes[2*i+2-2*flag];
            }else{
                flag++;
            }
        }
        System.out.println(nodes);
    }
}