// 去重
const arr = [1, 1, 2, 2];
const arr2 = [...new Set(arr)];

// 判断元素是否在集合中
const set = new Set(arr);
const has = set.has(3);

// 求交集
const set2 = new Set([2, 3]);
// !!! set 转 array 再用filter
// set 可以用array 初始化
const set3 = new Set([...set].filter(item => set2.has(item)));
