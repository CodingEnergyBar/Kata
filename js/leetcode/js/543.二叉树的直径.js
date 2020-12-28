/*
 * @lc app=leetcode.cn id=543 lang=javascript
 *
 * [543] 二叉树的直径
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
 * @return {number}
 */
var diameterOfBinaryTree = function (root) {
    if (root === null)
        return 0;
    return findDiameterAndMaxDepth(root)[0]

    function findDiameterAndMaxDepth(root) {
        if (root === null)
            return [0, 0];
        const [dL, maxDepthL] = findDiameterAndMaxDepth(root.left)
        const [dR, maxDepthR] = findDiameterAndMaxDepth(root.right)

        const maxDepthCur = Math.max(maxDepthL, maxDepthR) + 1;
        let dCur = Math.max(dL, dR)
        dCur = Math.max(dCur, maxDepthL + maxDepthR)
        return [dCur, maxDepthCur]
    }

};
// @lc code=end

