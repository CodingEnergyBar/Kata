/**
 * @param str: str: the given string
 * @return: char: the first unique character in a given string
 */
const firstUniqChar = function(str) {
	// Write your code here
	const hash = {};
	for (const s of str) {
		if (hash[s] === undefined) hash[s] = 0;
		hash[s]++;
	}
	for (const key of Object.keys(hash)) {
		if (hash[key] === 1) return key;
	}

	return -1;
};
