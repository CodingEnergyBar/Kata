import java.util.*;

public class Lintcode822_ReverseOrderStorage {



        /**
         * @param head: the given linked list
         * @return: the array that store the values in reverse order
         */
        public List<Integer> reverseStore(ListNode head) {
            // write your code here
            List<Integer> newArr = new ArrayList<Integer>();
            while (head!= null){
                // get the value of current node
                Integer cur =  head.val;
                // push the current value to the first position
                newArr.add(cur, 1);


                //find the next
                head = head.next;
            }
            return newArr;
        }




    public static void main(String[] args) {
        Lintcode822_ReverseOrderStorage test = new Lintcode822_ReverseOrderStorage();
        List<Integer> temp1 = new LinkedList<Integer>(Arrays.asList(1, 2, 3));
        test.reverseStore((ListNode) temp1);

        int []nums = new int[]{1,4,4,5,7,7,8,9,9,10};


    }
}
