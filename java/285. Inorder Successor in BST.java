/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return findInorderSuccessor(root, p, null);

    }

    TreeNode findInorderSuccessor(TreeNode root, TreeNode p, TreeNode lastRightParent) {
        if (root == null || p == null) {
            return null;
        }
        if (root.val == p.val) {
            if (p.right != null) {
                TreeNode cur = p.right;
                while (cur.left != null)
                    cur = cur.left;
                return cur;
            } else if (lastRightParent != null) {
                return lastRightParent;
            } else {
                return null;
            }
        }
        if (p.val > root.val) {
            // right
            return findInorderSuccessor(root.right, p, lastRightParent);
        } else {
            return findInorderSuccessor(root.left, p, root);
        }

    }
}
