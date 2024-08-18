# JavaScript 기초 문제2

1. 실수 문자열(`123.45` 등)을 입력 받아 정수로 변환한 결과를 반환하는 함수를 작성하세요.
```javascript
let k = 123.45;
function int(x) {
    return parseInt(x);
}
int(k);
```
2. 실수 문자열(`123.45` 등)을 입력 받아 실수로 변환한 결과를 반환하는 함수를 작성하세요.
```javascript
let k = 123.45;
function float(x) {
    return parseFloat(x);
}
float(k);
```
3. 문자열로 이루어진 배열을 입력 받아 배열의 요소들을 결합한 결과를 반환하는 함수를 작성하세요.
```javascript
let arr = ['a','b','c'];
function a(x) {
    let c = x.join("");
    return c
}
a(arr)
```
4. 2진수 문자열(`010` 등)을 입력 받아 10진수와 8진수로 각각 변환한 결과를 출력하는 함수를 작성하세요.
```javascript
let str = '1011'
function change(str) {
    return parseInt(str, 2);
}
change(str);


let str = '1011'
function changes(str) {
   let str10 = parseInt(str, 2);
   return str10.toString(8);
}
changes(str);
```
5. 숫자를 입력 받아 문자열로 변환한 결과를 반환하는 함수를 작성하세요.
```javascript
let int = 123;
function a(x) {
    return x.toString();
}
a(int);
```
6. 숫자 `0`과 빈 문자열 `''`을 각각 불리언 값으로 변환한 결과를 출력하세요.
```javascript
console.log(Boolean(0)); // false
console.log(Boolean('')); // false
```
7. 불리언 값 `true`와 `false`를 각각 숫자로 변환한 결과를 출력하세요.
```javascript
let trueN = Number(true);
let falseN = Number(false);
console.log(trueN);
console.log(falseN); 
```
8. 배열을 입력 받아 문자열로 변환한 결과를 반환하는 함수를 작성하세요.
```javascript
let arr = ['a','b','c'];
function a(x) {
    return x.toString();
}
a(arr);
```
9. 문자열 `JavaScript is very hard..`을 공백을 기준으로 나누어 출력하세요.
```javascript
let a = 'JavaScript is very hard..';
console.log(a.split(" "));
```
10. 숫자를 입력 받아 16진수 문자열로 변환한 결과를 반환하는 함수를 작성하세요.
```javascript
let num = 1234;
function change(int) {
    return int.toString(16);
}
change(num);
```
11. 숫자 `123.456`을 소수점 이하 2자리로 고정된 문자열로 변환한 결과를 출력하세요.
```javascript
let num = 123.456;
function fix(x) {
    return x.toFixed(2);
}
fix(num);
```
12. 문자열을 입력 받아 첫 번째 문자를 반환하는 함수를 작성하세요.
```javascript
12. let str = 'hello';
function a(x) {
    return str[0];
}
a(str);
```
13. 두 개의 문자열을 입력 받아 두 문자열을 결합한 결과를 반환하는 함수를 작성하세요.
```javascript
let arr = ['a', 'b'];
function a(x,y){
    return x+y;
}
a(arr);
```
14. 두 개의 문자열을 입력 받아 첫 번째 문자열에 두 번째 문자열이 포함되어 있는지 확인한 결과를 반환하는 함수를 작성하세요.
```javascript
let str1 = "hello world nice to meet you"
let str2 = "world"
function inc(s1,s2) {
    return s1.includes(s2);
}
inc(str1,str2);
```
15. 문자열 `JavaScript`에서 `Java` 부분을 출력하세요.
```javascript
let str = 'JavaScript';
console.log(str.slice(0,4));
```
16. 영어 문자열을 입력 받아 대문자로 변환한 결과를 반환하는 함수를 작성하세요.
```javascript
let str = 'abcdefg';
function upper(x) {
  return x.toUpperCase();    
}
upper(str);
```
17. 배열과 임의의 변수를 입력 받아 배열의 마지막에 변수를 추가한 결과를 반환하는 함수를 작성하세요.
```javascript
 let arr = ['a','b','c','d'];
function push(x) {
    return arr.push(x);
}
push('e');
```
18. 배열 `[1, 2, 3, 4]`에서 마지막 요소를 제거하고, 변수에 저장하여 두 변수를 출력하는 코드를 작성하세요.
```javascript
 let arr = ['a','b','c','d'];
function pop(x) {
    return arr.pop();
}
pop(arr);
```
19. 배열 `[1, 2, 3, 4]`에서 첫 번째 요소를 제거하고, 변수에 저장하여 두 변수를 출력하는 코드를 작성하세요.
```javascript
 let arr = [1, 2, 3, 4];
function shift(x) {
    return arr.shift();
}
shift(arr);

```
20. 배열과 임의의 변수를 입력 받아 배열의 첫 번째에 변수를 추가한 결과를 반환하는 함수를 작성하세요.
```javascript
let arr = ['a','b','c','d'];
function unshift(x) {
    return arr.unshift(x);
}
unshift('z');
```
21. 배열 `['a', 'b', 'c', 'd']`에서 요소 `c`의 인덱스를 출력하세요.
```javascript
let arr = ['a','b','c','d'];
console.log(arr[2]);
```
22. 실수 한 개를 입력 받아 반올림, 올림, 내림한 결과를 출력하는 함수를 작성하세요.
```javascript
let float = 123.56
function round(x) {
    return Math.round(x);
}
round(float);
function ceil(x) {
    return Math.ceil(x);
}
ceil(float);
function floor(x) {
    return Math.floor(x);
}
floor(float);
```
23. `0`이상 `1`미만의 난수를 생성하는 코드를 작성하세요.
```javascript
console.log(Math.random());
```
24. 숫자 세 개를 입력 받아 가장 큰 수를 반환하는 함수를 작성하세요.
```javascript
let arr = [10, 20, 30];
function max(a) {
    return Math.max(...a);
}
max(arr);
```
25. 배열을 입력받아 배열의 순서를 반대로 뒤집은 결과를 반환하는 함수를 작성하세요.
```javascript
let arr = [10,20,30];
function rev(a) {
    return a.reverse();
}
rev(arr);
```