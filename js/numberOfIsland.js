/**
 * @param grid: a boolean 2D matrix
 * @return: an integer
 */
const numIslands = function (grid) {
	// write your code here
	// bfs

	// let visited = n
	// console.log('grid', grid);
	let cnt = 0;
	for (let i = 0; i < grid.length; i++) {
		for (let j = 0; j < grid[0].length; j++) {
			if (grid[i][j] === true) {
				bfs(grid, i, j);
				cnt++;
			}
		}
	}
	return cnt;

	function bfs (grid, i, j) {
		let dx = [ 0, 0, 1, -1 ];
		let dy = [ 1, -1, 0, 0 ];

		let queue = [ [ i, j ] ];
		//   queue.push(new Array(i, j));
		grid[i][j] = false;

		while (queue.length) {
			let cur = queue.shift();

			for (let i = 0; i < 4; i++) {
				let x = cur[0] + dx[i];
				let y = cur[1] + dy[i];
				if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
					continue;
				}
				if (grid[x][y] == true) {
					queue.push([ x, y ]);
					grid[x][y] = false;
				}
			}
		}
	}
};
