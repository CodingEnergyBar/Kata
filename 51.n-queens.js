/*
 * @lc app=leetcode id=51 lang=javascript
 *
 * [51] N-Queens
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[][]}
 */

var solveNQueens = function(n) {
	const res = [];
	const cols = [];

	search(res, cols, n);
	// console.log(res);
	return res;
};
function draw(cols, n) {
	const paint = [];
	for (let c of cols) {
		let row = Array(n).fill('.');
		row[c] = 'Q';
		paint.push(row.join(''));
	}
	return paint;
}
function search(res, cols, n) {
	if (cols.length === n) {
		// to do draw
		console.log('cols', cols);
		res.push(draw(cols, n));
		return;
	}

	// cur column
	for (let col = 0; col < n; col++) {
		if (canPlace(col, cols)) {
			cols.push(col);
			search(res, cols, n);
			cols.pop();
		}
	}
}
function canPlace(col, cols) {
	const row = cols.length;
	for (let r = 0; r < cols.length; r++) {
		const c = cols[r];

		if (c === col) return false;
		if (Math.abs(row - r) === Math.abs(col - c)) return false;
	}
	return true;
}
// @lc code=end
