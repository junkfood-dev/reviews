# JavaScript 기초 문제2

1. 실수 문자열(`123.45` 등)을 입력 받아 정수로 변환한 결과를 반환하는 함수를 작성하세요.
```javascript
let a = ['123','45']
parseInt()
```
2. 실수 문자열(`123.45` 등)을 입력 받아 실수로 변환한 결과를 반환하는 함수를 작성하세요.
```javascript
parseFloat()
```
3. 문자열로 이루어진 배열을 입력 받아 배열의 요소들을 결합한 결과를 반환하는 함수를 작성하세요.
```javascript
join("")
```
4. 2진수 문자열(`010` 등)을 입력 받아 10진수와 8진수로 각각 변환한 결과를 출력하는 함수를 작성하세요.
```javascript
[머쓱해요] 
```
5. 숫자를 입력 받아 문자열로 변환한 결과를 반환하는 함수를 작성하세요.
```javascript
toString()
```
6. 숫자 `0`과 빈 문자열 `''`을 각각 불리언 값으로 변환한 결과를 출력하세요.
```javascript
console.log(Boolean(0)); // false
console.log(Boolean('')); // false
```
7. 불리언 값 `true`와 `false`를 각각 숫자로 변환한 결과를 출력하세요.
```javascript
true = 1
false = 0 인데 어떻게 출력하는지 모르겠음
```
8. 배열을 입력 받아 문자열로 변환한 결과를 반환하는 함수를 작성하세요.
```javascript
let arr = ['a','b','c'];
console.log(arr.toString());
```
9. 문자열 `JavaScript is very hard..`을 공백을 기준으로 나누어 출력하세요.
```javascript
let a = 'JavaScript is very hard..';
console.log(a.split(" "));
```
10. 숫자를 입력 받아 16진수 문자열로 변환한 결과를 반환하는 함수를 작성하세요.
```javascript
let a = 1234;
console.log(a.toString(16));
```
11. 숫자 `123.456`을 소수점 이하 2자리로 고정된 문자열로 변환한 결과를 출력하세요.
```javascript
[머쓱해요]
```
12. 문자열을 입력 받아 첫 번째 문자를 반환하는 함수를 작성하세요.
```javascript
12. let a = 'hello';
console.log(a[0]);
```
13. 두 개의 문자열을 입력 받아 두 문자열을 결합한 결과를 반환하는 함수를 작성하세요.
```javascript
function add(x,y){
    return x+y;
}
console.log('hello', 'world!');
```
14. 두 개의 문자열을 입력 받아 첫 번째 문자열에 두 번째 문자열이 포함되어 있는지 확인한 결과를 반환하는 함수를 작성하세요.
```javascript
[머쓱해요]
```
15. 문자열 `JavaScript`에서 `Java` 부분을 출력하세요.
```javascript
let a = 'JavaScript';
console.log(a.slice(0,4));
```
16. 영어 문자열을 입력 받아 대문자로 변환한 결과를 반환하는 함수를 작성하세요.
```javascript
let a = 'abcdefg';
console.log(a.toUpperCase());
```
17. 배열과 임의의 변수를 입력 받아 배열의 마지막에 변수를 추가한 결과를 반환하는 함수를 작성하세요.
```javascript
 let arr = ['a','b','c','d'];
console.log(arr.push('e'));
```
18. 배열 `[1, 2, 3, 4]`에서 마지막 요소를 제거하고, 변수에 저장하여 두 변수를 출력하는 코드를 작성하세요.
```javascript
 let arr = [1, 2, 3, 4];
console.log(arr.pop());
```
19. 배열 `[1, 2, 3, 4]`에서 첫 번째 요소를 제거하고, 변수에 저장하여 두 변수를 출력하는 코드를 작성하세요.
```javascript
 let arr = [1, 2, 3, 4];
console.log(arr.shift());
```
20. 배열과 임의의 변수를 입력 받아 배열의 첫 번째에 변수를 추가한 결과를 반환하는 함수를 작성하세요.
```javascript
let arr= ['a','b','c','d'];
console.log(arr.unshift('z'));
```
21. 배열 `['a', 'b', 'c', 'd']`에서 요소 `c`의 인덱스를 출력하세요.
```javascript
let arr = ['a','b','c','d'];
console.log(arr[2]);
```
22. 실수 한 개를 입력 받아 반올림, 올림, 내림한 결과를 출력하는 함수를 작성하세요.
```javascript
console.log(Math.round(a));    // 124
console.log(Math.ceil(a));       // 124
console.log(Math.floor(a));     //  123
```
23. `0`이상 `1`미만의 난수를 생성하는 코드를 작성하세요.
```javascript
console.log(Math.random());
```
24. 숫자 세 개를 입력 받아 가장 큰 수를 반환하는 함수를 작성하세요.
```javascript
let a = [10, 20, 30, 40, 50];
console.log(Math.max(a));  이거 왜 NaN 뜸?
console.log(Math.max(10, 20, 30, 40, 50));
```
25. 배열을 입력받아 배열의 순서를 반대로 뒤집은 결과를 반환하는 함수를 작성하세요.
```javascript
console.log(a.reverse());  안배움
```