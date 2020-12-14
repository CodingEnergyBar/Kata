// 100 --> bitwise


function getBinary(n) {
    const stack = [];
    while (n) {
        stack.push(n % 2)
        n = Math.floor(n / 2);
    }
    let res = 0;
    while (stack.length) {
        res = res * 10 + stack.pop();
    }
    return res;
    
}
console.log(getBinary(100)) // 1100100