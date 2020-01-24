/**
 * @param stores: The location of each store.
 * @param houses: The location of each house.
 * @return: The location of the nearest store to each house.
 */
const findNearestStore = function (stores, houses) {
	//
	let res = [];
	stores = stores.sort((a, b) => a - b);
	// console.log(stores);

	for (const house of houses) {
		res.push(search(house));
	}
	return res;

	function search (house) {
		let start = 0,
			end = stores.length - 1;

		while (start + 1 < end) {
			let mid = Math.floor((start + end) / 2);
			if (stores[mid] === house) return stores[mid];
			if (stores[mid] < house) start = mid;
			else end = mid;
		}
		if (getD(start, house) <= getD(end, house)) return stores[start];
		else return stores[end];
	}
	function getD (store_index, house) {
		return Math.abs(stores[store_index] - house);
	}
};
