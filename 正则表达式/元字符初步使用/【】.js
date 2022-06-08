let str = "Chocolate wants 100,000 fans,Chocolate love chocolate"//创建字符串
let reg = /[Cc]hocolate/g;
//创建一个正则表达式
//   []中括号包括一个匹配的集合
let res = str.match(reg);//使用字符串的match方法匹配这个正则表达式
console.log(res)