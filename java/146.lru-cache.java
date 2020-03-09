/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start

class Node{
  int key;
  int val;
  Node prev;
  Node next;
  Node(){
  }
  Node(int key, int value){
    this.key = key;
    this.val = value;
  }
}
class LRUCache {
    int capacity;
    private int size;
    private Map<Integer, Node> hash;

    // freq
    private Node dummyHead;
    //???
    private Node dummyTail;;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.dummyHead = new Node();
      this.dummyTail = new Node();
      this.dummyHead.next = dummyTail;
      this.dummyTail.prev = dummyHead;

      this.hash = new HashMap<>();
        
    }
    
    public int get(int key) {
      if(hash.containsKey(key)){
        // 定位 freqlist 不容易
        Node node = hash.get(key);
        upliftNode(node);
        return node.val;
      }

      return -1;
        
    }
    private void upliftNode(Node node){
         deleteNode(node);
         insertNodeAfter(node, dummyHead);

    }
    private void deleteNode(Node node){
    
       Node prev = node.prev;
       Node next = node.next;
       prev.next =  next;
       if(next != null) next.prev= prev;
    }
    private void insertNodeAfter(Node cur, Node target){

       Node next =  target.next;
       target.next = cur;
       cur.prev = target;
       cur.next = next;

       if(next != null) next.prev = cur;
    }
    
    public void put(int key, int value) {

      if(hash.containsKey(key)){
        Node cur = hash.get(key);
        cur.val = value;

        upliftNode(cur);

      }else{
        if(size == capacity){
          deleteLeastVisited();
        }


        Node cur = new Node(key, value);
        insertNodeAfter(cur, dummyHead);
        size++;
        hash.put(key, cur);
      }
        
    }
    private void deleteLeastVisited(){
       Node d = dummyTail.prev;
  

       Node prev= d.prev;
       prev.next = dummyTail;
       dummyTail.prev =  prev;

       //hash key 
       hash.remove(d.key);
    }
}


// @lc code=end

