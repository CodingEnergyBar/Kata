/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // k 分的归并算法
        int num = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];

            while (head != null) {
                num++;
                head = head.next;
            }
        }
        if (num == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(num, (a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            while (head != null) {
                pq.offer(head);
                head = head.next;
            }
        }

        ListNode head = pq.poll(), pre = head;

        for (int i = 0; i < num; i++) {
            ListNode cur = pq.poll();
            pre.next = cur;
            pre = cur;
        }
        return head;

    }

}
// @lc code=end
