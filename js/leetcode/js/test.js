const test = new Object()
Object.defineProperty(test, "enum", {
    enumerable: false,
})
Object.defineProperty(test, "t2", {
    enumerable: true, // bu
    writable: true
})
test.enum = "enum"
test.t2 = "t2"
for (const a in test) {
    console.log(a) // t2
}

console.log(test.hasOwnProperty("enum")) // true
