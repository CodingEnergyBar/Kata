/*
 * @lc app=leetcode id=725 lang=java
 *
 * [725] Split Linked List in Parts
 */

// @lc code=start
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        // 知道长度, 
        int length = 0;
        ListNode p = root;
        while(p != null){
            length++;
            p = p.next;
        }
        int base = length/k, rest = length%k;

        //rest: base+1
        ListNode[] res = new ListNode[k];

        p = root;
        p = fill(res, base+1, p, 0, rest);
        fill(res, base, p, rest, length);

        return res;
        
    }
    ListNode fill(ListNode[] res, int base, ListNode head, int start, int end){
        ListNode p = head;
        for(int i=start; i<end && p != null; i++){
            // dummy这里需要注意
            ListNode dummy = new ListNode(0);
            dummy.next = p;
            ListNode endNode = null;
            for(int j=0; j<base && p != null; j++){
                endNode = p;
                p = p.next;
            }
            if(endNode != null) endNode.next = null;
            res[i] = dummy.next;
        }
        return p;
        // return p.next;
    }
}
// @lc code=end

