/*
 * @lc app=leetcode id=118 lang=javascript
 *
 * [118] Pascal's Triangle
 */
/**
 * @param {number} numRows
 * @return {number[][]}
 */

// array push
var generate = function(numRows) {
  if (numRows <= 0) return [];

  pascals = [];
  pascals.push([1]);

  // make current row
  let curRowNum = 1;
  while (curRowNum < numRows) {
    let curRow = [];
    for (let i = 0; i <= curRowNum; i++) {
      if (i === 0 || i === curRowNum) curRow.push(1);
      else
        curRow.push(pascals[curRowNum - 1][i - 1] + pascals[curRowNum - 1][i]);
    }
    pascals.push(curRow);
    curRowNum++;
  }

  return pascals;
};

// console.log(generate(5));
