class Stack{
    
    constructor() {
        this.data = [];
    }
    pop() {
        if (this.isEmpty()){
            throw new Error('Stack is already empty')
        }
        return this.data.pop()
    }
    push(n) {
        if (!n )
            throw new Error('Need to push a candidate')
        this.data.push(n);
    }
    peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.data[this.data.length - 1]
    }
    isEmpty() {
        return this.data.length === 0
    }
}

const s = new Stack()
console.log(s.push(1))
console.log(s.pop())