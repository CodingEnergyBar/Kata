/*
 * @lc app=leetcode.cn id=112 lang=javascript
 *
 * [112] 路径总和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {boolean}
 */

 // 深度优先的标量鞋服而已
 /**
  * 
  * 时间复杂度 O(n)
  * 空间复杂度 函数调用堆栈  O(n) 树的高度 --> 最坏就是O(n)
  * 
  * global res = false
  * dfs 所有的的(root , val)
  * 嘎 res
  */


var hasPathSum = function (root, sum) {
    if (!root)
        return false;
    if (!root.left && !root.right && sum === root.val)
        return true;
    
    return hasPathSum(root.left, sum - root.val) ||
    hasPathSum(root.right, sum - root.val)
  

};
// @lc code=end

