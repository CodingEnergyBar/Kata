const graph = require('./graph');

const visited = new Set();
const q = [2];
visited.add(2);
while (q.length) {
    const n = q.shift();
    console.log(n);
    graph[n].forEach(c => {
        if (!visited.has(c)) {
            q.push(c);
            visited.add(c);
        }
    });
}
// 有漏洞: 访问过节点 但是还有 已经在队列里面 但还没有在visited里面的元素
// 放进队列的时机 如果在出队, visited就没有限制住: 主要是