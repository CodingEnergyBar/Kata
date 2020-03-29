/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {

            if (cur.next.val == val) {
                cur.next = cur.next.next;
                // 不再往下移动
            } else // !!! important
                cur = cur.next;
        }
        return dummy.next;
    }
}
// @lc code=end
