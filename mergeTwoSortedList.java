/**
 * Definition for ListNode public class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */

public class Solution {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
            head = head.next;
            l1 = l1.next;
        }
        if (l2 != null) {
            head.next = l2;
            head = head.next;
            l2 = l2.next;
        }
        return dummy.next;

    }
}