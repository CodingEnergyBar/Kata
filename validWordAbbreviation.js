/**
 * @param word: a non-empty string
 * @param abbr: an abbreviation
 * @return: true if string matches with the given abbr or false
 */
const validWordAbbreviation = function(word, abbr) {
	let i = 0,
		j = 0;

	let s = word.split('');
	let t = abbr.split('');

	while (i < word.length && j < abbr.length) {
		if (isNumeric(t[j])) {
			if (t[j] == '0') {
				return false;
			}

			let val = 0;
			while (isNumeric(t[j])) {
				// here is need a bracket
				val = val * 10 + (t[j] - '0');
				j++;
				// console.log('val', val);
			}
			i += val;
		}
		else {
			if (s[i] == t[j]) {
				i++;
				j++;
			}
			else {
				return false;
			}
		}
		//         console.log(s[i]);
		// console.log(t[j]);
		// console.log('-------')
	}
	return i == s.length && j == t.length;

	function isNumeric(ch) {
		let res = ch > '0' && ch < '9';
		return res;
	}
};
