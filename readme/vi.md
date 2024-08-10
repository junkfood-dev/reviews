# Vi 사용하기

## 주의! 아래 내용은 [terminal](terminal.md) 실습 후에 진행할 것

## Vi 기본 조작

- Vi는 명령 모드(입력이 안되는 모드, esc 눌렀을 때의 모드)와 입력 모드로 나뉨 ~~visual 모드도 있지만 여기선 다루지 않음~~
- vi filename: 파일 열기  
  `vi file1.txt`
- 명령 모드에서 i: 입력 모드로 전환하여 텍스트 입력
- esc: 명령 모드로 돌아오기
- :w: 파일 저장  
  `:w`
- :q: Vi 종료  
  `:q`
- :wq: 저장 후 종료  
  `:wq`
- :q!: 저장하지 않고 종료  
  `:q!`

### terminal 폴더에서 todo_list.txt 파일을 열어보기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
vi todo_list.txt
```

</div>
</details>

### todo_list.txt 파일의 첫 번째 줄에 "Hello, World!", 두 번째 줄에 "TODO LIST" 입력하고 저장 후 종료하기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
i 누르고 Hello, World! 쓰기
엔터 누르고 TODO LIST 쓰기
esc 누르고 :wq 입력 후 엔터 누르기
```

</div>
</details>

###          

## 텍스트 조작(명령 모드에서 입력해야 함)

- dd: 한 줄 삭제
- x: 한 글자 삭제
- yy: 한 줄 복사
- p: 현재 커서 위치 아래에 붙여넣기
- h, j, k, l: 커서 이동(키보드 방향키 기능)

### todo_list.txt 파일의 첫 번째 줄을 복사해서 세 번째 줄에 붙여넣기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
첫 번째 줄에서 yy
두 번째 줄로 커서 이동 후 p
:wq 입력하고 엔터로 저장

내용이 아래처럼 나와야함

Hello, World!
TODO LIST
Hello, World!
```

</div>
</details>

### todo_list.txt 파일의 세 번째 줄의 ","를 삭제하기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
세 번쨰 줄의 ,에 커서를 위치시키고 esc를 누른 후 x를 누름
:wq 입력하고 엔터로 저장

내용이 아래처럼 나와야함

Hello, World!
TODO LIST
Hello World!
```

</div>
</details>

## 고급 편집 기능

- /검색어: 검색  
  `/word`
- :%s/기존텍스트/바꿀텍스트/g: 전체 파일에서 [기존텍스트]를 [바꿀텍스트]로 변환  
  `:%s/Hello/World/g`

### todo_list.txt 파일에서 "LIST"를 "List"로 변경하기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
:%s/LIST/List/g 입력하고 엔터
:wq 입력하고 엔터로 저장

Hello, World!
TODO List
Hello World!
```

</div>
</details>