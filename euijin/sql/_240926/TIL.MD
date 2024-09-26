```sql
-- 데이터베이스 용어
- 테이블 : 데이터베이스에서 데이터를 구성하기 위한 가장 기본적 단위, 행과 열로 이루어짐
- 행 : 테이블의 가로로 배열된 데이터의 집합
- 열 : 테이블의 행에 저장되는 유형의 데이터
- 기본키(primary key) : 행을 구분할 수 있는 식별자, 유일해야하며 중복 값 X
- 쿼리 : 데이터를 생성,조회,수정,삭제 등 처리를 하기 위해 사용하는 명령문

-- 조회 : SELECT
-- 삽입 : INSERT
-- 수정 : UPDATE
-- 삭제 : DELETE

-- 내장함수
SELECT SUM(age) -- WHERE 조건절 , FROM을 본 후에 최종적으로 SUM 실행
FROM students
WHERE age BETWEEN 25 AND 30
;

-- 내장함수의 종류
-- SUM, AVG, MAX, MIN, COUNT(행의 개수)-> 위의 예시에서 28, 29, 30 총 3개
-- SELECT CONCAT(name,address) -> 이황경상북도, 정약용경기도, ...
-- CHAR_LENGTH -> 문자열의 길이
-- REPLACE(address, '도', '레') -> 경상북레, 경기레, ...
SELECT address, CHAR_LENGTH(address)
FROM students
; -- 경상북도 4, 경기도 3, ...
```