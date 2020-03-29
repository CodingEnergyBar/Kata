/**
 * @param s: a string
 * @param t: a string
 * @return: true if they are both one edit distance apart or false
 */
const isOneEditDistance = function (s, t) {
	let i = 0,
		j = 0;
	let cnt = 0;

	// while(i < s.length && i < t.length){
	//     if(s[i] !== t[i]){
	//         return s.slice(i+1) === t.slice(i) || s.slice(i) === t.slice(i+1) ||s.slice(i+1) === t.slice(i+1);
	//     }
	//     i++;
	// }

	// return (s.length-i === 1) || (t.length-i === 1);

	// as there is two symmetrical results:

	// you could use one technique to send it back which the two parameters:

	if (s.length < t.length) {
		return isOneEditDistance(t, s);
	}
	if (s.length - t.length >= 2) return false;
	// s.length >= t.length
	for (let i = 0; i < t.length; i++) {
		if (s[i] != t[i]) {
			return s.slice(i + 1) === t.slice(i) || s.slice(i + 1) === t.slice(i + 1);
		}
	}
	return s.length === t.length + 1;
};
