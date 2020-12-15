/*
 * @lc app=leetcode.cn id=94 lang=javascript
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function (root) {
    // left root right
    const res = [];
    if (!root) return res;
    let p = root;
    const stack = [];
    while (p || stack.length) {
    
        // while (p.left != null) {
        while (p) {
            stack.push(p);
            p = p.left;
        } // left => null
        // const n = stack.pop()
        // res.push(n.val);
        // p = n.right; // 新的右子树做同样的操作, 新的右子树也可能是null
        p = stack.pop()
        res.push(p.val);
        // 这里是不对的, 需要合一下
            // if (p.right) {
            //     p = p.right;
            // } else {
            //     p =  stack.pop()
            // }    
    
    }
    return res;
    
};
// @lc code=end;

