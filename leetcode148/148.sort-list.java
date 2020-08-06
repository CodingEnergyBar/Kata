package leetcode148;
/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 */

// @lc code=start

// Definition for singly-linked list.
//  class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
 
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    // 用 mergew
    ListNode mergeSort(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //有个 prev
        prev.next = null;
        ListNode first = mergeSort(head);
        ListNode second = mergeSort(slow);
        return mergeTwoLists(first, second);
    }

    ListNode mergeTwoLists(ListNode first, ListNode second){
        ListNode dummy = new ListNode(), p = dummy;
        while(first != null && second != null){
            if(first.val < second.val){
                p.next = first;
                first = first.next;
            }else{
                p.next = second;
                second = second.next;
            }
            p = p.next;
        }
        if(first != null){
            p.next = first;
        }
        if(second != null){
            p.next = second;
        }
        return dummy.next;

    }
    
    public static void main(String[] args) {
        ListNode dummy = new ListNode(), p = dummy;
        int[] list = {4,2,1,3};
        for(int e: list){
            ListNode cur = new ListNode(e);
            p.next = cur;
            p = p.next;
        }
        ListNode head = dummy.next;
        new Solution().sortList(head);
    
        
    }
}
// @lc code=end

