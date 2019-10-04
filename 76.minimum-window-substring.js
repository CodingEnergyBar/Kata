/*
 * @lc app=leetcode id=76 lang=javascript
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
	let valids = t.split('');
	let hash = new Map();
	valids.forEach((v) => {
		hash.set(v, 0);
	});

	let isValid = function(hash) {
		let flag = true;
		hash.forEach((value, key) => {
			if (value === 0) flag = false;
			//    console.log('value', value);
			//     console.log('flag', flag);
		});
		// console.log('flag', flag);
		return flag;
	};

	let i = 0,
		j = 0;
	let min = Number.MAX_VALUE;
	let minStr = '';

	for (; i < s.length; i++) {
		while (j < s.length) {
			// console.log('i',i,'j',j);
			// console.log('hash', hash);
			// console.log('str', s.slice(i, j+1));
			const ch = s[j];
			if (hash.has(ch)) {
				hash.set(ch, 1);
			}

			if (isValid(hash)) {
				if (j - i + 1 < min) {
					min = j - 1 + 1;
					minStr = s.substr(i, j + 1);
				}
				break;
			}
			else {
				j++;
			}
		}
		if (hash.has(s[i])) {
			hash.set(s[i], 0);
		}
	}
	return minStr;
};
// @lc code=end
