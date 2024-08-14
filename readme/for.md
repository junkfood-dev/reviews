# for 연습하기

## 구구단 7단 출력하기

아래와 같은 결과가 나와야함

```
7 x 1 = 7
7 x 2 = 14
7 x 3 = 21
...
7 x 9 = 63
```

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```javascript
for (let i = 1; i <= 9; i++) {
  console.log(`7 x ${i} = ${7 * i}`);
}
```

</div>
</details>

## 구구단 2단 ~ 9단 출력하기

아래와 같은 결과가 나와야함

```
2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
...
9 x 8 = 72
9 x 9 = 81
```

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```javascript
for (let i = 2; i <= 9; i++) {
  for (let j = 1; j <= 9; j++) {
    console.log(`${i} x ${j} = ${i * j}`);
  }
  // console.log(''); // 이 줄을 추가하면 각 단 사이에 공백이 추가됨
}
```

</div>
</details>

# 별찍기 1

아래와 같은 결과가 나와야함

```
*
**
***
****
*****
```

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```javascript
for (let i = 1; i <= 5; i++) {
  let stars = '';
  for (let j = 1; j <= i; j++) {
    stars += '*';
  }
  console.log(stars);
}
```

```javascript
for (let i = 1; i <= 5; i++) {
  console.log('*'.repeat(i));
}
```

</div>
</details>

# 별찍기 2

아래와 같은 결과가 나와야함

```
*****
****
***
**
*
```

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```javascript
for (let i = 5; i >= 1; i--) {
  let stars = '';
  for (let j = 1; j <= i; j++) {
    stars += '*';
  }
  console.log(stars);
}
```

```javascript
for (let i = 5; i >= 1; i--) {
  console.log('*'.repeat(i));
}
```

</div>
</details>

# 별찍기 3

아래와 같은 결과가 나와야함

```
    *
   **
  ***
 ****
*****
```

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```javascript
for (let i = 1; i <= 5; i++) {
  let line = '';
  for (let j = 1; j <= 5 - i; j++) {
    line += ' ';
  }
  for (let k = 1; k <= i; k++) {
    line += '*';
  }
  console.log(line);
}
```

```javascript
for (let i = 1; i <= 5; i++) {
  console.log(' '.repeat(5 - i) + '*'.repeat(i));
}
```

</div>
</details>

# 별찍기 4

아래와 같은 결과가 나와야함

```
*****
 ****
  ***
   **
    *
```

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```javascript
for (let i = 5; i >= 1; i--) {
  console.log(' '.repeat(5 - i) + '*'.repeat(i));
}
```

```javascript
for (let i = 5; i >= 1; i--) {
  let line = '';
  for (let j = 1; j <= 5 - i; j++) {
    line += ' ';
  }
  for (let k = 1; k <= i; k++) {
    line += '*';
  }
  console.log(line);
}
```

</div>
</details>

# 별찍기 5

아래와 같은 결과가 나와야함

```
    *
   ***
  *****
 *******
*********
```

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```javascript
for (let i = 1; i <= 5; i++) {
  console.log(' '.repeat(5 - i) + '*'.repeat(2 * i - 1));
}
```

```javascript
for (let i = 1; i <= 5; i++) {
  let line = '';
  for (let j = 1; j <= 5 - i; j++) {
    line += ' ';
  }
  for (let k = 1; k <= 2 * i - 1; k++) {
    line += '*';
  }
  console.log(line);
}
```

</div>
</details>

# 별찍기 6

아래와 같은 결과가 나와야함

```
*********
 *******
  *****
   ***
    *
```

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```javascript
for (let i = 5; i >= 1; i--) {
  console.log(' '.repeat(5 - i) + '*'.repeat(2 * i - 1));
}
```

```javascript
for (let i = 5; i >= 1; i--) {
  let line = '';
  for (let j = 1; j <= 5 - i; j++) {
    line += ' ';
  }
  for (let k = 1; k <= 2 * i - 1; k++) {
    line += '*';
  }
  console.log(line);
}
```

</div>
</details>

# 별찍기 7

아래와 같은 결과가 나와야함

```
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
```

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```javascript
for (let i = 1; i <= 5; i++) {
  console.log(' '.repeat(5 - i) + '*'.repeat(2 * i - 1));
}
for (let i = 4; i >= 1; i--) {
  console.log(' '.repeat(5 - i) + '*'.repeat(2 * i - 1));
}
```

```javascript
for (let i = 1; i <= 5; i++) {
  let line = '';
  for (let j = 1; j <= 5 - i; j++) {
    line += ' ';
  }
  for (let k = 1; k <= 2 * i - 1; k++) {
    line += '*';
  }
  console.log(line);
}
for (let i = 4; i >= 1; i--) {
  let line = '';
  for (let j = 1; j <= 5 - i; j++) {
    line += ' ';
  }
  for (let k = 1; k <= 2 * i - 1; k++) {
    line += '*';
  }
  console.log(line);
}
```

</div>
</details>

# 별찍기 8

아래와 같은 결과가 나와야함

```
*********
 *******
  *****
   ***
    *
   ***
  *****
 *******
*********
```

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```javascript
for (let i = 5; i >= 1; i--) {
  console.log(' '.repeat(5 - i) + '*'.repeat(2 * i - 1));
}
for (let i = 2; i <= 5; i++) {
  console.log(' '.repeat(5 - i) + '*'.repeat(2 * i - 1));
}
```

```javascript
for (let i = 5; i >= 1; i--) {
  let line = '';
  for (let j = 1; j <= 5 - i; j++) {
    line += ' ';
  }
  for (let k = 1; k <= 2 * i - 1; k++) {
    line += '*';
  }
  console.log(line);
}
for (let i = 2; i <= 5; i++) {
  let line = '';
  for (let j = 1; j <= 5 - i; j++) {
    line += ' ';
  }
  for (let k = 1; k <= 2 * i - 1; k++) {
    line += '*';
  }
  console.log(line);
}
```

</div>
</details>