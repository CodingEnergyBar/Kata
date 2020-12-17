/*
 * @lc app=leetcode.cn id=21 lang=javascript
 *
 * [21] 合并两个有序链表
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
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function (l1, l2) {
    // ListNode.prototype.shift = function () {
    //     const cur = this;
    //     this.next = this.next.next;
    //     return cur;
    // }
    // l1.shift = ListNode.prototype.shift;
    // l2.shift = ListNode.prototype.shift;

    const dummyNode = new ListNode();
    let l = dummyNode;
    // const getVal = (node) => node.val
    // const shift = (node) => {
    //     if (!node) throw Error('cannot shift null')
    //     const val = node.val;
    //     return node.next;
    // }
    // const concat = (node, val) => {
    //     console.log("val", val)

    //     node.next = new ListNode(val);
    //     // 指针没有移动 这只是参数
    //     return node = node.next;
    // }

    while (l1 || l2) {
        while (l1 && l2) {
            if (l1.val < l2.val) {
                l.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                l.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            l = l.next;
        }
        while (l1) {
            l.next = new ListNode(l1.val)
            l = l.next;
        }
        while (l2) {
            l.next = new ListNode(l2.val)
            l = l.next;
        }
    }
    return dummyNode.next;
};
// @lc code=end

