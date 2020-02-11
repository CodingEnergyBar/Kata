import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class Cell {
    int val;
    int freq;

    Cell(int val) {
        this.val = val;
        this.freq = 1;
    }
}

class LRUCache {

    Map<Integer, Integer> hash;

    // key freq key
    List<Integer> freqList;

    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        hash = new HashMap<Integer, Integer>(capacity);
        // 从小到大排序
        freqList = new LinkedList<>();

    }

    public int get(int key) {
        Integer k = Integer.valueOf(key);
        if (!hash.containsKey(k))
            return -1;
        updateLeastVisited(k);
        return hash.get(key);

    }

    private void updateLeastVisited(Integer key) {
        freqList.remove(key);
        freqList.add(key);
    }

    public void put(int key, int value) {
        if (hash.containsKey(key)) {
            hash.put(key, value);
            updateLeastVisited(Integer.valueOf(key));
        } else {
            if (size >= capacity) {
                removeLeastVisited();
                addNewNode(key, value);
            } else {
                addNewNode(key, value);
            }
        }

    }

    private void addNewNode(int key, int value) {
        size++;
        hash.put(key, value);
        freqList.add(Integer.valueOf(key));
    }

    private void removeLeastVisited() {
        Integer key = freqList.get(0);
        hash.remove(key);
        freqList.remove(0);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
