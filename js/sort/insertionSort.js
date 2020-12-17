
// Array.prototype.insertionSort = function () {
//     for (let i = 1; i < this.length; i += 1) {
//         const temp = this[i];
//         let j = i;
//         while (j > 0) {
//             if (this[j - 1] > temp) {
//                 this[j] = this[j - 1];
//             } else {
//                 break;
//             }
//             j -= 1;
//         }
//         this[j] = temp;
//     }
// };


Array.prototype.insertionSort = function () {
    for (let i = 1; i < this.length; i++) {
        // for (let j = i - 1; j >= 0; j--){
        //     if(this[i])
        // }
        let j = i; // j和前面的比  2 1 从第二位2 开始比 如果比他小 j 就往前移
        // 2 2
        // 1 2
        const tmp = this[j];
        // while (j > 0 && this[j] < this[j - 1]) {
        // 思维还是挺重要的 先tmp 然后每个和tmp比 然后最后把tmp放到合适的位置
        // 循环 可以找到 合适位置 可以把每个和tmp比较
        while (j > 0 && this[j - 1] > tmp) {
            this[j] = this[j - 1]
            // 不用交换 而是直接覆盖 找到最终的位置
            // const tmp = this[j];
            // this[j] = this[j - 1];
            // this[j - 1] = tmp;
            j--;
        }
        this[j] = tmp;
    }
};

const arr = [2, 4, 5, 3, 1];
arr.insertionSort();
console.log(arr)
