class MinHeap {

    constructor() {
        this.heap = [];
    }
    swap(i1, i2) {
        console.log(this.heap)
        const temp = this.heap[i1];
        this.heap[i1] = this.heap[i2];
        this.heap[i2] = temp;
    }
    getParentIndex(i) {
        //--> / 2  取商
        return (i - 1) >> 1;
    }
    getLeftIndex(i) {
        return i * 2 + 1;
    }
    getRightIndex(i) {
        return i * 2 + 2;
    }
    insert(value) {
        this.heap.push(value);
        this.shiftUp(this.heap.length - 1)
    }

    shiftUp(index) {
        if (index == 0) { return; }
        const parentIndex = this.getParentIndex(index);
        // 冒泡上去 递归
        if (this.heap[parentIndex] > this.heap[index]) {
            this.swap(parentIndex, index);
            this.shiftUp(parentIndex);
        }
    }
    shiftDown(index) {
        if (index === this.size()) return;
        const leftIndex = this.getLeftIndex(index);
        const rightIndex = this.getRightIndex(index);
        if (this.heap[leftIndex] < this.heap[index]) {
            this.swap(leftIndex, index);
            this.shiftDown(leftIndex);
        }
        if (this.heap[rightIndex] < this.heap[index]) {
            this.swap(rightIndex, index);
            this.shiftDown(rightIndex);
        }
    }
    insert(value) {
        this.heap.push(value);
        this.shiftUp(this.heap.length - 1);
    }
    pop() {
        const res = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.shiftDown(0);

    }
    peek() {
        return this.heap[0];
    }
    size() {
        return this.heap.length;
    }
}
// 在react 源码内部 会有 event 被其他人使用的情况. 所以用箭头函数, 否则用class 比较好

const h = new MinHeap();
console.log("h", h)
h.insert(3);
h.insert(2);
h.insert(1);
h.pop();
console.log(h.peek())