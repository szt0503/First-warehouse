let str = "I want to be FREE,the best things in life are free!"//创建字符串
let reg = /free/gi;//创建一个正则表达式，/g找到所有匹配的,i不考虑字母大小写进行匹配
let res = str.match(reg);//使用字符串的match方法匹配这个正则表达式
console.log(res)