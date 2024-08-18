```javascript
// 1.
let str = '123.45';
function x(a) {
    return a.parseInt();
}
x(str);
```


```javascript
// 2.
let str = '123.45';
function x(a) {
    return a.parseFloat();
}
```

```javascript
// 3.
let arr = ['안녕', '하세요'];
function x(a) {
    return a.join(' ');
}
x(arr);
```

```javascript
// // 4.
// let str = '010';
// function x(a) {
//     return a.parseInt(bin, 2).toString(8);
// }
```

```javascript
// 5.
function x(a) {
    return a.toString();
}
```

```javascript
// 6.
let num = 0;
let str = '';
function x(a) {
   return !!a;
}
```

```javascript
// 7.
let bool1 = true;
let bool2 = false;
function x(a) {
    return a.Number();
}
```

```javascript
// 8.
let arr = [1, 2, 3];
function x(a) {
    return a.toString();
}
```

```javascript
// 9.
let str = 'JavaScript is very hard..'
function x(a) {
    return a.split(' ');
}
```

```javascript
// 10.
let num = 453;
function x(a) {
    return a.toString(16);
}
```

```javascript
// 11.
let num = '123.456';
function x(a) {
    return a.slice(0, -1);
}
```

```javascript
// 12.
let str = '안녕하세요';
function getFirstElement(a) {
    return a[0];
}
```

```javascript
// 13.
let str1 = '안녕';
let str2 = 'hi';
function x(a, b) {
    return a + b;
}
```

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

```javascript
// 15.
let str = 'JavaScript';
console.log(str.slice(0, 4));
```

```javascript
// 16.
let str = 'hello'
const x = (a) => a.toUpperCase();
```

```javascript
// 17.
const arr = [1, 2, 3, 4, 5];
function x(a) {
    a.push();
    return;
}
```

```javascript
// 18.
const arr = [1, 2, 3, 4];
function x(a) {
    y = a.pop();
    console.log(y);
    console.log(arr) 
}
```

```javascript
// 19.
const arr = [1, 2, 3, 4];
function x(a) {
    y = a.shift();
    console.log(y);
    console.log(arr)
}
```

```javascript
// 20.
const arr = [1, 2, 3, 4, 5];
function x(a) {
    a.unshift();
    return;
}
```

```javascript
// // 21.
// const arr = [a, b, c, d];
// function x(a) {
//     a.forEach(function(index)) {
//     console.log(index);
// }
// }
```

```javascript
// // 22.
// let num = 123.45;
// switch (a == Number) {
//     case Numner: 
// }
```

```javascript
// 23.
console.log(`Math.random() : ${Math.random()}`);
```

```javascript
// 24.
const num = (10, 20, 30);
function x(a) {
    return Math.max(a);
}
```

```javascript
// 25.
const arr = [1, 2, 3, 4, 5];
function x(a) {
    return a.reverse();
}
```