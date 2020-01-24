/*
 * @lc app=leetcode id=127 lang=javascript
 *
 * [127] Word Ladder
 */
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */

var ladderLength = function(beginWord, endWord, wordList) {
	// wordList.push(endWord);
	if (!wordList.includes(endWord)) return 0;

	let queue = [ beginWord ];

	//when annouce distance
	let distance = {};
	distance[beginWord] = 1;

	if (beginWord === endWord) return 0;

	while (queue.length !== 0) {
		let w = queue.shift();

		for (let nw of getNextWords(w, wordList)) {
			//!!! have to be distance[nw]
			// console.log('distance.nw', distance[nw]);

			if (distance[nw] === undefined) {
				// not visited
				distance[nw] = distance[w] + 1;
				// console.log('nw', nw);
				// console.log('distance[nw]', distance[nw]);
				if (nw === endWord) {
					return distance[nw];
				} else queue.push(nw);
			}
		}
	}
	return 0;
};
// return the words in the dictionary
var getNextWords = function(word, dict) {
	const res = [];
	const charString = 'qwertyuiopasdfghjklzxcvbnm';
	// for in is for dictionary
	for (let i = 0; i < word.length; i++) {
		for (let c of charString) {
			// let newWord = word.slice(0, i) + c + word.slice(i + 1);
			if (c !== word.charAt(i)) {
				let newWord = word.substr(0, i) + c + word.substr(i + 1);
				// let newWord = word.replace(i, c);
				if (dict.includes(newWord)) {
					res.push(newWord);
				}
			}
		}
	}
	return res;
};

// var ladderLength = function(beginWord, endWord, wordList) {
// 	wordList = new Set(wordList);
// 	if (!wordList.has(endWord)) {
// 		return 0;
// 	}

// 	const ALPHABET = 'abcdefghijklmnopqrstuvwxyz';

// 	let level = 1;
// 	const queue = [ beginWord ];
// 	while (queue.length > 0) {
// 		const word = queue.shift();

// 		// if (word === null) {
// 		// 	level++;
// 		// 	// queue.push(null);
// 		// 	continue;
// 		// }

// 		for (let i = word.length - 1; i >= 0; i--) {
// 			const head = word.slice(0, i);
// 			const tail = word.slice(i + 1);

// 			for (let c = 0; c < 26; c++) {
// 				if (ALPHABET[c] !== word[i]) {
// 					const word = head + ALPHABET[c] + tail;
// 					if (word === endWord) {
// 						return level + 1;
// 					}
// 					if (wordList.delete(word)) {
// 						queue.push(word);
// 					}
// 				}
// 			}
// 		}
// 	}

// 	return 0;
// };
// let beginWord = 'hit',
// 	endWord = 'cog';
// let beginWord = 'hot',
// 	endWord = 'dog';
// let dic = [ 'hot', 'cog', 'dog', 'tot', 'hog', 'hop', 'pot', 'dot' ];
// let res = ladderLength(beginWord, endWord, dic);

// console.log(res);
