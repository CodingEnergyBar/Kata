/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /*
     * @param root: The root of the binary tree.
     * 
     * @param A: A TreeNode
     * 
     * @param B: A TreeNode
     * 
     * @return: Return the LCA of the two nodes.
     */

    class ReturnType {
        ReturnType(boolean a, boolean b, TreeNode ancester) {
            this.hasA = a;
            this.hasB = b;
            this.ancester = ancester;

        }

        boolean hasA;
        boolean hasB;
        TreeNode ancester;
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ReturnType res = helper(root, A, B);
        if (res.hasA != true || res.hasB != true)
            return null;
        return helper(root, A, B).ancester;
    }

    ReturnType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ReturnType(false, false, null);
        }
        ReturnType left = helper(root.left, A, B);
        ReturnType right = helper(root.right, A, B);

        boolean hasA = left.hasA || right.hasA || root == A;
        boolean hasB = left.hasB || right.hasB || root == B;

        // Discuss according to roots.
        if (root == A || root == B) {
            return new ReturnType(hasA, hasB, root);
        }
        //
        if (left.ancester != null && right.ancester != null) {
            return new ReturnType(hasA, hasB, root);
        }
        if (left.ancester == null)
            return new ReturnType(hasA, hasB, right.ancester);

        return new ReturnType(hasA, hasB, left.ancester);

    }

    boolean getCommonResult(ReturnType res) {
        if (res.hasA == true && res.hasB == true) {
            return true;
        }
        return false;
    }
}