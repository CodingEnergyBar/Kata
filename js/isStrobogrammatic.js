/**
 * @param num: a string
 * @return: true if a number is strobogrammatic or false
 */
const isStrobogrammatic = function (num) {
	let map = new Map();
	map.set("1", "1");
	map.set("8", "8");
	map.set("6", "9");
	map.set("9", "6");
	map.set("0", "0");
	for (let i = 0; i < num.length; i++) {
		let cur = num[i];
		let mirrored = num[num.length - i - 1];
		if (!map.has(cur)) {
			return false;
		}
		if (mirrored !== map.get(cur)) {
			return false;
		}
	}
	return true;
};
