/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode i = headA, j = headB;
        Set<ListNode> setA = new HashSet<>();
        for (; i != null; i = i.next) {
            setA.add(i);
            if (i == j)
                return i;
        }
        for (; j != null; j = j.next) {
            if (setA.contains(j))
                return j;
        }
        return null;

    }

    ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }

        return pre;
    }
}
// @lc code=end
