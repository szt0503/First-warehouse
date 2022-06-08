let str = ['Choco23late','Choco34late','nhoco11','yhoco66','chocol']//创建字符串
let reg = /[Ccyn]hoco\d/g;
//创建一个正则表达式
//   []中括号包括一个匹配的集合
//   [0-9]区间,例如[a-z],[A-Z]
//   ^取反字符   [^0-9]表示不是0-9的
//   \d表示[0-9]，\D表示[^0-9]
//   \w表示[a-z A-Z 0-9] 匹配数字字母，并且包括下划线，\W表示[^a-z A-Z 0-9]
//   \s表示[\f\n\r\t\v]，\D表示[^\f\n\r\t\v]
let res = str.filter(item=>item.match(reg));//使用字符串的match方法匹配这个正则表达式
console.log(res)