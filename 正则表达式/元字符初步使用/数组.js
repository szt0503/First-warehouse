let str = ['Choco23late','Choco34late','nhoco11','yhoco66','chocol']//创建字符串
let reg = /[Ccyn]hoco[^0-9]/g;
//创建一个正则表达式
//   []中括号包括一个匹配的集合
//   [0-9]区间,例如[a-z],[A-Z]
//   ^取反字符   [^0-9]不是0-9的
let res = str.filter(item=>item.match(reg));//使用字符串的match方法匹配这个正则表达式
console.log(res)