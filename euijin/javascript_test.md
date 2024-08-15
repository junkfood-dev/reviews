# JavaScript 기초 문제

1. 변수 `a`에 숫자 `5`를 할당하세요.  
```javascript
   let a = 5;
```
   다른 변수 키워드를 사용하여 변수 `b`에 문자열 `Hello`를 할당하세요.  
```javascript
   let b = 'hello';
```
   상수 `C`에 `true`를 할당하세요.
```javascript
   const C = true;
```
2. 위에서 할당한 변수 `a`에 10을 재할당하고, 상수 `C`에 `false`를 재할당 했을 때 각각 어떤 결과가 발생하는지 설명하세요.
```javascript
   a는 변수이므로 10으로 바뀜 C는 constant 값이므로 재할당 할수 없음
```
3. 상수 `D`에 문자열 `apple`와 `banana`를 요소로 갖는 리스트를 할당하세요.
```javascript
   const D = ['apple', 'banana'];
```
4. 상수 `D`에 문자열 `orange`를 추가하세요.
```javascript
   D.push('orange');
```
5. 변수와 상수의 차이를 설명하세요.
```javascript
변수 : 변할수 있는 값
상수 : 고정된 값(재설정하면 에러뜸)
```
6. 숫자, 문자열, 불리언, 배열, 객체의 에제를 하나씩 작성하세요.(변수에 할당)
```javascript
   let a = 1; let b = 'hello'; let c =true; let arr = ['a', 'b', 'c', 'd']; 
   let pussy = {
       name : 'euijin',
       age : 34,
       sex : 'male'
   };
```
7. 아래 코드의 결과를 설명하세요.

```javascript
let x = 10;
let y = '10';

console.log(x == y);   // true  (데이터 타입은 상관안함)
console.log(x === y);  // false ( ===는 데이터 타입도 같아야함)
```

8. 변수 `fruits`의 길이와 두 번째 요소를 출력하세요.

```javascript
let fruits = ['apple', 'banana', 'orange']; 
console.log(fruits.length);
indexOf...
```

9. 객체 `person`을 만들고 `name`, `age`, `job` 속성을 추가하고, 각각의 속성 값을 출력하세요.
```javascript
const person = {
    name : 'jin',
    age : '15',
    job : 'nothing'
}
```
10. 변수 `a`와 `b`에 각각 숫자 5와 10을 할당하고,  
    변수 `a`와 `b`의 덧셈, 뺄셈, 곱셈, 나눗셈, 나머지 연산의 결과를 출력하세요.
```javascript
let a = 5;
let b = 10;
console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log(a / b);
console.log(a % b);
```
11. 아래 코드의 결과를 설명하세요.

```javascript
let x = 15;
let y = 10;

console.log(x > y);   //true
console.log(x < y);   //false
console.log(x >= y);  //true
console.log(x <= y);  //false
```

12. 아래 코드의 결과가 성립하도록 변수 `a`와 `b`의 값을 할당하세요.

```javascript
let a;
let b;

console.log(a && b); // false    둘다 true 아님
console.log(a || b); // true     하나는 true임
console.log(!b); // true         b는 false임   -> a = true; 
                 //                              b = false;
```

13. 삼항 연산자를 사용하여 변수 `score`가 50점 이상이면 `pass`, 그렇지 않으면 `fail`을 출력하는 코드를 작성하세요.  
    (삼항 연산자를 안 배웠을 경우 `if`를 사용하세요.)
```javascript
    let score = 0;
    if (score > 50) {
        console.log('pass');
    } else {
        console.log('fail');
    };
```
14. 다음 코드에서 변수 `c`의 값은?

```javascript
let a = 5;
let b = 10;
let c = ++a + b--;
console.log(c); // 16
```

15. 변수 age가 18 이상이면 `adult`, 그렇지 않으면 `kid`를 출력하는 조건문을 작성하세요.
```javascript
let age = 0;
if(age >= 18) {
    console.log('adult');
} else {
    console.log('kid');
}
```
16. 변수 score가 90 이상이면 `A`, 80 이상이면 `B`, 70 이상이면 `C`, 그 외에는 `F`를 출력하는 조건문을 작성하세요.
```javascript
let score = 0;
if (score >= 90) {
    console.log('A');
} else if (score >= 80) {
    console.log('B');    
} else if (score >= 70) {
    console.log('C');
} else {
    console.log('F');
}
```
17. 변수 num이 짝수인지 홀수인지 판단하여 각각 `짝수` 또는 `홀수`를 출력하는 조건문을 작성하세요.
```javascript
let num = 0;
if (num % 2 == 0) {
    console.log('짝수');
} else {
    console.log('홀수');
}
```
18. `for` 문을 사용하여 1부터 10까지의 숫자를 출력하는 코드를 작성하세요.
```javascript
for(let i = 1; i <= 10; i++) {
    console.log(i);
}
```
19. `while` 문을 사용하여 10부터 1까지의 숫자를 역순으로 출력하는 코드를 작성하세요.
```javascript
let num = 10;
while(num >= 1) {
    console.log(num);
    num--;
}
```
20. `for` 문을 사용하여 1부터 20까지의 숫자 중 짝수만 출력하는 코드를 작성하세요.
```javascript
for(i = 0; i <=20; i+=2) {
    console.log(i);
}
```
21. 문자열 `Hello`의 각 문자를 `for` 문을 사용하여 한 줄씩 출력하는 코드를 작성하세요.

22. 두 개의 숫자를 더한 값을 반환하는 함수 `addNumbers`를 작성하세요.

23. 주어진 문자열을 대문자로 변환하여 반환하는 함수 `toUpperCase`를 작성하세요.
```javascript
let a = 'abcdefg';
console.log(a.toUpperCase());
```

24. 주어진 배열의 첫 번째 요소를 반환하는 함수 `getFirstElement`를 작성하세요.

25. 주어진 숫자가 짝수인지 홀수인지 반환하는 함수 `isEven`를 작성하세요.