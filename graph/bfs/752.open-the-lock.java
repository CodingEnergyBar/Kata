import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        int[] dirs = new int[] {1, 9};
        Set<String> visited = new HashSet();
        Set<String> deadendsSet = new HashSet<>();
        Collections.addAll(deadendsSet, deadends);
        if(deadendsSet.contains(target) || deadendsSet.contains("0000"))
            return -1;
        if(target.equals("0000"))
            return 0;

        Node node0 =  getNode("0000");
        node0.dis = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node0);
       
        visited.add(node0.toString());

        while(!queue.isEmpty()){
            Node cur = queue.remove();
            for(int i=0; i<4; i++){
                // i 
                int bit = cur.node[i];
                for(int d: dirs){
                    int nbit = (bit +  d) % 10;
                    Node nextNode =  new Node(cur);
                    nextNode.node[i] = nbit;
                    String nextString = nextNode.toString();
                    if(!visited.contains(nextString) && !deadendsSet.contains(nextString)){
                        nextNode.dis = cur.dis + 1;
                        queue.add(nextNode);
                        visited.add(nextNode.toString());
                        if(nextString.equals(target)){
                            return nextNode.dis;
                        }
                    }
                }
            }
        }
        return -1;
    }
    Node getNode(String s){
        Node n = new Node();
        for(int i=0; i<4; i++){
            //从string 到数字的方法
            n.node[i] = s.charAt(i) - '0';
        }
        return n;

    }
    class Node{
        public int[] node = new int[4];
        public int dis;
        Node(){

        }
        Node(Node cur) {
            for(int i=0; i< node.length; i++){
                node[i] = cur.node[i];
            }
        }


        public String toString(){
            StringBuilder s = new StringBuilder();
            for(int i=0; i< node.length; i++){
                s.append(node[i]);
            }
            return s.toString();
        }

    }
}
// @lc code=end

// public static void main(String[] args) {
// String[] deadends = {"0201","0101","0102","1212","2002"};
// String target = "0202";

// System.out.println(new Solution2().openLock(deadends, target));
// }
