# html css js 복습을 위한 저장소

## 시작하기

1. 아래 명령어를 입력해서 저장소를 클론한다.  
   `git clone https://github.com/junkfood-dev/html-css-js.git`
2. 각자 자기 `이름/공부내용`의 브랜치를 만들고 생성한 브랜치로 변경한다.  
   `git branch jisung/html` 이후 `git switch jisung/html`  
   또는 `git switch -c jisung/html` (브랜치 생성 후 바로 변경)
3. 복습 자료를 작성 후 `commit` `push` 한다.
4. `main` 브랜치로 pull request를 요청한다.

## 주의사항

1. 작업 전 `git pull`을 한다.
2. `main` 브랜치가 아닌 `이름/공부내용` 브랜치를 새로 만들어서 작업한다.
3. 만약 브랜치를 생성하는 것을 까먹고, `main`브랜치 혹은 다른 브랜치에 작업했다면, 아래 내용을 따라한다.
    1. 새로운 브랜치 생성 및 전환  
       `git switch -c jisung/html`
4. 만약 3번의 상황에서 `main` 브랜치에 커밋을 해버렸다면 아래를 따라한다.
    1. 새로운 브랜치 생성  
       `git branch jisung/html`
    2. 만약 터미널이 아닌 인텔리제이 기능으로 브랜치를 생성했을 경우 브랜치가 변경되니 다시 `main` 브랜치로 변경해야함
    3. `main` 브랜치 초기화  
       `git fetch origin`  
       `git reset --hard origin/main`
    4. 이렇게 하면 위에서 생성한 새로운 브랜치로 커밋 내용이 변경되므로 브랜치를 변경하여 작업 진행