import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lintcode450_ReverseInKgroup {



    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        ListNode p = head, nxtGroupStart = null, dummy = new ListNode(0), preGroupEnd=dummy;
        dummy.next = head;
        // in sub group
        ListNode start, end;

        // every k nodes have a group
        // reverse a sub linklist from start to end
        while(p!=null){
            start = p;
            for(int i=0; i<k;i++){
                if(p == null || p.next == null){
                    // connect to the previous list without reversing
                    preGroupEnd.next = start;
                    return dummy.next;
                }
                // only need to walk k-1 steps
                p = p.next;
            }
            end = p;
            nxtGroupStart = end.next;
            end.next = null;
            // reverse start to end link list: start to end, end to start
            reverse(start, end);

            // connect to the previous list
            preGroupEnd.next = end;
            preGroupEnd = start;

            p = nxtGroupStart;
        }

        // find the right head; line25
        return dummy.next;

    }
    public void reverse(ListNode start, ListNode end){
        ListNode pre = null, cur = start, tmp;
        while(cur != null){
            tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
    }




    public static void main(String[] args) {
        Lintcode450_ReverseInKgroup test = new Lintcode450_ReverseInKgroup();

        ListNode head = new ListNode(1);
        ListNode p = head;
        for(int i =2; i < 6;i++){
            p.next = new ListNode(i);
            p = p.next;
        }

        test.reverseKGroup(head,2);



    }
}
