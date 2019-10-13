/**
 * @param num: A list of integers
 * @return: An integer
 */
const longestConsecutive = function (num) {
	const nSet = new Set();
	for (const n of num) {
		nSet.add(n);
	}

	let max = 0;
	for (const n of num) {
		// javascript is delete in set
		nSet.delete(n);
		let low = n - 1;
		let up = n + 1;
		// not the one in the set, but one above / beyond the boundary
		while (nSet.has(low)) {
			nSet.delete(low);
			low--;
		}
		while (nSet.has(up)) {
			nSet.delete(up);
			up++;
		}

		// here is up low 1
		max = Math.max(max, up - low - 1);
	}
	return max;
};
