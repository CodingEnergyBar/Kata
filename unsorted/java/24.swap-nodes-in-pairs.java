/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, cur = head;
        while (pre != null && cur != null) {
            if (cur.next == null)
                break;
            ListNode cur2 = cur.next, next = cur2.next;
            pre.next = cur2;
            cur2.next = cur;
            cur.next = next;

            pre = cur;
            cur = next;
        }
        return dummy.next;

    }
}
// @lc code=end
