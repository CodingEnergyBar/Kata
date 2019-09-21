/*
 * @lc app=leetcode id=21 lang=javascript
 *
 * [21] Merge Two Sorted Lists
 */
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */

function ListNode(val) {
	this.val = val;
	this.next = null;
}

function arrayToList(array) {
	let dummy = new ListNode(0);
	let node = dummy;
	array.forEach((a) => {
		node.next = new ListNode(a);
		node = node.next;
	});
	return dummy.next;
}

var mergeTwoLists = function(l1, l2) {
	let dummy = new ListNode(0);
	let node = dummy;
	while (l1 && l2) {
		if (l1.val <= l2.val) {
			node.next = l1;
			l1 = l1.next;
		} else {
			node.next = l2;
			l2 = l2.next;
		}
		node = node.next;
	}
	if (l1) {
		node.next = l1;
	}
	if (l2) {
		node.next = l2;
	}

	return dummy.next;
};
