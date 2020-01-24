/*
 * @lc app=leetcode id=133 lang=javascript
 *
 * [133] Clone Graph
 */
/**
 * // Definition for a Node.
 * function Node(val,neighbors) {
 *    this.val = val;
 *    this.neighbors = neighbors;
 * };
 */
/**
 * @param {Node} node
 * @return {Node}
 */
/**
 * // Definition for a Node.
 * function Node(val,neighbors) {
 *    this.val = val;
 *    this.neighbors = neighbors;
 * };
 */

var cloneGraph = function(node) {


    let queue = [node];
    
    // put into visited before entering the queue
    let visited = new Set([node]);
    let hash = new Map();
    
    hash.set(node, new Node(node.val,[]));

    
    while(queue.length){
       
        let cur = queue.shift();

        for(let n of cur.neighbors){
            if(!visited.has(n)){
                queue.push(n);
                visited.add(n);
            }
            
            if(!hash.has(n)){
                hash.set(n, new Node(n.val, []));
            }
            // start to build edges
            nCopy = hash.get(n);
            
            hash.get(cur).neighbors.push(nCopy);
           
        }
    }
    return hash.get(node);
};


