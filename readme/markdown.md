# Markdown

## Header 작성하기

마크다운에서는 `#`을 사용해서 Header를 작성함

```
# H1 Header
## H2 Header
### H3 Header
#### H4 Header
##### H5 Header
###### H6 Header
```

### "Hello"를 H1, "World!"를 H2로 작성하기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
# Hello
## World!
```

# Hello

## World!

</div>
</details>

---

## 줄바꿈 사용하기

- 줄바꿈: 글의 마지막에 공백 2개 추가(스페이스바 2번)

### 자신의 이름과 오늘 날짜를 두 줄로 작성하기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
아래의 "박지성" 글자 뒤에 공백 2개를 추가한다

박지성  
2024.08.11
```

박지성  
2024.08.11

</div>
</details>

---

## 텍스트 서식 사용하기

- `**내용**`: **텍스트를 bold(굵게, 진하게) 처리함**
- `*내용*`: *텍스트를 이탤릭(기울임) 처리함*
- `~~내용~~`: ~~텍스트에 취소선을 적용함~~

### 자신의 생일을 굵게, 기울임, 취소선을 모두 적용해보기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
~~***1991.07.06***~~
```

~~***1991.07.06***~~

</div>
</details>

---

## 리스트 사용하기

- 순서가 있는 리스트

```
1. 내용1
2. 내용2
3. 내용3
```

- 순서가 없는 리스트

```
- 내용1
- 내용2
- 내용3
```

### 오늘 복습 혹은 공부한 내용을 순서가 있는 리스트로 작성하고, 장 본 물품을 순서가 없는 리스트로 작성하기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
1. 공부좀
2. 해라
3. 자지말고

- 나는
- 장을
- 안봤음
```

1. 공부좀
2. 해라
3. 자지말고

- 나는
- 장을
- 안봤음

</div>
</details>

---

## 링크와 이미지 추가하기

- `[텍스트](경로)`: 텍스트에 경로 링크를 추가
- `![이미지설명](경로)`: 경로의 이미지를 추가

### `Google`이라는 글자에 `https://google.com` 링크를 추가하고, 아래에 아무 이미지 넣어보기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
[Google](https://google.com)
![이미지 없음](나는 이미지가 없다)
```

[Google](https://google.com)  
![이미지 없음](no_image.jpg)

</div>
</details>

---

## 코드 블록 작성해보기

- 한줄 코드: ``` `내용` ```
- 여러줄 코드

````
```하이라이팅 할 언어
내용
```

예를 들면,
```html
<!doctype html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
    <body>
    <h1>Hello World!</h1>
    </body>
</html>
```
````

### 여러줄 코드 블록에 이전에 작성했던 html 복습 내용 아무거나 써보기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

````
```html
난 html을 안해서..
```
````

```html
<!doctype html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<h1>Hello World!</h1>
</body>
</html>
```

</div>
</details>

---

## 인용문 써보기

`> 내용`으로 인용문 작성

### 인용문으로 명언 하나 써보기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
> 뒤지기 싫으면 공부 하자
```

> 뒤지기 싫으면 공부 하자
> > 참고로 ">>" 또는 "> >" 이렇게 쓰면 중첩도 된다

</div>
</details>

---

## 표 작성하기

```
| 제목1 | 제목2 | 제목3 |   -> 제목
|-----|-----|-----|   -> 구분선
| 내용1 | 3  | 내용5 |   -> 밑으로 항목들
| 내용2 | 4  | 내용6 |
```

### 친구들의 정보를 표로 작성해보기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
| 이름 | 나이 | 현상금  |
|----|----|------|
| 의진 | 82 | 50베리 |
| 상원 | 79 | 2베리  |
```

| 이름 | 나이 | 현상금  |
|----|----|------|
| 의진 | 82 | 50베리 |
| 상원 | 79 | 2베리  |

</div>
</details>
