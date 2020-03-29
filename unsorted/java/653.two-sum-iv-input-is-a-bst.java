import java.util.ArrayList;

/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
 *
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 * algorithms
 * Easy (53.42%)
 * Likes:    1034
 * Dislikes: 117
 * Total Accepted:    106.8K
 * Total Submissions: 199.4K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n9'
 *
 * Given a Binary Search Tree and a target number, return true if there exist
 * two elements in the BST such that their sum is equal to the given target.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 * 
 * Target = 9
 * 
 * Output: True
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 * 
 * Target = 28
 * 
 * Output: False
 * 
 * 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList();
        getInOrderTraverse(root, res);

        // int[] arr = Arrays.asList(res, new int[res.size()]);
        int[] arr = res.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == k)
                return true;
            else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                left++;
            }
        }
        return false;

    }

    void getInOrderTraverse(TreeNode root, ArrayList<Integer> res) {
        if(root == null)
            return;
        getInOrderTraverse(root.left, res);
        res.add(root.val);
        getInOrderTraverse(root.right, res);
    }
}
// @lc code=end
