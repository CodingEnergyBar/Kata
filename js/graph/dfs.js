const graph = require('./graph');

const visited = new Set();
const dfs = (n) => {
    console.log(n); // 访问这个节点
    visited.add(n);
    graph[n].forEach(c => { // graph[n] 是找这个children
        if(!visited.has(c)){
            dfs(c);
        }
    });
};

dfs(2);