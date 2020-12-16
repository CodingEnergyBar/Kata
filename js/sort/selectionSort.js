Array.prototype.selectionSort = function () {
    // 还是需要 let
    //到最后一个的时候就不用了 
    for (let i = 0; i < this.length - 1; i++) {
        let minIndex = i;
        // for (let j = i; j < this.length - 1; j++) {
        for (let j = i; j < this.length; j++) {
            if (this[j] < this[minIndex]) {
                minIndex = j;
            }
        }
        if (minIndex !== i) {
            const tmp = this[minIndex]
            this[minIndex] = this[i];
            this[i] = tmp;
        }
    }
    // for (let i = 0; i < this.length - 1; i += 1) {
    //     // i 之前的都是拍好的, 现在开始排 i
    //     let indexMin = i;
    //     // 打擂台 找最小值 --> 交换
    //     for (let j = i; j < this.length; j += 1) {
    //         if (this[j] < this[indexMin]) {
    //             indexMin = j;
    //         }
    //     }
    //     if (indexMin !== i) {
    //         const temp = this[i];
    //         this[i] = this[indexMin];
    //         this[indexMin] = temp;
    //     }
    // }
};

const arr = [5, 4, 3, 2, 1];
arr.selectionSort();
console.log(arr)
