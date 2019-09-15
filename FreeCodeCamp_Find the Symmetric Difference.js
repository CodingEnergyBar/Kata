function sym(args) {
	console.log(args);
	let res = [];
	for (let i = 0; i < args.length; i++) {
		res = findDifferenceFromTwo(res, args[i]);
	}
	return res;
}

function findDifferenceFromTwo(A, B) {
	let res = [];
	for (let item of A) {
		if (B.indexOf(item) === -1 && res.indexOf(item) === -1) {
			res.push(item);
		}
	}
	for (let item of B) {
		if (A.indexOf(item) === -1 && res.indexOf(item) === -1) {
			res.push(item);
		}
	}
	return res;
}

sym([[ 1, 2, 3 ], [ 5, 2, 1, 4 ]]);
