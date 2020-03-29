/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int k, int v){
            this.key = k;
            this.val = v;
        }
        Node(){
            this.key = Integer.MAX_VALUE;
            this.val = Integer.MAX_VALUE;
        }
      
    }
   void print(){
       Node n = head;
        while(n != null){
            System.out.print(n.val + " -> ");
            n = n.next;
        }
         System.out.println(" ");
    }

    int capacity;
    Map<Integer, Node> hash;
    Node head, tail;
    
    public LRUCache(int capacity) {
        
        this.hash = new HashMap<Integer, Node>();
        this.capacity = capacity;
        
        this.head = new Node();
        this.tail = new Node();
        
        this.head.next = this.tail;
        this.tail.prev = this.head;
        
    }
    
    public int get(int key) {
        if(hash.containsKey(key)){
            Node n = hash.get(key);
            
            n = removeNode(n);
            upliftNode(n);
            
            return n.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hash.containsKey(key)){
            Node n = hash.get(key);
      
            
            n = removeNode(n);
            upliftNode(n);
            
            n.val = value;
        }else{
            if(hash.size() == capacity){
                Node nLast = removeNode(tail.prev);
                hash.remove(nLast.key);
                
            }
              
            Node n = new Node(key, value);
            hash.put(key, n);
            upliftNode(n);
        }
        // print();
    }
    
    void upliftNode(Node n){
        Node next = head.next;
        
        n.next = next;
        next.prev= n;
        
        head.next = n;
        n.prev = head;
    }
    Node removeNode(Node n){
        Node prev = n.prev;
        Node next = n.next;
        
        if(prev != null) prev.next = next;
        if(next != null) next.prev = prev;
        
        n.prev = null;
        n.next = null;
        return n;
    }
    
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

