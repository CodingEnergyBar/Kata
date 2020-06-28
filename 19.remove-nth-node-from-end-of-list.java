/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode dummy = new ListNode();
    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.dummy.next = head;
        ListNode p = this.dummy;
        ListNode end = getEnd(this.dummy, n);
        // if(end == null)
        // return null;
        while (end.next != null) {
            p = p.next;
            end = end.next;
        }
        p.next = p.next.next;
        return this.dummy.next;
    }

    ListNode getEnd(ListNode node, int n) {
        for (int i = 0; i < n; i++) {
            if (node.next == null)
                return null;
            node = node.next;
        }
        return node;
    }
}
// @lc code=end

