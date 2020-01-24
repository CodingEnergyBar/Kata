/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /*
     * @param root: the root of binary tree
     * 
     * @return: collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        Map<Integer, List> depthToNodes = new HashMap();
        dfs(root, depthToNodes);
        List<List<Integer>> res = new ArrayList();
        for (int i = 1; i < depthToNodes.size() + 1; i++) {
            res.add(depthToNodes.get(i));
        }
        return res;

    }

    int dfs(TreeNode root, Map<Integer, List> depthToNodes) {
        // return the max depth
        if (root == null) {
            // cannot have 0 in the depthToNodes
            return 0;
        }
        if (root.left == null && root.right == null) {
            depthToNodes.putIfAbsent(1, new ArrayList<Integer>());
            depthToNodes.get(1).add(root.val);
            return 1;
        }
        int cur = Math.max(dfs(root.left, depthToNodes), dfs(root.right, depthToNodes)) + 1;

        depthToNodes.putIfAbsent(cur, new ArrayList<Integer>());
        depthToNodes.get(cur).add(root.val);

        return cur;

    }
}