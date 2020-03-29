/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<TreeNode, Integer>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> cur = queue.poll();

            TreeNode node = cur.getKey();
            Integer level = cur.getValue();

            if (level == res.size())
                res.add(new ArrayList<Integer>());
            res.get(level).add(node.val);
            if (node.left != null)
                queue.offer(new Pair<TreeNode, Integer>(node.left, level + 1));
            if (node.right != null)
                queue.offer(new Pair<TreeNode, Integer>(node.right, level + 1));
        }
        return res;

    }
}
// @lc code=end
