/**
 * Definition for Directed graph. class DirectedGraphNode { int label;
 * ArrayList<DirectedGraphNode> neighbors; DirectedGraphNode(int x) { label = x;
 * neighbors = new ArrayList<DirectedGraphNode>(); } };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * 
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        HashMap<DirectedGraphNode, Integer> indegree = new HashMap();
        for (DirectedGraphNode node : graph) {
            // Make sure all the nodes are in the graph
            indegree.putIfAbsent(node, 0);
            for (DirectedGraphNode neighbor : node.neighbors) {

                indegree.putIfAbsent(neighbor, 0);
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        ArrayList<DirectedGraphNode> order = new ArrayList();
        Queue<DirectedGraphNode> queue = new LinkedList();
        for (Map.Entry<DirectedGraphNode, Integer> combo : indegree.entrySet()) {
            if (combo.getValue() == 0) {
                order.add(combo.getKey());
                queue.add(combo.getKey());
            }
        }
        // level traverse
        while (!queue.isEmpty()) {
            DirectedGraphNode cur = queue.poll();
            for (DirectedGraphNode neighbor : cur.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                    order.add(neighbor);
                }
            }
        }
        return order;
    }
}