# JavaScript 공부하기

자바스크립트의 기본적인 개념 정리 및 실습을 위한 페이지  
**더 자세한 내용은 [이곳](https://developer.mozilla.org/ko/docs/Web/JavaScript)을 참고**

## 기초 개념

### 변수와 상수

- 변수: 데이터를 저장하기 위한 메모리 공간을 의미, 특정값을 재사용하거나 변경할 수 있도록 함.
    - var: 변수를 선언하며, 재선언과 재할당이 가능하지만, 함수 스코프를 가지기 때문에 주의 필요
    - let: 재선언은 불가능하지만 재할당이 가능한 변수 선언 방식, 블록 스코프를 가짐
- 상수: 데이터를 저장하기 위한 메모리 공간을 의미, 변수와는 다르게 값이 변경되지 않음

```javascript
var name = '지성'; // 'name'이라는 변수에 '지성'이라는 문자열을 저장
let age = 33; // 'age'라는 변수에 숫자 25를 저장
const PI = 3.14 // 'PI'라는 상수에 숫자 3.14를 저장

name = '의진'; // 가능
age = 92; // 가능
// PI = 3.141592 // 오류 발생
```

`var`와 `let`의
차이는 [여기](https://developer.mozilla.org/ko/docs/Learn/JavaScript/First_steps/Variables#the_difference_between_var_and_let)
를 참고

### 데이터 타입

데이터 타입은 변수에 저장될 수 있는 값의 유형을 정의함

- 숫자(Number): 정수와 부동소수점 숫자
- 문자열(String): 텍스트 데이터를 나타내는 문자열
- 불리언(Boolean): true 또는 false 값
- 배열(Array): 여러 개의 값을 순서대로 저장하는 데이터 구조
- 객체(Object): 키-값 쌍으로 이루어진 데이터 구조, 자바스크립트의 거의 모든 것이 객체

```javascript
let number = 100; // 숫자 데이터 타입
let text = 'Hello World; // 문자열 데이터 타입
let isTrue = true; // 불리언 데이터 타입
let color = ['red', 'green', 'blue']; // 배열 데이터 타입
let person = {name: '지성', age: 33}; // 객체 데이터 타입
```

데이터 타입에 대한 더 자세한 내용은 [여기](https://developer.mozilla.org/ko/docs/Web/JavaScript/Data_structures)를 참고

### 연산자

변수나 값에 대해 수학적, 논리적 연산을 수행하는 기호

- 산술 연산자: 덧셈, 뺄셈, 곱셉, 나눗셈, 나머지  
  `+`, `-`, `*`, `/`, `%`
- 비교 연산자: 두 값을 비교하여 true 또는 false를 반환  
  `==`, `===`, `!=`, `!==`, `>`, `<`, `>=`, `<=`
- 논리 연산자: 그리고, 또는, 부정  
  `&&`, `||`, `!`

```javascript
let a = 10;
let b = 5;

let sum = a + b; // 15
let difference = a - b; // 5
let product = a * b; // 50
let quotient = a / b; // 2

let isEqual = (a == b); // false
let isNotEqual = (a != b); // true

let andCondition = (a > b) && (b > 0); // true
let orCondition = (a < b) || (b > 0); // true
```

### 조건문

주어진 조건에 따라 코드의 실행을 제어하는 구조로 `if`와 `else if`, `else`로 구분

```javascript
let score = 85;

if (score >= 90) {
    console.log('A');  // score가 90 이상일 때 실행
} else if (score >= 80) {
    console.log('B'); // score가 90 미만 이고 80 이상일 때 실행
} else {
    console.log('C'); // score가 80 미만일 때 실행
}
```

### 반복문

특정 조건이 만족될 때까지 코드 블록을 반복 실행

- for: 주어진 횟수만큼 반복 실행
- while: 조건이 true일 동안 반복 실행

```javascript
// for 문 예제
for (let i = 0; i < 5; i++) {
    console.log(i);
}

// while 문 예제
let j = 0;
while (j < 5) {
    console.log(j);
    j++;
}
```

### 함수

특정 작업을 수행하기 위한 코드 블록으로, 필요할 때마다 호출

```javascript
// name 변수를 입력받아 'Hello {name}'을 반환(return)하는 함수 
function greet(name) {
    return 'Hello ' + name;
}

let greeting = greet('지성');
console.log(greeting); // 'Hello 지성' 출력
```

## 심화 개념

### 익명 함수

표현 그대로 이름이 없는(익명) 함수로 재사용하지 않는 함수(한 번만 사용할 함수)에 사용

```javascript
function() {
    console.log('Hello World!')
}
```

### 함수 표현식

함수를 변수에 할당하는 방식으로 익명 함수로 선언되는 경우가 많음

```javascript
let multiply = function(a, b) {
    return a * b;
};

console.log(multiply(4, 2)); // 8 출력
```

그러면 아래 두 함수의 차이는 무엇일까?

```javascript
function multiply(a, b) {
    return a * b;
}

let multiply = function(a, b) {
    return a * b;
};
```

두 함수 모두 `multiply()`로 호출할 수 있지만, [호이스팅](https://developer.mozilla.org/ko/docs/Glossary/Hoisting)에서 차이가 있음  
쉽게 말해,  
**일반 함수**는 선언의 위치와 호출의 위치에 연관이 없음  
**익명 함수**는 변수에 저장이 된 후에 호출이 가능함

```javascript
// 일반 함수는 호출 후 선언을 해도 사용이 가능함

console.log(multiply(4, 2));

function multiply(a, b) {
    return a * b;
}
```

```javascript
// 익명 함수는 호출 후 선언하면 에러 발생함

console.log(multiply(4, 2));

let multiply = function(a, b) {
    return a * b;
};
```

### 화살표 함수

ES6에서 도입된 함수 표현식으로 특히 콜백 함수로 많이 사용함

```javascript
let multiply = (a, b) => a * b;

console.log(multiply(4, 2)); // 8 출력
```

### 콜백 함수

함수의 인자로 전달되어 실행되는 함수로 비동기 작업이나 배열 메서드에서 사용함  
콜백은 작업이 끝나기 전에 함수가 실행되지 않는다는 것을 보장함  
즉, 작업이 끝난 후에 콜백이 실행됨

```javascript
function greet(name, callback) {
    console.log('Hello, ' + name);
    callback();
}

greet('지성', function() {
    console.log('This is a callback function.');
});
// 'Hello, 지성' 출력
// 'This is a callback function.' 출력
```

### 고차 함수

함수를 인자로 받거나, 함수를 반환하는 함수

- `map`: 배열의 각 요소에 대해 주허진 함수(콜백)를 호출하여, 그 결과로 새로운 배열을 반환

```javascript
let numbers = [1, 2, 3, 4];
let doubled = numbers.map(function(num) {
    return num * 2;
});

console.log(doubled); // [2, 4, 6, 8]
```

- `filter`: 배열의 각 요소에 대해 주어진 함수(콜백)를 호출하여, 그 결과가 true인 요소들만 포함한 새로운 배열을 반환

```javascript
let numbers = [1, 2, 3, 4, 5, 6];
let evenNumbers = numbers.filter(function(num) {
    return num % 2 === 0;
});

console.log(evenNumbers); // [2, 4, 6]
```

- `reduce`: 배열의 각 요소에 대해 주어진 함수(콜백)를 호출하여, 단일 값으로 축약

```javascript
let numbers = [1, 2, 3, 4];
let sum = numbers.reduce(function(accumulator, currentValue) {
    return accumulator + currentValue;
}, 0);

console.log(sum); // 10
```

### 템플릿 리터럴

백쿼트(`)를 사용해서 문자열을 생성하고, ${} 구문을 통해 변수나 표현식을 삽입

```javascript
let name = '지성';
let greeting = `Hello ${name}`;

console.log(greeting); // 'Hello 지성' 출력
```

### 구조 분배 할당

배열이나 객체의 값을 쉽게 추출해 변수에 할당할 수 있는 문법

```javascript
let person = { name: '지성', age: 33 };
let { name, age } = person;

console.log(name);  // '지성' 출력
console.log(age);   // 33 출력
```

### 클래스

객체 지향 프로그래밍에서 객체를 생성하기 위한 템플릿

```javascript
class Animal {
    constructor(name, type) {
        this.name = name;
        this.type = type;
    }

    speak() {
        console.log(`${this.name}가 말한다. "밥줘!!"`);
    }
}

let cat = new Animal('메주', '고양이');
cat.speak();  // '메주가 말한다. "밥줘!!"' 출력
```

### 모듈화

`export`와 `import` 키워드를 사용해 모듈을 정의하고 불러옴

```javascript
// calc.js 파일
export function add(a, b) {
    return a + b;
}

// main.js 파일
import { add } from './calc.js';

console.log(add(2, 3));  // 5 출력
```

## DOM 조작 및 이벤트 처리

DOM(Documnet Object Model)은 웹페이지의 구조화된 표현으로, HTML 요소를 JavaScript에서 접근하고 조작할 수 있게 해주는 인터페이스임.  
이를 통해 페이지의 내용을 동적으로 변경하거나 스타일을 적용할 수 있음

### DOM 요소 선택

- getElementById: 특정 id를 가진 요소 선택

```javascript
// HTML: <div id="myDiv">Hello World</div>

let myDiv = document.getElementById("myDiv");
console.log(myDiv.innerText); // "Hello World" 출력
```

- querySelector: CSS 선택자를 사용해 첫 번째 일치하는 요소 선택

```javascript
// HTML: <p class="myClass">First Paragraph</p>
//       <p class="myClass">Second Paragraph</p>

let paragraph = document.querySelector(".myClass");
console.log(paragraph.innerText); // "First Paragraph" 출력
```

- querySelector: CSS 선택자를 사용해 일치하는 모든 요소를 선택(NodeList를 반환함)

```javascript
// HTML: <p class="myClass">First Paragraph</p>
//       <p class="myClass">Second Paragraph</p>

let paragraphs = document.querySelectorAll(".myClass");
paragraphs.forEach(p => console.log(p.innerText));
// "First Paragraph"와 "Second Paragraph" 출력
```

### DOM 요소 조작

- innerText / textContent: 요소의 텍스트 내용 변경

```javascript
// HTML: <div id="myDiv">Hello World</div>

let myDiv = document.getElementById("myDiv");
myDiv.innerText = "Hello JavaScript";
myDiv.textContent = "Hello JavaScript";
```

- innerHTML: 요소의 HTML 내용 변경

```javascript
// HTML: <div id="myDiv">Hello World</div>

let myDiv = document.getElementById("myDiv");
myDiv.innerHTML = "<strong>Hello JavaScript</strong>";
```

- style: 요소의 스타일 변경

```javascript
// HTML: <div id="myDiv">Hello World</div>

let myDiv = document.getElementById("myDiv");
myDiv.style.color = "blue";
myDiv.style.backgroundColor = "red";
```

### 이벤트 처리

사용자의 행동(클릭, 키보드 입력 등)에 반응하여 특정 작업을 수행

- 이벤트 리스너: 특정 이벤트가 발생했을 때 실행할 함수 정의

```javascript
element.addEventListener("이벤트 종류", 실행할 함수);
```

- click: 요소가 클릭될 때 발생하는 이벤트

```javascript
let button = document.getElementById("myButton");
button.addEventListener("click", function() {
    console.log("Button clicked!");
});
```

- mouseover: 요소 위로 마우스를 올렸을 때 발생하는 이벤트

```javascript
let myDiv = document.getElementById("myDiv");
myDiv.addEventListener("mouseover", function() {
    myDiv.style.backgroundColor = "yellow";
});
```

- keydown: 키보드의 키가 눌렸을 때 발생하는 이벤트

```javascript
document.addEventListener("keydown", function(event) {
    console.log(`Key pressed: ${event.key}`);
});
```

## 실습 프로젝트

1. To Do List 웹 페이지 만들기

<details>
<summary>화면 구성</summary>
<div markdown="1">

- 헤더 영역: 앱의 제목을 표시(예시: “My To-Do List”)
- 입력 영역: 새로운 할 일을 추가할 수 있는 입력 필드와 추가 버튼
- 입력 필드: 사용자가 할 일을 입력할 수 있는 텍스트 상자
- 추가 버튼: 사용자가 입력한 할 일을 리스트에 추가
- 할 일 목록 영역: 추가된 할 일들이 리스트 형태로 표시됨
- 할 일 항목: 각각의 할 일은 체크박스와 텍스트로 구성됨
- 체크박스: 할 일이 완료되었음을 표시할 수 있는 체크박스
- 할 일 텍스트: 할 일의 내용을 보여주는 텍스트
- 삭제 버튼: 할 일을 삭제할 수 있는 버튼
- 기능 버튼 영역: 모든 할 일의 상태를 변경하거나 삭제하는 기능 버튼들
- 모두 완료: 모든 할 일을 완료 처리
- 완료된 할 일 삭제: 완료된 할 일들을 한 번에 삭제

</div>
</details>

2. 퀴즈 게임 웹 페이지 만들기

<details>
<summary>화면 구성</summary>
<div markdown="1">

- 헤더 영역: 게임의 제목을 표시.
- 질문 영역: 현재 질문이 표시되는 영역.
- 질문 텍스트: 현재 문제를 표시하는 텍스트.
- 답변 입력 영역: 사용자가 정답을 입력할 수 있는 입력 필드와 제출 버튼.
- 입력 필드: 사용자가 정답을 입력할 수 있는 텍스트 상자.
- 제출 버튼: 사용자가 입력한 답을 제출.
- 퀴즈 진행 상태 영역: 현재 진행 상태를 나타내는 정보 표시.
- 현재 점수: 맞힌 문제 수를 표시.
- 진행 상태: 현재 문제 번호와 총 문제 수를 표시.
- 결과 표시 영역: 퀴즈가 끝난 후 결과를 표시.
- 결과 텍스트: 최종 점수와 결과 메시지.
- 재시작 버튼: 퀴즈를 다시 시작할 수 있는 버튼.

</div>
</details>

## AJAX 및 Fetch API

### AJAX

AJAX (Asynchronous Javascript And XML)란 javascript를 이용해 서버와 브라우저가 비동기 방식으로 데이터를 교환하는 통신 기능

### 비동기 프로그래밍

비동기 프로그래밍은 작업이 완료될 때까지 코드 실행을 멈추지 않고, 다른 작업을 계속 진행할 수 있도록 하는 방식  
javascript에서 비동기 프로그래밍을 구현하는 주요 방법은 콜백 함수, 프로미스(Promises), async/await이 있음

- 콜백 함수: 다른 함수의 인자로 전달되어 실행되는 함수로 비동기 작업이 완료된 후 실행될 코드를 정의

```javascript
function fetchData(callback) {
    setTimeout(() => {
        const data = "Sample Data";
        callback(data);
    }, 1000); // 1초 후에 데이터 반환
}

fetchData(function(result) {
    console.log("Data received:", result); // "Data received: Sample Data" 출력
});
```

- 프로미스(Promise): 비동기 작업이 성공적으로 완료되었는지, 실패했는지, 진행중인지를 나타내는 객체

```javascript
function fetchData() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            const data = "Sample Data";
            resolve(data); // 작업 성공 시 호출
        }, 1000);
    });
}

fetchData()
    .then(result => {
        console.log("Data received:", result); // "Data received: Sample Data" 출력
    })
    .catch(error => {
        console.error("Error:", error);
    });
```

- async /await: 프로미스를 더 직관적이고 동기적인 코드처럼 작성할 수 있게 하는 문법으로 `async` 키워드로 함수를 선언하고, 함수 내에서 `await 키워드를 사용해 프로피스의 완료를 기다림

```javascript
async function fetchData() {
    try {
        const data = await new Promise((resolve) => {
            setTimeout(() => {
                resolve("Sample Data");
            }, 1000);
        });
        console.log("Data received:", data); // "Data received: Sample Data" 출력
    } catch (error) {
        console.error("Error:", error);
    }
}

fetchData();
```

### API

API(Application Programming Interface)는 소프트웨어 애플리케이션이 서로 통신하여 데이터, 특징 및 기능을 교환할 수 있도록 하는 일련의 규칙 또는 프로토콜

### API 호출

API를 호출하여 서버에서 데이터를 받아와서 웹페이지에 표시할 수 있음  
여기서는 Fetch API를 사용해서 실습함

### Fetch API

Fetch API는 네트워크 요청을 만들고 응답을 처리하기 위한 방법으로 프로미스를 기반으로 하며, 비동기적으로 데이터를 받아오고 처리할 수 있음

```javascript
// 기본 문법
fetch('URL')
    .then(response => response.json()) // 응답을 JSON 형식으로 변환
    .then(data => console.log(data))   // 변환된 데이터 사용
    .catch(error => console.error('Error:', error)); // 오류 처리
```

```javascript
// github API를 이용하여 유저 vivaan-park의 정보를 받아와서 출력
fetch('https://api.github.com/users/vivaan-park')
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log('User:', data);
    })
    .catch(error => console.error('There was a problem with the fetch operation:', error));
```

```javascript
// Fetch API를 이용하여 외부 API로부터 데이터를 받아와 HTML 페이지에 표시

// HTML: <div id="userData"></div>

async function loadUserData() {
    try {
        const response = await fetch('https://api.github.com/users/vivaan-park');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const data = await response.json();

        document.getElementById("userData").innerHTML = `
            <p>Name: ${data.name}</p>
            <p>Bio: ${data.bio}</p>
            <p>Location: ${data.location}</p>
        `;
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}

loadUserData();
```

## 라이브러리와 프레임워크

jQuery와 React.js 등이 있는데, 나중에 기회되면 함(프론트 개발자 아니니까;)