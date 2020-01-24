/*
 * @lc app=leetcode id=5 lang=javascript
 *
 * [5] Longest Palindromic Substring
 */
/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
	let table = [];
	var start = 0;
	var maxLength = 1;
	// for (let i=0; i<s.length; i++){
	//     let words = [];
	//     for(let j=0; j<s.length;i++){
	//         words.push(false);
	//     }
	//     table.push(words);
	// }
	// };

	for (let i = 0; i < s.length; i++) {
		table[i] = [];
		for (let j = 0; j < s.length; j++) {
			table[i][j] = false;
			// table[i][j] = 0;
		}
	}

	for (let i = 0; i < s.length; i++) {
		// table[i][i] = true;
		table[i][i] = true;
	}

	// for string of 2, compare i, and i+1 th

	for (let i = 0; i < s.length - 1; i++) {
		if (s.charAt(i) === s.charAt(i + 1)) {
			table[i][i + 1] = true;
			start = i;
			maxLength = 2;
		}
	}

	// I don't understand that so much, but just remember

	for (let i = s.length - 1; i >= 0; i--) {
		for (let j = i + 2; j < s.length; j++) {
			table[i][j] = table[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
			console.log('i', i);
			console.log('s.length', s.length);

			if (table[i][j] && j - i + 1 > maxLength) {
				start = i;
				maxLength = j - i + 1;
			}
			console.log('j-i', j - i);
			console.log('\n');
		}
	}

	return s.slice(start, start + maxLength);
};

longestPalindrome('abababbaa');
