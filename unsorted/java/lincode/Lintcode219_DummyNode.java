
public class Lintcode219_DummyNode {





    public ListNode insertNode(ListNode head, int val) {
        // write your code here

        if(head == null)
            return new ListNode(val);
        ListNode dummy  =  new ListNode(0);
        ListNode cur = dummy;
        dummy.next = head;


        //start from head
        while(cur.next != null && cur.next.val <= val)
            cur = cur.next;

        //insertNode
        ListNode n = new ListNode(val);
        ListNode tmp = cur.next;
        cur.next = n;
        n.next = tmp;

        return cur;

    }

    public static void main(String[] args) {
        Lintcode219_DummyNode test = new Lintcode219_DummyNode();

        int []nums = new int[]{1,4,4,5,7,7,8,9,9,10};

        ListNode example =  new ListNode(1);

        System.out.println(test.insertNode(example, 0));

    }
}
