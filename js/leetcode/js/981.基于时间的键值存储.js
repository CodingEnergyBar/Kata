/*
 * @lc app=leetcode.cn id=981 lang=javascript
 *
 * [981] 基于时间的键值存储
 */

// @lc code=start
/**
 * Initialize your data structure here.
 */
var TimeMap = function () {
    this.data = new Map()
};

/** 
 * @param {string} key 
 * @param {string} value 
 * @param {number} timestamp
 * @return {void}
 */
TimeMap.prototype.set = function (key, value, timestamp) {
    // find had a set with timestamp as a list
    if (!this.data.has(key)) {
        this.data.set(key, [])
    }
    // latest
    const arr = this.data.get(key)
    arr.push([timestamp, value])
    arr.sort((a, b) => { a[0] - b[0] })

};

/** 
 * @param {string} key 
 * @param {number} timestamp
 * @return {string}
 */
TimeMap.prototype.get = function (key, timestamp) {
    // if there is no 
    const arr = this.data.get(key)
    console.log("arr", arr)
    if (!arr)
        return null
    //small to big
    return arr[findFirstGreaterThan()]

    // find last smaller than  and euqal to
    // find the first greater than  - 1
    function findFirstGreaterThan() {
        let l = 0, r = arr.length - 1; // [a, b)

        while (l <= r) { // l >= r: [23,23)  | l > r
            let m = Math.floor((l + r) / 2);
            // console.log("r", r)
            // console.log("l", l)
            console.log("m", m)

            if (arr[m][0] < timestamp) {
                l = m + 1;
            } else if (arr[m][0] === timestamp) {
                return m;
            } else {
                r = m - 1;
            }
        }
        console.log("l", l)
        console.log("r", r)
        return l;
    }

};

/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = new TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */
// @lc code=end

