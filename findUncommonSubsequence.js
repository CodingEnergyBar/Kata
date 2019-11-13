/**
 * @param strs: List[str]
 * @return: return an integer
 */
const findLUSlength = function (strs) {
	// write your code here
	strs.sort((a, b) => {
		if (b.length != a.length) {
			return b.length - a.length;
		}
		else {
			return b - a;
		}
	});
	for (let i = 0; i < strs.length; i++) {
		let preHasCommon = false;

		for (let j = 0; j < strs.length && strs[j].length >= strs[i].length; j++) {
			//  should not compare with itself
			if (j == i) continue;
			if (isCommonSeq(strs[i], strs[j])) {
				preHasCommon = true;
				// console.log("hasCommon", preHasCommon);
				break;
			}
		}
		if (preHasCommon == false) return strs[i].length;
	}
	return -1;
};
// s1 is s2's subsequence
function isCommonSeq (s1, s2) {
	//  console.log("s1", s1);
	//   console.log("s2", s2);

	let index = 0;
	for (let i = 0; i < s2.length; i++) {
		if (s2[i] == s1[index]) {
			index++;
		}
		if (index == s1.length) {
			return true;
		}
	}
	return false;
}
