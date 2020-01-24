/*
 * @lc app=leetcode id=147 lang=javascript
 *
 * [147] Insertion Sort List
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

var insertionSortList = function(head) {
	let dummy = new ListNode(0);
	dummy.next = null;

	// head to dummy so there is no  dummy.next = head;

	// every loop head to the right node place
	// console.log(!head);
	while (head) {
		let node = dummy;
		//!!!
		while (node.next != null && node.next.val < head.val) node = node.next;

		let tmp = head.next;
		head.next = node.next;
		node.next = head;

		head = tmp;
	}

	return dummy.next;
};

let b = arrayToList([ 4, 2, 1, 3 ]);
console.log(insertionSortList(b));
