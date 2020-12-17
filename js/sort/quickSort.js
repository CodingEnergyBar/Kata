// Array.prototype.quickSort = function () {
//     const rec = (arr) => {
//         if (arr.length === 1) { return arr; }
//         const left = [];
//         const right = [];
//         const mid = arr[0];
//         for (let i = 1; i < arr.length; i += 1) {
//             if (arr[i] < mid) {
//                 left.push(arr[i]);
//             } else {
//                 right.push(arr[i]);
//             }
//         }
//         return [...rec(left), mid, ...rec(right)];
//     };
//     const res = rec(this);
//     res.forEach((n, i) => { this[i] = n });
// };
Array.prototype.quickSort = function () {
    function rec(arr, start, end) {
        if (start >= end) return;
        const pivot = arr[end];
        let j = start;
        for (let i = start; i < end; i++) {
            if (arr[i] < pivot) {
                const tmp = arr[i]
                arr[i] = arr[j]
                arr[j] = tmp;
                j++;
            }
        }
        const tmp = arr[end]
        arr[end] = arr[j]
        arr[j] = tmp;

        rec(arr, start, j - 1);
        rec(arr, j + 1, end);
    }
    rec(this, 0, this.length - 1)
    // res.forEach((val, index) => {
    //     this[index] = val;
    // });

}
const arr = [2, 4, 5, 3, 1, 45, 65, 23, 456, 6];
arr.quickSort();
console.log(arr)
