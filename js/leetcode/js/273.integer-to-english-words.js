/*
 * @lc app=leetcode id=273 lang=javascript
 *
 * [273] Integer to English Words
 */

// @lc code=start
/**
 * @param {number} num
 * @return {string}
 */
var numberToWords = function (num) {
    let setMap = ['', 'Thousand', 'Million', 'Billion']
    let curSetPos = 0;
    let res = ''
    if (num === 0)
        return 'Zero'
    while (num) {
        const curSet = num % 1000
        const curRes = integerToText(curSet)
        if (curRes)
            res = curRes + (setMap[curSetPos] && ' ') + setMap[curSetPos] + (setMap[curSetPos] && ' ') + res
        num = Math.floor(num / 1000)
        curSetPos++;
    }
    return res;
    //num < 1000
    function integerToText(num) {
        const hundred = ['', 'One', 'Two', 'Three', 'Four',
            'Five', 'Six', 'Seven', 'Eight', 'Nine'
        ]
        const tenthGreaterThanTen = ['', '', 'Twenty', 'Thirty', 'Forty', 'Fifty',
            'Sixty', 'Seventy', 'Eighty', 'Ninety']
        const tenth = ['Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen',
            'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
        const last = hundred;

        let res = ''
        const hundredsBit = Math.floor(num / 100);
        const tensBit = Math.floor(Math.floor(num % 100) / 10)
        const lastBit = Math.floor(num % 10)

        if (hundredsBit)
            res = res + hundred[hundredsBit] + ' Hundred '
        if (tensBit === 1) {
            res += tenth[lastBit]
        } else {
            const tenRes = tenthGreaterThanTen[tensBit]
            if (tenRes)
                res = res + tenthGreaterThanTen[tensBit]
            res = res + (last[lastBit] && ' ') + last[lastBit]
        }
        return res;
    }
}

// console.log(numberToWords(12345))

// @lc code=end

