/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {
    Map<Integer, Integer> valueTOIndex;
    List<Integer> data;
    List<Integer> indexes;
    int size;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.data = new LinkedList<Integer>();
        this.indexes = new LinkedList<Integer>();
        this.valueToIndex = new HashMap<Integer, Integer>();
        this.indexToValue = new HashMap<Integer, Integer>();

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) {
            return false;
        }
        data.add(val);
        int index = data.length() - 1;
        indexes.add(index);

    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        // int idx = map.remove(val);
        // int last = list.remove(list.size() - 1);
        // if (val != last) {
        // list.set(idx, last);
        // map.put(last, idx);
        // }
        // return true;
    }

    }

    /** Get a random element from the set. */
    public int getRandom() {

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
// @lc code=end
