class Parent {
    constructor() {
        this.c = "c";
        this.test = this.test.bind(this);
    }
    test() { }
}
var myParent = {
    c: "c"
}
// var myObject = Object.create(myParent)
var myObject = new Parent()
Object.defineProperty(
    myObject,
    "a",
    // 让 a 像普通属性一样可以枚举 
    { enumerable: true, value: 2 }
);
Object.defineProperty(
    myObject,
    "b",
    // 让b不可枚举
    { enumerable: false, value: 3 }
);
myObject.b; // 3
("b" in myObject); // true myObject.hasOwnProperty( "b" ); // true
// .......
for (var k in myObject) {
    console.log(k, myObject[k]);
}
// "a" 2
