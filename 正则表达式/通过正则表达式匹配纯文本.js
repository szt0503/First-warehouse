let str = "The best things in life are free!"//创建字符串
let reg = /free/;//创建一个正则表达式
let res = str.match(reg);//使用字符串的match方法匹配这个正则表达式
console.log(res)