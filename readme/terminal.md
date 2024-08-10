# Terminal 사용하기

## 기본 명령어

- man [명령어]: [명령어]에 대한 설명(명령어의 옵션등을 확인할 수 있음)
- pwd: 현재 작업 중인 디렉토리 확인  
  `pwd`
- ls: 디렉토리 내 파일과 폴더 목록 보기  
  `ls` 현재 디렉토리 내의 파일과 디렉토리 목록을 출력하는 명령어  
  `ls -l` 각 파일과 디렉토리의 상세 정보(권한, 소유자, 파일 크기, 생성 날짜 등)를 출력
- cd: 디렉토리 이동  
  `cd folder1` folder1 디렉토리로 이동  
  `cd ..` 상위 디렉토리로 이동
- mkdir: 새 디렉토리 생성  
  `mkdir folder1` folder1이라는 새 디렉토리 생성
- touch: 새 파일 생성  
  `touch file1.txt` file1.txt라는 빈 파일 생성
- rm: 파일 삭제 (디렉토리 삭제의 경우 rm -r)  
  `rm file1.txt` file1.txt라는 파일 삭제  
  `rm -r folder1` folder1이라는 폴더 삭제

### 아래 주어진 폴더 구조대로 폴더를 생성 해보기(파일의 내용은 비워져있어도 됨)

```
terminal/
├── src/
│   ├── main.txt
│   └── utils.txt
├── include/
│   └── utils.txt
└── docs/
    └── complete.md
```

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
mkdir terminal
mkdir -p terminal/src
mkdir -p terminal/include
mkdir -p terminal/docs
touch terminal/src/main.txt
touch terminal/src/utils.txt
touch terminal/include/utils.txt
touch terminal/docs/complete.md
```

</div>
</details>

### terminal 폴더에서 하위 폴더로 이동하지 않고 complete.md 파일 삭제하기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
rm docs/complete.md
```

</div>
</details>

### terminal 폴더에서 src 폴더로 이동해서 test.txt 파일 생성하기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
cd src
touch test.txt
```

</div>
</details>

## 파일 및 디렉토리 조작

- cp: 파일 및 디렉토리 복사 (디렉토리 복사의 경우 cp -r)  
  `cp file1.txt file1_copy.txt` file1.txt라는 파일을 file1_copy.txt로 복사  
  `cp -r folder1 folder1_copy` folder1라는 폴더를 folder1_copy로 복사
- mv: 파일 및 디렉토리 이동 및 이름 변경  
  `mv file1.txt folder1/` file1.txt라는 파일을 folder1라는 폴더로 이동  
  `mv file1.txt file2.txt` file1.txt라는 파일을 file2.txt라는 이름으로 변경
- find: 파일 및 디렉토리 검색  
  `find . -name "file1.txt"` 현재 디렉토리와 하위 디렉토리에서 file1.txt라는 파일을 검색  
  `find . -name "file*.txt"` 현재 디렉토리와 하위 디렉토리에서 file로 시작하고 .txt로 끝나는 파일을 검색

여러 파일과 디렉토리를 복사하고 이동하는 연습을 시킴

### terminal 폴더에서 src 폴더를 src_backup 이라는 이름으로 복사하기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
cp -r src src_backup
```

</div>
</details>

### terminal 폴더에서 test.txt 파일을 include 폴더로 이동하기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
mv src/test.txt include/
```

</div>
</details>

### terminal 폴더에서 include 폴더로 이동 후 test.txt 파일의 이름을 excellent.txt 로 변경하기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
mv test.txt excellent.txt
```

</div>
</details>

## 고급 명령어

- grep: 파일 내 특정 텍스트 검색  
  `grep "Hello" file1.txt` file1.txt 파일에서 “Hello”라는 텍스트가 포함된 줄을 출력  
  `grep -r "Hello" .` 현재 디렉토리와 하위 디렉토리에서 “Hello”라는 텍스트가 포함된 파일을 찾아 그 줄을 출력
- cat, less, head, tail: 파일 내용 확인  
  `cat file1.txt` file1.txt 파일 전체 내용 출력  
  `less file1.txt` file1.txt 파일 내용을 페이지 단위로 스크롤하며 확인  
  `head -n 5 file1.txt` file1.txt 파일의 처음 5줄을 출력  
  `tail -n 3 file1.txt` file1.txt 파일의 마지막 3줄을 출력
- ~~chmod, chown: 파일 및 디렉토리 권한 변경~~ 윈도우 환경에서는 우선 제외

### 주의! 아래 실습은 [vi](vi.md) 실습 후에 진행할 것

### terminal 폴더에서 "TODO" 라는 텍스트가 포함된 파일을 찾기

<details>
<summary>이것은 정답이므로 도저히 모르겠다 싶을 때만 펼쳐볼 것</summary>
<div markdown="1">

```
grep -r "TODO" terminal/
```

</div>
</details>

### learn.txt 파일의 처음 2줄을 출력하기
