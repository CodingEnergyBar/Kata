import java.util.ArrayList;

/*
 * @lc app=leetcode id=706 lang=java
 *
 * [706] Design HashMap
 */

// @lc code=start
class Cell {
    int key;
    int value;

    Cell(int k, int v) {
        this.key = k;
        this.value = v;
    }
}

class MyHashMap {

    /** Initialize your data structure here. */
    ArrayList<Cell>[] hash;
    int numBuckets = 100;
    double LOAD_FACTOR = 0.7;

    public MyHashMap() {
        intializeHash();

    }

    private void intializeHash() {
        // generic array creation [in Cell.java]
        // hash = new ArrayList<Cell>[numBuckets];
        hash = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            hash[i] = new ArrayList<Cell>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        ArrayList<Cell> bucket = hash[getHashCode(key)];
        for (Cell el : bucket) {
            if (el.key == key) {
                el.value = value;
                return;
            }
        }

        bucket.add(new Cell(key, value));
    }

    private int getHashCode(int key) {
        return key % numBuckets;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        ArrayList<Cell> bucket = hash[getHashCode(key)];
        for (Cell el : bucket) {
            if (el.key == key)
                return el.value;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        ArrayList<Cell> bucket = hash[getHashCode(key)];

        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key == key) {
                bucket.remove(i);
            }
        }

    }

}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end
