const numberOfOperations = function (s) {
    // Write your code here
    let sum = 0;
    for(let i=0, j=s.length-1; i<j;i++, j--){
        // here s[i] could be used in javascript but not java
        // charCodeAt in javascript to get ascii
        console.log(Math.abs(s.charCodeAt(j) - s.charCodeAt(i)));
        sum += Math.abs(s.charCodeAt(j) - s.charCodeAt(i));
        
        
    }
    return sum;
}