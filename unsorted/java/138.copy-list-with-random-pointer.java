/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0), q = dummy;

        Node p = head;
        // original copy
        Map<Node, Node> hash = new HashMap<>();
        if (head == null)
            return null;

        while (p != null) {

            Node copy;
            if (hash.containsKey(p)) {
                copy = hash.get(p);
            } else {
                copy = new Node(p.val);
                hash.put(p, copy);
            }

            Node r = null;
            if (p.random != null) {

                if (hash.containsKey(p.random)) {
                    r = hash.get(p.random);
                } else {
                    Node newRandom = new Node(p.random.val);
                    hash.put(p.random, newRandom);
                    r = newRandom;
                }
            }
            copy.random = r;

            q.next = copy;
            q = q.next;
            p = p.next;

        }
        return dummy.next;

    }
}
// @lc code=end
