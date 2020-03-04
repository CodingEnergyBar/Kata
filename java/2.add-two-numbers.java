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
         
         // 可以这么写啊
         ListNode p, dummy = new ListNode(0);
         p = dummy;

         while(l1 != null || l2 != null || carry != 0){
             int cur = carry;
             if(l1 != null){
                 cur += l1.val;
                 l1= l1.next;
             }
             if(l2 != null){
                 cur += l2.val;
                 l2 = l2.next;
             }
             carry = cur / 10;
             cur =  cur % 10;
             p.next = new ListNode(cur);
             p = p.next;

         }

        

         return dummy.next;
    }
}
// @lc code=end

