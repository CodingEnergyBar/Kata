/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    // bit : 个位到高位
    // carry
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         int carry = 0;
         ListNode dummy = new ListNode(0);
         ListNode head = dummy;
         while(l1 != null && l2 != null){
             int cur = carry + l1.val + l2.val;
             carry = cur / 10;
             cur =  cur % 10;
             head.next = new ListNode(cur);
             head = head.next;
             
             l1= l1.next;
             l2 = l2.next;
             
         }
         while(l1 != null){
            int cur = carry + l1.val;
             carry = cur / 10;
             cur =  cur % 10;

             head.next = new ListNode(cur);
             head = head.next;
             l1 = l1.next;
         }

         while(l2 != null){
            int cur = carry + l2.val;
             carry = cur / 10;
             cur =  cur % 10;

             head.next = new ListNode(cur);
             head = head.next;
             l2 = l2.next;
         }
         if(carry != 0){
             head.next = new ListNode(carry);
         }
         return dummy.next;
    }
}
// @lc code=end

