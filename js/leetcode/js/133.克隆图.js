/*
 * @lc app=leetcode.cn id=133 lang=javascript
 *
 * [133] 克隆图
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {Node} node
 * @return {Node}
 */
// var cloneGraph = function (node) {
//     if (!node)
//         return null;
//     // 图的遍历要有visited flag
//     // 把set 转换成map
//     const visited = new Set();
//     function dfs(node) {
//         visited.add(node)
//         console.log("visited", visited)
//         console.log("node", node)
//         // r
//         const res = new Node(node.val)
//         for (const neighbor of node.neighbors) {
//             if (!visited.has(neighbor))
//                 res.neighbors.push(dfs(neighbor))
//         }
//         return res;
//     }
//     return dfs(node)
// };

// //  广度也可以
// var cloneGraph = function (node) {
//     if (!node)
//         return null;
//     // 图的遍历要有visited flag
//     // 把set 转换成map
//     const visited = new Map();
//     function dfs(n) {
//         const copy = new Node(n.val)
//         visited.set(n, copy);
//         for (const neighbor of n.neighbors) {
//             if (!visited.has(neighbor))
//                 dfs(neighbor)
//             copy.neighbors.push(visited.get(neighbor))
//         }
//     }



//     dfs(node)
//     return visited.get(node)
// };
//  广度也可以
var cloneGraph = function (node) {
    if (!node)
        return null;
    // 图的遍历要有visited flag
    // 把set 转换成map
    const visited = new Map();
    visited.set(node, new Node(node.val))

    function bfs(n) {
        const queue = [n];
        while (queue.length) {
            const cur = queue.shift();
            // visited.set(cur, copy); //!!! 入队的时候标记 而不是出队的
            for (const neighbor of cur.neighbors) {
                if (!visited.has(neighbor)) {
                    queue.push(neighbor);
                    const copy = new Node(neighbor.val);
                    visited.set(neighbor, copy) // 再往下深一层
                }
                visited.get(cur).neighbors.push(visited.get(neighbor))
            }
        }
    }


    bfs(node)
    return visited.get(node)
};
// @lc code=end

