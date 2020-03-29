// Sparse Matrix
/**
 * @param A: a sparse matrix
 * @param B: a sparse matrix
 * @return: the result of A * B
 */
const multiply = function(A, B) {
	const row = A.length;
    const col = B[0].length;
    // fill() intialize some address for (4 undefined) instead of nothing in the array
	const res = new Array(row).fill().map((x) => new Array(col).fill(0));
	// console.log('res', res);
	for (let i = 0; i < row; i++) {
		for (let j = 0; j < col; j++) {
			let mul = 0;
			for (let k = 0; k < A[0].length; k++) {
				if (A[i][k] === 0) {
					continue;
				}
				mul += A[i][k] * B[k][j];
			}
			res[i][j] = mul;
		}
	}
	return res;
};
