public class LRUCache {
    /*
     * @param capacity: An integer
     */

    class ListNode {
        public int val, key;
        public ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }

    }

    // do not use the hash.size() to count, otherwise it will lead to O(n)
    int capacity, size;
    ListNode tail;
    ListNode dummy;
    // the question is key value, so the node has to be key and value
    // hash got the key and previous node

    Map<Integer, ListNode> keyToPre;

    public LRUCache(int capacity) {

        // System.out.println("size " + this.size);
        this.dummy = new ListNode(0, 0);
        this.tail = this.dummy;

        this.capacity = capacity;
        this.keyToPre = new HashMap<>();
        // do intialization if necessary
    }

    /*
     * @param key: An integer
     * 
     * @return: An integer
     */
    public int get(int key) {
        if (!keyToPre.containsKey(key)) {
            return -1;
        }

        moveToTail(key);

        return keyToPre.get(key).next.val;

    }

    void moveToTail(int key) {
        // else move node
        ListNode pre = keyToPre.get(key);
        ListNode cur = pre.next;

        if (cur == tail) {
            return;
        }

        pre.next = cur.next;
        tail.next = cur;

        // change the hash: a bit tricky
        if (pre.next != null) {
            keyToPre.put(pre.next.key, pre);
        }
        keyToPre.put(cur.key, tail);

        // update tail
        tail = cur;

    }

    /*
     * @param key: An integer
     * 
     * @param value: An integer
     * 
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here

        // !!! if in the pool, the get method will put the node to the end,
        // System.out.println(this.keyToPre);
        if (get(key) != -1) {
            ListNode pre = keyToPre.get(key);
            pre.next.val = value;
            return;
        }

        // else

        ListNode cur = new ListNode(key, value);
        if (size < capacity) {
            tail.next = cur;
            // put to the tail
            keyToPre.put(key, tail);
            tail = cur;
            size++;
            return;
        } else {
            // delete the recent one and put to the end;
            // think about capacity = 1, better not using the wrong number

            keyToPre.remove(dummy.next.key);
            dummy.next = dummy.next.next;
            if (dummy.next != null) {
                keyToPre.put(dummy.next.key, dummy);
            } else {
                keyToPre.put(key, dummy);
            }

            // could be better in changing the value, but not substitute the value
            tail.next = cur;
            keyToPre.put(key, tail);
            tail = cur;
        }

    }
}