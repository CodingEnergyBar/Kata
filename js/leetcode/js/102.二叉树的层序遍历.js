/*
 * @lc app=leetcode.cn id=102 lang=javascript
 *
 * [102] 二叉树的层序遍历
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
 * @return {number[][]}
 */
var levelOrder = function (root) {
    let res = [];
    if (!root) return res;
    const queue = [root];
    while (queue.length) {
        let lSize = queue.length
        const level = []
        // for (let i = 0; i < lSize; i++) {
        while(lSize--){
            const cur = queue.shift();
            level.push(cur.val);
            const { left, right } = cur;
            if (left) queue.push(left);
            if (right) queue.push(right);
        }
        res.push(level);
    }
    return res;
};
/**
 * cengji 
 *  if(resp[level]) res[level] =  [cur.val]
 *   else res[level].push(cur.val)
 */
// @lc code=end

