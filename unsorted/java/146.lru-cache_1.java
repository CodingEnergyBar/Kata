/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class Node{
    int val;
    int key;
    Node next;
    Node prev;
    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
class LRUCache {

    int size;
    int capacity;
    Node head;
    Node tail;

    Map<Integer, Node> hash;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = head;
        this.hash =  new HashMap<>();

        
    }
    
    public int get(int key) {
        if(hash.containsKey(key)){
            Node cur = hash.get(key);
            updateList(cur);
            return cur.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(hash.containsKey(key)){
            hash.get(key).val = value;
            updateList(hash.get(key));
        }else{
             System.out.println("capacity "+ capacity);
            if(this.size == this.capacity){


                removeLeastVisitedNode();

            }
            Node newNode = new Node(key, value);
            hash.put(key, newNode);
            insertToList(newNode);
        }
    }
    void insertToList(Node node){
        System.out.println("inserted");
       
        if(head == null){
            head = node;
            tail = head;
        }else{
            // 去链表前面
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
         System.out.println("size "+ this.size);
    }
    void updateList(Node node){
        // node to the head
        Node prev = node.prev;
        Node next = node.next;
        if(prev!=null)prev.next = next;
        if(next !=null)next.prev = prev;

        node.prev = null;
        node.next = null;

        insertToList(node);
        this.size--;
        

    }
    void removeLeastVisitedNode(){
        System.out.println("rempved");
        Node del = this.tail;
        Node newTail = tail.prev;
        if(newTail != null) newTail.next = null;
        tail =  newTail;

        this.hash.remove(del.key);
        System.out.println(this.hash.toString());
        // val, node
        // hash.remove()
        this.size--;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

