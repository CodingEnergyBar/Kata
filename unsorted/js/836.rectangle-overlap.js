/*
 * @lc app=leetcode id=836 lang=javascript
 *
 * [836] Rectangle Overlap
 */
/**
 * @param {number[]} rec1
 * @param {number[]} rec2
 * @return {boolean}
 */
var isRectangleOverlap = function(rec1, rec2) {
    let [x1, y1, x2, y2] = [...rec1];
    let [x1b, y1b, x2b, y2b] = [...rec2];


    if(x2 < x1b || x2b < x1){
        console.log("here");
        return false;
    }
    if(y2 < y1b ||  y2b < y1){
        console.log("y");
        return false;
    }
    return true;

    
};

