/*
 * @lc app=leetcode id=39 lang=javascript
 *
 * [39] Combination Sum
 */

// @lc code=start
/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
	let res = [];
	let combination = [];

	dfs(candidates, target, 0, combination, res);
	console.log(res);
	return res;

	function dfs(candidates, target, start, combination, res) {
		// console.log('candidates, target, start, combination, res');
        // console.log(candidates, target, start, combination, res);
        
		if (target === 0) {
			// deep copy
			res.push(Array.from(combination));
			return;
		}
		if (target < 0) {
			return;
		}

		for (let i = 0; i < candidates.length; i++) {
			combination.push(candidates[i]);
			// instead of writing this

			// target -= candidates[i];
			// dfs(candidates, target, i, combination, res);
			// target += candidates[i];

			//you could write this
			dfs(candidates.slice(i), target - candidates[i], i, combination, res);
            combination.pop();
            
            // // it is not good, as the destructure combination use additional O(n)
            // dfs(candidates.slice(i), target - candidates[i], i, [...combination, candidates[i]], res);


		}
	}
};
// @lc code=end
