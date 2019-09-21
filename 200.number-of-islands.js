/*
 * @lc app=leetcode id=200 lang=javascript
 *
 * [200] Number of Islands
 */
/**
 * @param {character[][]} grid
 * @return {number}
 */
// test = [
// 	[ '1', '1', '0', '0', '0' ],
// 	[ '1', '1', '0', '0', '0' ],
// 	[ '0', '0', '1', '0', '0' ],
// 	[ '0', '0', '0', '1', '1' ]
// ];
var numIslands = function(grid) {
	// console.log(grid);
	// let visited = new Array(grid.length).fill(new Array(grid[0].length).fill(false));

	if (grid.length === 0) {
		return 0;
	}
	const col = grid[0].length;
	const row = grid.length;

	// let dfs = function(xold, yold) {
	// 	let queue = [ [ xold, yold ] ];
	// 	while (queue.length !== 0) {
	// 		let r = queue.shift();

	// 		let x = r[0];
	// 		let y = r[1];

	// 		for (let [ dx, dy ] of [ [ 0, 1 ], [ 1, 0 ], [ -1, 0 ], [ 0, -1 ] ]) {
	// 			let xnew = x + dx;
	// 			let ynew = y + dy;
	// 			console.log('x, y', xnew, ynew);

	// 			if (xnew < row && xnew >= 0 && ynew >= 0 && ynew < col && !visited[xnew][ynew]) {
	// 				if (grid[xnew][ynew] === '1') {
	// 					queue.push([ xnew, ynew ]);
	// 				}

	// 				console.log('queue', queue);
	// 				visited[xnew][ynew] = true;
	// 				console.log('visited', visited);
	// 				console.log('------');
	// 			}
	// 		}
	// 	}
	// };

	let dfs = function(x, y) {
		// shorthand for up, down, left and right locations
		let dirs = [ [ 0, -1 ], [ 1, 0 ], [ 0, 1 ], [ -1, 0 ] ];

		// mark our current spot as a zero, or recursive dfs' will find this spot again
		grid[x][y] = '0';

		// loop over the directions, check if we're still on the "board" and if we find an attached 1,
		// then dfs from that location
		dirs.forEach(function(dir) {
			let posX = x + dir[0];
			let posY = y + dir[1];

			if (posX > -1 && posX < grid.length && posY > -1 && posY < grid[0].length && grid[posX][posY] === '1') {
				dfs(posX, posY);
			}
		});
	};

	let res = 0;
	for (let i = 0; i < row; i++) {
		for (let j = 0; j < col; j++) {
			// console.log(grid);
			if (grid[i][j] === '1') {
				dfs(i, j);
				res++;
			}
			// console.log(grid);
			// console.log('----------');
		}
	}
	return res;
};
let test = [
	[ '1', '1', '1', '1', '0' ],
	[ '1', '1', '0', '1', '0' ],
	[ '1', '1', '0', '0', '0' ],
	[ '0', '0', '0', '0', '0' ]
];

test = [
	[ '1', '1', '0', '0', '0' ],
	[ '1', '1', '0', '0', '0' ],
	[ '0', '0', '1', '0', '0' ],
	[ '0', '0', '0', '1', '1' ]
];
// console.log('what');
console.log(numIslands(test));
