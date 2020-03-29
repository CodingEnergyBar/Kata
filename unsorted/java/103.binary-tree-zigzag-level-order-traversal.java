import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    boolean ltr = true;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        // corner case 要注意
        if (root == null)
            return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            // 用了 linkedinlist
            List<Integer> curLevel = new LinkedList<Integer>();

            for (int i = 0; i < cnt; i++) {

                TreeNode cur = queue.poll();
                if (ltr)
                    curLevel.add(cur.val);
                else
                    // 在一个位置加上 position , value
                    curLevel.add(0, cur.val);

                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }

            res.add(curLevel);
            ltr = !ltr;

        }
        return res;
    }
}
// @lc code=end
