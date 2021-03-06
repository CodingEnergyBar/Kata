/**
 * @param {string[]} words1
 * @param {string[]} words2
 * @param {string[][]} pairs
 * @return {boolean}
 */

const areSentencesSimilarTwo = function (words1, words2, pairs) {
	// all the words  and words's nodes
	if (words1.length != words2.length) return false;
	const graph = buildGraph(words1, words2, pairs);
	let x = words1[0];
	// for(const y of graph.get(x)){
	//     console.log(y);
	// }
	// console.log("graph", graph);
	for (let i = 0; i < words1.length; i++) {
		if (!inTheSameFamily(words1[i], words2[i], graph)) return false;
	}
	return true;
};
function inTheSameFamily (word1, word2, graph) {
	const visited = new Set();
	const queue = [];
	queue.push(word1);
	visited.add(word1);

	while (queue.length !== 0) {
		// shift not unshift
		const cur = queue.shift();
		if (cur == word2) return true;

		if (graph.has(cur)) {
			for (const word of graph.get(cur)) {
				if (!visited.has(word)) {
					queue.push(word);
					visited.add(word);
				}
			}
		}
	}
	return false;
}

const buildGraph = function (words1, words2, pairs) {
	const graph = new Map();
	for (const pair of pairs) {
		graph.set(pair[0], new Set());
		graph.set(pair[1], new Set());
	}
	for (const pair of pairs) {
		graph.get(pair[0]).add(pair[1]);
		graph.get(pair[1]).add(pair[0]);
	}
	return graph;
};
