/*
 * @lc app=leetcode.cn id=380 lang=javascript
 *
 * [380] 常数时间插入、删除和获取随机元素
 */

// @lc code=start
/**
 * Initialize your data structure here.
 */
var RandomizedSet = function () {
    this.sequence = [];
    this.dMap = new Map() // [data, pos]
};

/**
 * Inserts a value to the set. Returns true if the set did not already contain the specified element. 
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.insert = function (val) {
    let pos;
    if (!this.dMap.has(val)) {
        pos = this.sequence.length;
        this.sequence.push()
        this.dMap.set(val, pos)s
    } else {
        pos = this.dMap.get(val)
        this.dMap.set(val, pos)



    };

    /**
     * Removes a value from the set. Returns true if the set contained the specified element. 
     * @param {number} val
     * @return {boolean}
     */
    RandomizedSet.prototype.remove = function (val) {

    };

    /**
     * Get a random element from the set.
     * @return {number}
     */
    RandomizedSet.prototype.getRandom = function () {

    };

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = new RandomizedSet()
 * var param_1 = obj.insert(val)
 * var param_2 = obj.remove(val)
 * var param_3 = obj.getRandom()
 */
// @lc code=end

