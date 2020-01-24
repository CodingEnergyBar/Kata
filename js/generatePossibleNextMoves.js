/**
 * @param s: the given string
 * @return: all the possible states of the string after one valid move
 */
const generatePossibleNextMoves = function (s) {
	// write your code here
	let res = [];
	let i = 0;
	for (; i + 1 < s.length; i++) {
		if (s[i] == "+" && s[i + 1] == "+") {
			res.push(s.substring(0, i) + "--" + s.substring(i + 2));
		}
	}
	return res;
};
