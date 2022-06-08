let str = "The react.js is used by many people"//创建字符串
let reg = /rea..\.js/gi;
//创建一个正则表达式
//   /g找到所有匹配的
//   i不考虑字母大小写进行匹配
//   ..匹配任意字符
//   \转义字符
let res = str.match(reg);//使用字符串的match方法匹配这个正则表达式
console.log(res)