import java.util.Arrays;
import java.util.Queue;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return "[]";
        // layer traverse
        q.offer(root);
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (res.length() != 0) {
                    res.append(',');
                }
                if (cur != null) {
                    res.append(cur.val);
                    q.offer(cur.left);
                    q.offer(cur.right);
                } else
                    res.append("null");
            }
        }

        return '[' + res.toString() + ']';

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 2)
            return null;
        String content = data.substring(1, data.length() - 1);
        System.out.println("hehe");
        String[] nums = content.split(",");

        TreeNode root = strToTreeNode(nums[0]);
        System.out.println("hehe2");
        TreeNode[] treeNodes = new TreeNode[nums.length];
        System.out.println(Arrays.toString(nums));
        treeNodes[0] = root;

        for (int i = 1; i < nums.length; i++) {
            System.out.println("hehe" + i);
            TreeNode parent = treeNodes[((1 + i) / 2 - 1)];
            TreeNode cur = strToTreeNode(nums[i]);
            if (i % 2 == 1) {
                // left
                parent.left = cur;

            } else {
                parent.right = cur;
            }
            treeNodes[i] = cur;
        }
        return root;

    }

    TreeNode strToTreeNode(String s) {
        if (s.equals("null")) {
            return null;
        }
        // string.valueOf 是为了从 char/integer 转成 string 的
        return new TreeNode(Integer.parseInt(s));

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end
