package leetcode865;

import jdk.internal.net.http.common.Pair;

// @lc code=start

//Definition for a binary tree node.
//。如果最深节点只有一个，那么就返回该节点。
// 如果有两个最深节点，返回这两个节点的上一个公共节点，就是一棵树。

class Solution {

    TreeNode res;
    int depthmax = 0;
    int treeDepth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        treeDepth = getDepth(root);
        findDeepestNode(root);
        getDepth(root, Integer.MAX_VALUE);
        return res;
    }

    boolean findDeepestNode(TreeNode node){
        if(node)

    }
    // 保存了当前节点的深度和当前节点的最深子树节点。
    int getDepth(TreeNode node) {
        if(node == null)
            return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);

        // if(left==true && right==true){
        //     if(node.left != null && node.right != null){
        //         //要记录高度,
        //         if(depth > depthmax){
        //             depthmax = depth;
        //             this.res = node;
        //             return true;
        //         }
        //     }
        // }
        return Math.max(left, right) + 1;
    }
    // public static void main(String[] args) {
    //     new Solution.subtreeWithAllDeepest();
    // }
    // find the root is complete a null is complete tree
    // if leaf : largest depth, depth 
}
// @lc code=end

