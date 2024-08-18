- 내장함수 사용법을 다시 확인하세요.

```javascript
// 1.
let str = '123.45';
function x(a) {
    return a.parseInt();
}
x(str);
```

- 내장함수 사용법을 다시 확인하세요.

```javascript
// 2.
let str = '123.45';
function x(a) {
    return a.parseFloat();
}
```

- 함수 사용은 맞지만, `join` 함수의 아규먼트에 대해 다시 생각해보세요.

```javascript
// 3.
let arr = ['안녕', '하세요'];
function x(a) {
    return a.join(' ');
}
x(arr);
```

- 결과를 ~~반환~~하는 게 아닌 **출력**하는 함수입니다.  
  내장함수 `toString()`은 잘 썼으나, `parseInt()` 사용법은 다시 숙지하세요.

```javascript
// // 4.
// let str = '010';
// function x(a) {
//     return a.parseInt(bin, 2).toString(8);
// }
```

- 참 잘했어요.

```javascript
// 5.
function x(a) {
    return a.toString();
}
```

- 좋은 방법이지만 형변환을 사용해서 풀어보세요.

```javascript
// 6.
let num = 0;
let str = '';
function x(a) {
   return !!a;
}
```

- 내장함수 사용법을 다시 확인하세요.

```javascript
// 7.
let bool1 = true;
let bool2 = false;
function x(a) {
    return a.Number();
}
```

- 참 잘했어요.

```javascript
// 8.
let arr = [1, 2, 3];
function x(a) {
    return a.toString();
}
```

- 참 잘했어요.

```javascript
// 9.
let str = 'JavaScript is very hard..'
function x(a) {
    return a.split(' ');
}
```

- 참 잘했어요.

```javascript
// 10.
let num = 453;
function x(a) {
    return a.toString(16);
}
```

- 문제를 잘 읽어보세요.  
  입력은 문자열이 아니고 **숫자**입니다.

```javascript
// 11.
let num = '123.456';
function x(a) {
    return a.slice(0, -1);
}
```

- 참 잘했어요.

```javascript
// 12.
let str = '안녕하세요';
function getFirstElement(a) {
    return a[0];
}
```

- 참 잘했어요.

```javascript
// 13.
let str1 = '안녕';
let str2 = 'hi';
function x(a, b) {
    return a + b;
}
```

- 잘했는데, 조금 더 효율적인 방법은 없는지 고민해보세요.

```javascript
// 14.
let str1 = 'hello world';
let str2 = 'hello';
function x(a) {
    if (str1.includes(str2)) {
        return 'ture';
    } else {
        return 'false';
    }
}
//////////////////////////
str1.includes(str2) ? 'ture' : 'false';
```

- 참 잘했어요.

```javascript
// 15.
let str = 'JavaScript';
console.log(str.slice(0, 4));
```

- 참 잘했어요;;

```javascript
// 16.
let str = 'hello'
const x = (a) => a.toUpperCase();
```

- 문제를 잘 읽어보세요.

```javascript
// 17.
const arr = [1, 2, 3, 4, 5];
function x(a) {
    a.push();
    return;
}
```

- 참 잘했어요.

```javascript
// 18.
const arr = [1, 2, 3, 4];
function x(a) {
    y = a.pop();
    console.log(y);
    console.log(arr) 
}
```

- 참 잘했어요.

```javascript
// 19.
const arr = [1, 2, 3, 4];
function x(a) {
    y = a.shift();
    console.log(y);
    console.log(arr)
}
```

- 뭐가 잘못되었는지 문제를 다시 한 번 천천히 잘 읽어보세요.

```javascript
// 20.
const arr = [1, 2, 3, 4, 5];
function x(a) {
    a.unshift();
    return;
}
```

- 하 이거 설명 한건데 ㅡㅡ 다시 잘 생각해보세요.

```javascript
// // 21.
// const arr = [a, b, c, d];
// function x(a) {
//     a.forEach(function(index)) {
//     console.log(index);
// }
// }
```

- 자바스크립트의 Math함수에서 반올림, 올림, 내림을 찾아보세요.

```javascript
// // 22.
// let num = 123.45;
// switch (a == Number) {
//     case Numner: 
// }
```

- 참 잘했어요.

```javascript
// 23.
console.log(`Math.random() : ${Math.random()}`);
```

- 참 잘했어요.

```javascript
// 24.
const num = (10, 20, 30);
function x(a) {
    return Math.max(a);
}
```

- 참 잘했어요.

```javascript
// 25.
const arr = [1, 2, 3, 4, 5];
function x(a) {
    return a.reverse();
}
```