/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: root of the given tree
     * @return: whether it is a mirror of itself
     */
    // const NULL = Integer.MAX_VALUE;
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        // null is -MAX_VALUE
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            // current level
            TreeNode[] level = new TreeNode[size];
            for (int i = 0; i < size; i++) {
                level[i] = queue.poll();
                if (level[i] != null) {
                    queue.add(level[i].left);
                    queue.add(level[i].right);
                }
            }
            if (isSymmetric(level))
                continue;
            else
                return false;
        }
        return true;

    }

    boolean isSymmetric(TreeNode[] level) {
        for (int i = 0; i < level.length; i++) {
            if (level[i] != null && level[level.length - i - 1] != null) {
                if (level[i].val != level[level.length - i - 1].val)
                    return false;
            } else {
                if (level[i] != level[level.length - i - 1])
                    return false;
            }
        }
        return true;

    }
}