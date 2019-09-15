/*
 * @lc app=leetcode id=206 lang=javascript
 *
 * [206] Reverse Linked List
 */
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */

// import ListNode from './ListNode';

var reverseList = function(head) {
	// let pre = head,
	// 	cur = head.next,
	// 	tmp = cur.next;
	// while (cur != null) {
	// 	cur.next = pre;
	// 	pre = cur;
	// 	cur = tmp;
	// 	tmp = cur.next;
	// }

	// if (head === null || head.next === null) return head;
	// let pre = head,
	// 	cur = pre.next,
	// 	tmp;
	// while (cur != null) {
	// 	tmp = cur.next;
	// 	cur.next = pre;
	// 	pre = cur;
	// 	cur = tmp;
	// }
	// return pre;

	var tmp = null;
	var pre = null;

	while (head !== null) {
		tmp = head;
		head = head.next;
		tmp.next = pre;
		pre = tmp;
	}
	return pre;
};
