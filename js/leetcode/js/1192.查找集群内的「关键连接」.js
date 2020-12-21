/*
 * @lc app=leetcode.cn id=1192 lang=javascript
 *
 * [1192] 查找集群内的「关键连接」
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} connections
 * @return {number[][]}
 */
var criticalConnections = function (n, connections) {
    const graph = buildGraph(connections);
    // console.log('graph', graph)
    const res = [];
    const ord = Array(n);
    const low = Array(n);
    let cnt = 0;
    const visited = Array(n).fill(false)
    for (let i = 0; i < n; i++) {
        if (!visited[i]) {
            cnt = 0;
            // visited[i] = true;
            ord[i] = 0;
            low[i] = 0;

            dfs(i, i);
        }
    }
    return res;

    function dfs(cur, parent) {
        visited[cur] = true;
        for (const neighbor of graph.get(cur)) {
            if (!visited[neighbor]) {
                // if (neighbor === parent)
                //     continue;
                ord[neighbor] = ++cnt;
                low[neighbor] = ord[neighbor];
                dfs(neighbor, cur)
                low[cur] = Math.min(low[neighbor], low[cur]);
                if (low[neighbor] > ord[cur])
                    res.push([cur, neighbor])
                // console.log('cur', cur)
                // console.log('low', low)
                // console.log('ord', ord)

            } else if (neighbor !== parent) {// find the connection 
                // low[cur] = Math.min(low[neighbor], low[cur]);
                low[cur] = Math.min(low[neighbor], low[cur]);

                if (low[neighbor] > ord[cur])
                    res.push([cur, neighbor])
            }
        }

    }

};

function buildGraph(edges) {
    const g = new Map()// 0: 1, 2, 3
    for (const edge of edges) {
        const [v, w] = edge;
        if (!g.has(v)) g.set(v, [])
        if (!g.has(w)) g.set(w, [])
        g.get(v).push(w)
        g.get(w).push(v)
    }
    return g;
}

const connections = [[0, 1], [1, 2], [2, 0], [1, 3]];

// console.log(criticalConnections(4, connections))

// @lc code=end

