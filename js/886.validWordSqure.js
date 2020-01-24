/**
 * @param words: a list of string
 * @return: a boolean
 */
const validWordSquare = function (words) {
	if (words == null || words.length != words[0].length) return false;
	for (let i = 0; i < words.length; i++) {
		for (let j = 0; j < words[0].length; j++) {
			if (words[i][j] != words[j][i]) return false;
		}
	}
	return true;
};
