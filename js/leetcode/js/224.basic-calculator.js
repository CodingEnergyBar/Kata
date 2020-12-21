/*
 * @lc app=leetcode id=224 lang=javascript
 *
 * [224] Basic Calculator
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
Array.prototype.peek = function () {
    return this[this.length - 1]
}
var calculate = function (s) {
    s = s.replace(/\s+/gi, '')
    const n = s.length;
    const num = []
    const op = []
    let cur = -1;
    for (let i = 0; i < n; i++) {
        // 数字进行累加
        if (isNumber(s[i])) {
            if (cur == -1) {
                cur = s[i] - '0';
            } else {
                cur = cur * 10 + s[i] - '0';
            }
        } else {
            // 将数字入栈
            if (cur != -1) {
                num.push(cur);
                cur = -1;
            }
            // 遇到操作符
            while (op.length) {
                //遇到更低优先级的话就结束
                if (compare(s[i], op.peek())) {
                    break;
                }
                // 不停的出栈，进行运算，并将结果再次压入栈中
                let num1 = num.pop();
                let num2 = num.pop();
                num.push(eval(num1, num2, op.pop()));
            }
            // 当前运算符入栈
            op.push(s[i]);

        }
    }
    if (cur != -1) {
        num.push(cur);
    }
    // 将栈中的其他元素继续运算
    while (op.length) {
        let num1 = num.pop();
        let num2 = num.pop();
        num.push(eval(num1, num2, op.pop()));
    }
    return num.pop();
}

function compare(op1, op2) {
    if (op1 == '*' || op1 == '/') {
        return op2 == '+' || op2 == '-';
    }
    return false;
}

function isNumber(c) {
    return c >= '0' && c <= '9';
}
function eval(a, b, op) {
    switch (op) {
        case '+':
            return a + b;
        case '-':
            return b - a;
        case '*':
            return a * b;
        case '/':
            return b / a;
    }
    return 0;
}

// console.log(calculate("(1+(4+5*2)-3)+(6+8)"))

var calculate2 = function (s) {
    //  a simple expression string
    s = s.replace(/\s+/gi, "");
    const num = []
    const operator = []
    // let pre;
    let i = 0;

    function consumeOps() {
        const opr = operator.pop();
        const p1 = num.pop();
        const p2 = num.pop();
        let r;
        switch (opr) {
            case '+':
                r = p1 + p2
                break
            case '-':
                r = p2 - p1
                break
            case '*':
                r = p2 * p1
                break
            case '/':
                r = Math.floor(p2 / p1)
                break
        }
        num.push(r)
    }
    while (i < s.length) {
        const c = s[i]
        if ('0' <= c && c <= '9') {
            let n = c - '0'
            // 21
            while (i + 1 < s.length && '0' <= s[i + 1] && s[i + 1] >= '9') {
                n = n * 10 + (s[i + 1] - '0')
                i++;
            }
            // operands num  
            num.push(n)
            // result 
            // number.push()

        } else if (!operator.length) {
            // * / + - ()
            operator.push(c)
        } else if ("+-".includes(c)) {
            if ("*/".includes(operator.peek())) {
                // 1+2*3-
                consumeOps()
            }
            operator.push(c)
        } else if ("*/(".includes(c)) {
            operator.push(c)
        } else if (c === ')') {
            let op = operator.peek();
            while (op !== '(') {
                consumeOps()
            }
        }
        i++;
    };

    while (operator.length) {
        consumeOps()
    }
    return num[0]
}

// var calculate = function (s) {
//     //  a simple expression string
//     s = s.replace(/\s+/gi, "");
//     const num = []
//     const operator = []
//     // let pre;
//     let i = 0;

//     function consumeOps() {
//         const opr = operator.pop();
//         const p1 = num.pop();
//         const p2 = num.pop();
//         let r;
//         switch (opr) {
//             case '+':
//                 r = p1 + p2
//                 break
//             case '-':
//                 r = p2 - p1
//                 break
//             case '*':
//                 r = p2 * p1
//                 break
//             case '/':
//                 r = Math.floor(p2 / p1)
//                 break
//         }
//         num.push(r)
//     }
//     while (i < s.length) {
//         const c = s[i]
//         if ('0' <= c && c <= '9') {
//             let n = c - '0'
//             // 21
//             while (i + 1 < s.length && '0' <= s[i + 1] && s[i + 1] >= '9') {
//                 n = n * 10 + (s[i + 1] - '0')
//                 i++;
//             }
//             // operands num  
//             num.push(n)
//             // result 
//             // number.push()

//         } else if (!operator.length) {
//             // * / + - ()
//             operator.push(c)
//         } else if ("+-".includes(c)) {
//             if ("*/".includes(operator.peek())) {
//                 // 1+2*3-
//                 consumeOps()
//             }
//             operator.push(c)
//         } else if ("*/(".includes(c)) {
//             operator.push(c)
//         } else if (c === ')') {
//             let op = operator.peek();
//             while (op !== '(') {
//                 consumeOps()
//             }
//         }
//         i++;
//     };

//     while (operator.length) {
//         consumeOps()
//     }
//     return num[0]
// }

console.log(calculate("2-1 + 2 "))
// @lc code=end

