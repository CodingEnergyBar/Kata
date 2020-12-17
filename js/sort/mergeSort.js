// Array.prototype.mergeSort = function () {
//     const rec = (arr) => {
//         if (arr.length === 1) { return arr; }
//         const mid = Math.floor(arr.length / 2);
//         const left = arr.slice(0, mid);
//         const right = arr.slice(mid, arr.length);
//         const orderLeft = rec(left);
//         const orderRight = rec(right);
//         const res = [];
//         while (orderLeft.length || orderRight.length) {
//             if (orderLeft.length && orderRight.length) {
//                 res.push(orderLeft[0] < orderRight[0] ? orderLeft.shift() : orderRight.shift());
//             } else if (orderLeft.length) {
//                 res.push(orderLeft.shift());
//             } else if (orderRight.length) {
//                 res.push(orderRight.shift());
//             }
//         }
//         return res;
//     };
//     const res = rec(this);
//     res.forEach((n, i) => { this[i] = n; });
// };
Array.prototype.mergeSort = function () {
    // 
    const rec = (arr) => {
        if (arr.length === 1)
            return arr;
        const mid = arr.length >> 1; // you'yi
        const left = arr.slice(0, mid);
        // console.log('mid', mid)
        // console.log('left', left)
        const right = arr.slice(mid, arr.length);
        const orderLeft = rec(left); //递归的重点是一个
        const orderRight = rec(right)
        const res = [];

        while (orderLeft.length || orderRight.length) {
            while (orderLeft.length && orderRight.length) {
                res.push(orderLeft[0] < orderRight[0] ? orderLeft.shift() : orderRight.shift())
            }
            while (orderLeft.length) {
                res.push(orderLeft.shift())
            }
            while (orderRight.length) {
                res.push(orderRight.shift())
            }
        }
        return res;
    }
    /**
     * /Users/XiumingXu/Development/Kata/js/sort/mergeSort.js:49
    this = res(this);
    ^^^^ this 不应该这么赋值
     */
    // this = res(this);
    const res = rec(this)
    res.forEach((n, i) => this[i] = n)

}

const arr = [5, 4, 3, 2, 1];
arr.mergeSort();
console.log('arr', arr)
