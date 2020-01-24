/*
 * @lc app=leetcode id=2 lang=javascript
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (31.91%)
 * Likes:    6105
 * Dislikes: 1589
 * Total Accepted:    1M
 * Total Submissions: 3.3M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */

// @lc code=start
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
var addTwoNumbers = function (l1, l2) {
	const res = new ListNode(0);

	let p = res;
	let carry = 0;
	while (l1 && l2) {
		let cur = l1.val + l2.val + carry;
		carry = Math.floor(cur / 10);
		cur = cur % 10;

		p.next = new ListNode(cur);
		p = p.next;
		l1 = l1.next;
		l2 = l2.next;
	}
	if (l1) {
		connect(l1);
	}
	if (l2) {
		connect(l2);
	}

	if (carry) p.next = new ListNode(carry);
	return res.next;

	function connect (l) {
		while (l) {
			let cur = l.val + carry;
			carry = Math.floor(cur / 10);
			cur = cur % 10;
			p.next = new ListNode(cur);
			l = l.next;
			p = p.next;
		}
	}
};
// @lc code=end
