/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    class Node{
        Integer key;
        Integer val;
        Node next;
        Node prev;
        Node(int key, int value){
          this.key = key;
          this.val = value;
        }
        Node(){
          this.key = null;
          this.val = null;
        }
    }
    int size;
    int capacity;
    Map<Integer, Node> hash;
    Node dummyHead;
    Node tail;

    public LRUCache(int capacity) {
      this.hash = new HashMap<Integer, Node>();
      this.size = 0;
      this.capacity= capacity;
      this.dummyHead= new Node();
      this.tail = new Node();
      dummyHead.next = tail;
      tail.prev = dummyHead;
        
    }
    
    public int get(int key) {
        if(hash.containsKey(key)){
            Node cur = hash.get(key);
            moveNodeToHead(cur);
            return cur.val;
        }else{
          return -1;
        }
        
    }
    
    public void put(int key, int value) {

       if(hash.containsKey(key)){
          Node node =hash.get(key);
          node.val = value;
          moveNodeToHead(node);
       }else{
         Node node = new Node(key, value);
          hash.put(key, node);
         if(size < capacity){
           
            insertNodeToHead(node);
            size++;
         }else{
           removeLeastVisited();
           insertNodeToHead(node);
         }
       }
        
    }

    void moveNodeToHead(Node node){
        insertNodeToHead(removeNode(node));
    }

    void insertNodeToHead(Node cur){
       System.out.println("soemthing2");
        Node head = dummyHead.next;
        dummyHead.next = cur;
        cur.prev = dummyHead;
        cur.next = head;
        if(head != null){
          head.prev = cur;
        }
    }
    Node removeNode(Node cur){
      System.out.println("soemthing1");
        Node prev = cur.prev;
        Node next = cur.next;
        next.prev = prev;
        prev.next = next;
        return cur;
    }
    void removeLeastVisited(){
        Node del = removeNode(tail.prev);
        this.hash.remove(del.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

