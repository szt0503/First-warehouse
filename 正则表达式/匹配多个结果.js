let str = "I want to be free,the best things in life are free!"//创建字符串
let reg = /free/g;//创建一个正则表达式，/g找到所有匹配的
let res = str.match(reg);//使用字符串的match方法匹配这个正则表达式
console.log(res)