/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start

class LRUCache {

class DLinkedNode {
  int key;
  int value;
  DLinkedNode pre;
  DLinkedNode post;
}
    private void addNode(DLinkedNode node) {
        
    node.pre = head;
    node.post = head.post;

    head.post.pre = node;
    head.post = node;
    }
/**
 * Move certain node in between to the head.
 */
private void moveToHead(DLinkedNode node){
  this.removeNode(node);
  this.addNode(node);
}
// pop the current tail. 
private DLinkedNode popTail(){
  DLinkedNode res = tail.pre;
  this.removeNode(res);
  return res;
}
    /**
 * Remove an existing node from the linked list.
 */
private void removeNode(DLinkedNode node){
  DLinkedNode pre = node.pre;
  DLinkedNode post = node.post;

  pre.post = post;
  post.pre = pre;
}

    
    public LRUCache(int capacity) {
        
    }
    
    public int get(int key) {
        
    }
    
    public void put(int key, int value) {
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

