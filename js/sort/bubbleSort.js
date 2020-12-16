Array.prototype.bubbleSort = function () {
    let times = 0;
    for (let i = 0; i < this.length - 1; i += 1) {
        let swapped = false;
        for (let j = 0; j < this.length - 1 - i; j += 1) {
            if (this[j] > this[j + 1]) {
                swapped = true;
                times++;
                const temp = this[j];
                this[j] = this[j + 1];
                this[j + 1] = temp;
            }
        }
        if (!swapped)
            return;
    }
};

const arr = [4, 5, 3, 2, 1];
arr.bubbleSort();
console.log(arr);
