import java.util.HashMap;
import java.util.Map;

import sun.jvm.hotspot.opto.Node;

/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start
class Node{
    int key;
    int freq;
    int value;
    Node prev;
    Node next;
    Node(){

    }
    Node(int key, int value){
        this.value =  value;
        this.key = key;
        this.freq =  1;
    }
}

class LFUCache {

    Map<Integer, Node> keyToNode;
    Node head;
    Node tail;
    int capacity;
    int curSize;

    public LFUCache(int capacity) {
        this.capacity = capacity;

        head = new Node();
        tail = new Node();
        head.next= tail;
        tail.prev = head;

        // hashmap
        keyToNode = new HashMap<Integer, Node>();
        
    }
    
    public int get(int key) {
        if(keyToNode.containsKey(key)){
            increaseFreqFromList(key);
            return keyToNode.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity == 0)
            return;
        if(keyToNode.containsKey(key)){
            increaseFreqFromList(key);
            keyToNode.get(key).value = value;
        }else{
         
            if(keyToNode.size() >=  capacity){
               Node d = removeLeastFreqFromList();
               keyToNode.remove(d.key);
            }
            Node curNode = new Node(key, value);
            keyToNode.put(key, curNode);
            //add to linkedlist 
            addToFreqList(key);
        }
    }

    void increaseFreqFromList(int key){
        // increase freq + linkedlist 
        Node cur = keyToNode.get(key);
        cur.freq++;
        
        while(cur.next != tail && cur.freq >= cur.next.freq){
            switchNode(cur, cur.next);
        }

    }
    void addToFreqList(int key){
        Node cur = keyToNode.get(key);
        insertBehind(cur, head);
        while(cur.next != tail && cur.freq >= cur.next.freq){
            switchNode(cur, cur.next);
        }

    }
    Node removeLeastFreqFromList(){
        Node d = head.next;
        head.next = d.next;
        d.next.prev =  head;
        return d;
    }
    void switchNode(Node n1, Node n2){
        Node prev = n1.prev;
        Node next =  n2.next;

        n2.prev = prev;
        prev.next = n2;

        n2.next = n1;
        n1.prev = n2;

        n1.next = next;
        next.prev = n1;

    }
    void insertBehind(Node n1, Node n2){
        Node next = n2.next;
        n2.next = n1;
        n1.prev = n2;
        
        n1.next = next;
        next.prev = n1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

