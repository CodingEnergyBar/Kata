/*
 * @lc app=leetcode.cn id=347 lang=javascript
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */


class MinHeap {

    constructor(compareFn) {
        this.heap = [];
        this.compareFn = compareFn || function (a, b) { return a - b };
        // (a, b)=> a.value - b.value
    }
    swap(i1, i2) {
        const temp = this.heap[i1];
        this.heap[i1] = this.heap[i2];
        this.heap[i2] = temp;
    }
    getParentIndex(i) {
        //--> / 2  取商
        return (i - 1) >> 1;
    }
    getLeftIndex(i) {
        return i * 2 + 1;
    }
    getRightIndex(i) {
        return i * 2 + 2;
    }
    insert(value) {
        this.heap.push(value);
        this.shiftUp(this.heap.length - 1)
    }
    compare(a, b) {
        return this.compareFn(this.heap[a], this.heap[b]) //  < 0
    }
    shiftUp(index) {
        if (index == 0) { return; }
        const parentIndex = this.getParentIndex(index);
        // 冒泡上去 递归
        if (this.compare(parentIndex, index) > 0) {
            this.swap(parentIndex, index);
            this.shiftUp(parentIndex);
        }
    }
    shiftDown(index) {
        // if (index >= this.size())
        //     return;
        const leftIndex = this.getLeftIndex(index);
        const rightIndex = this.getRightIndex(index);
        // console.log('index', index)
        // console.log('leftIndex', leftIndex)
        // console.log('rightIndex', rightIndex)
        if (leftIndex < this.size() && this.compare(leftIndex, index) < 0) {
            this.swap(leftIndex, index);
            this.shiftDown(leftIndex);
        }
        if (rightIndex < this.size() && this.compare(rightIndex, index) < 0) {
            this.swap(rightIndex, index);
            this.shiftDown(rightIndex);
        }
    }
    insert(value) {
        this.heap.push(value);
        this.shiftUp(this.heap.length - 1);
    }
    pop() {
        const res = this.heap[0];
        this.heap[0] = this.heap.pop()
        this.shiftDown(0);
        return res;
    }
    peek() {
        return this.heap[0];
    }
    size() {
        // console.log('size', this.heap.length);
        // console.log('执行了')
        return this.heap.length;
    }
    isEmpty() {
        return this.heap.length === 0;
    }
}

var topKFrequent = function (nums, k) {
    const hash = {}
    for (const num of nums) {
        hash[num] = hash[num] ? hash[num] + 1 : 1;
    }
    const minHeap = new MinHeap(function (a, b) {
        // console.log('a', a);
        // console.log('b', b);
        return a.value - b.value
    });
    Object.entries(hash).forEach(([key, value], index) => {
        // overwrite
        minHeap.insert({ key, value })
        // console.log(`minHeap ${index}`, minHeap)
        if (minHeap.size() > k) {
            // console.log('minHeappoppedpre', minHeap)
            minHeap.pop()
            // console.log('minHeappopped', minHeap)
        }
    })
    const res = []
    while (k) {// 区常量??/
        res.unshift(minHeap.pop().key)
        k--;
    }
    return res;
};
// @lc code=end

