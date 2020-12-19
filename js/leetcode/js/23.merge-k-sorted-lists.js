/*
 * @lc app=leetcode id=23 lang=javascript
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */


function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}
class Heap {
    constructor(compereFn) {
        this.data = []
        this.compereFn = compereFn || function (a, b) { return a - b }
    }
    add(el) {
        this.data.push(el)
        this.shiftUp(this.data.length - 1)
    }
    getParentIdx(idx) {
        return (idx - 1) >> 1;
    }
    swap(i, j) {
        const data = this.data;
        const tmp = data[i]
        data[i] = data[j]
        data[j] = tmp
    }
    shiftUp(idx) {
        if (idx === 0)
            return;

        const data = this.data
        const p = this.getParentIdx(idx);
        if (this.compereFn(data[idx], data[p]) >= 0)
            return;

        this.swap(idx, p)
        this.shiftUp(p)
    }

    pop() {
        // pop这里也可以记得一下
        const data = this.data;
        const min = data[0];
        if (data.length === 1)
            return data.pop()
        data[0] = data.pop()
        this.shiftDown(0)
        return min;
    }

    getLeftChildIndex(idx) {
        return this.protectLimit(idx * 2 + 1)
    }
    getRightChildIndex(idx) {
        return this.protectLimit(idx * 2 + 2)
    }
    protectLimit(index) {
        if (index > this.data.length - 1)
            return null;
        return index;
    }
    shiftDown(i) {
        if (i >= this.data.length - 1)
            return;
        const data = this.data;
        const l = this.getLeftChildIndex(i)
        if (l && this.compereFn(data[i], data[l]) > 0) {
            this.swap(l, i)
            this.shiftDown(l)
        }
        const r = this.getRightChildIndex(i)
        if (r && this.compereFn(data[i], data[r]) > 0) {
            this.swap(r, i)
            this.shiftDown(r)
        }
    }
    peek() {
        return this.data[0]
    }
    isEmpty() {
        return this.data.length === 0;
    }
}
var mergeKLists = function (lists) {
    const dummy = new ListNode();
    let l = dummy;

    const heap = new Heap((i, j) => (i.val - j.val));
    for (let head of lists) {
        if (head)
            heap.add(head)
    }
    while (!heap.isEmpty()) {
        const cur = heap.pop()
        l.next = cur;
        l = l.next;
        if (cur.next)
            heap.add(cur.next)
    }
    return dummy.next
};
const arrayToList = (arr) => {
    const du = new ListNode();
    let l = du;
    for (const a of arr) {
        l.next = new ListNode(a)
        l = l.next
    }
    return du.next
}
const ls = [
    arrayToList([1, 4, 5]),
    arrayToList([1, 3, 4]),
    arrayToList([2, 6])
]
console.log(mergeKLists(ls))

// @lc code=end

