/**
 * @param nums: a continuous stream of numbers
 * @param number: a number
 * @return: returns the first unique number
 */
const firstUniqueNumber = function (nums, number) {
	const hash = new Map();
	let possible = false;
	for (const num of nums) {
		if (!hash.has(num)) {
			hash.set(num, 0);
		}
		hash.set(num, hash.get(num) + 1);
		if (num === number) {
			possible = true;
			break;
		}
	}
	// console.log(hash);
	// which is in place which is not ...
	if (possible) {
		for (let [ key, value ] of hash.entries()) {
			// console.log("key", key);
			if (value === 1) {
				return key;
			}
		}
	}
	return -1;
};
