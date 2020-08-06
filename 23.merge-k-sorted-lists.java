/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((l1, l2)->(l1.val-l2.val));
        ListNode dummy = new ListNode(), p = dummy;
        for(ListNode head: lists) 
            if(head != null) 
                queue.add(head);
        while(!queue.isEmpty()){
            ListNode cur = queue.poll();
            if(cur != null){
                p.next = cur;
                p = p.next;
                if(cur.next != null)
                    queue.add(cur.next);
            }
        }
        p.next = null;
        return dummy.next;
        
    }
}
// @lc code=end

