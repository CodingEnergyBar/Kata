/**
 * @param words1: 
 * @param words2: 
 * @param pairs: 
 * @return: Whether sentences are similary or not?
 */
const areSentencesSimilarTwo = function (words1, words2, pairs) {
	//
	const union = new Map();
	for (const pair of pairs) {
		if (!union.has(pair[0])) union.set(pair[0], pair[0]);
		if (!union.has(pair[1])) union.set(pair[1], pair[1]);

		setParent(pair[0], pair[1]);
		console.log("union", union);
	}

	if (words1.length != words2.length) return false;

	for (let i = 0; i < words1.length; i++) {
		const word1 = words1[i];
		const word2 = words2[i];
		if (getParent(word1) != getParent(word2)) {
			return false;
		}
	}
	return true;

	function setParent (word1, word2) {
		const word1P = getParent(word1);
		const word2P = getParent(word2);
		union.set(word1P, word2P);
	}

	function getParent (word) {
		if (!union.has(word)) return word;
		while (union.get(word) != word) {
			word = union.get(word);
		}
		return word;
	}
};
