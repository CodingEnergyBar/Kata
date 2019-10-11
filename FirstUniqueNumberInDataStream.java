public class DataStream {
    
    class ListNode{
        int val;
        ListNode next;
        
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
        
    }
    
    ListNode dummy, tail;
    Map<Integer, ListNode> keyToPre;
    Set<Integer> duplicates;
  
  
    public DataStream(){
        // do intialization if necessary
        this.dummy = new ListNode(0);
        this.tail = dummy;
        // this.size = 0;
        this.keyToPre = new HashMap<Integer, ListNode>();
        this.duplicates = new HashSet<>();
        
    }
    /**
     * @param num: next number in stream
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if(duplicates.contains(num)){
            return;
        }
        // there is one in the linked list 
        if(keyToPre.containsKey(num)){
            // remove
            duplicates.add(num);
            remove(num);
            return;
        }
        
        // new one
        
        ListNode newNode = new ListNode(num);
        tail.next = newNode;
        
        // in java not set but put 
        keyToPre.put(num, tail);
        tail = tail.next;
        
    }
    void remove(int num){
        
        // remove from the list 
        ListNode pre = keyToPre.get(num);
        ListNode cur = pre.next;
        if(cur == tail){
            tail = pre;
        }
        
        pre.next = cur.next;
        
        keyToPre.remove(cur.val, pre);
        if(pre.next != null)
            keyToPre.put(pre.next.val, pre);
        

    }
    

    /**
     * @return: the first unique number in stream
     */
    public int firstUnique() {
        // write your code here
        return dummy.next.val;
    }
}