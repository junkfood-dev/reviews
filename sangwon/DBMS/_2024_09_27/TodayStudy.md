## DML 추가
WHERE 조건절에서 사용 가능
- IS NULL : NULL 값인 컬럼 
- IS NOT NULL : NULL이 아닌 컬럼 값들
- LIKE(=) : 패턴에 해당되는 행 (예. WHERE name LIKE '정약용')
  - wildcard
    - % : 어떠한 문자가 와도(없어도) 허용, 나머지 문자 (예. WHERE name LIKE '정%')
    - _ : 하나의 문자 (예. WHERE name LIKE '정__')
- IN : 여러값을 필터링 할때 // IN안에 다른 SELECT 사용해도 됨.
- NOT In : 필터링된 값을 갖고 있지 않는.

### 조건문 CASE WHEN THEN END
- CASE는 조건 시작을 알립니다.
- WHEN은 조건을 지정합니다.
- THEN은 해당 조건이 참일 때 반환할 값을 지정합니다.
- ELSE는 모든 조건이 거짓일 때 반환할 값을 지정합니다 (필수는 아님).
- END는 CASE 문의 종료를 나타냅니다.

### 그룹화
- GROUP BY 열 : 그룹화
  - 데이터 분석할 때 많이 사용
  - FROM, WHERE절 뒤에 위치
  - 어떤 열을 기준으로 그룹화할 지 명시
  - 대부분 내장 함수와 같이 씀
  - 실행 순서 FROM -> WHERE -> GROUP BY -> SELECT
  - HAVING
    - GROUP BY 절에 의해 생성된 그룹 중에서 원하는 조건에 부합하는 그룹만 선택 (필터링)
    - 실행 순서 FROM -> WHERE -> GROUP BY -> HAVING -> SELECT
### 정렬
- ORDER BY : 특정 기준에 따라 정렬
  - ASC : 오름 차순 (안적었을 때 기본값)
  - DESC : 내림 차순
  - LIMIT n : 상위 n개만 표기(row수 제한)
    - OFFSET n : 시작점(시작 인덱스) // n 이후 부터 표기
  - 실행 순서 FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY

## 여러 개의 테이블 조회하기 (RDMS에서 사용)
### JOIN
- 여러 테이블에 있는 원하는 정보를 엮는 것.(열이 합쳐짐)
- JOIN을 하려면 테이블간의 접점이 있는 데이터(KEY)가 있어야함
- FROM Table AS A INNER JOIN Table AS B ON A.열 = B.열 
- INNER JOIN : 교집함, 일치하지 않는 해당 행은 무시
- LEFT OUTER JOIN : 왼쪽 테이블의 모든 행에 반환,오른쪽 테이블에서 일치하는것이 없으면 NULL이 표시
- RIGHT OUTER JOIN : 오른쪽 테이블의 모든 행에 반환,왼쪽 테이블에서 일치하는것이 없으면 NULL이 표시
- FULL OUTER JOIN : 합집합 (MySQL에서 지원안함)

### UNION
- 두 개의 SQL 실행 결과를 결합할 때 사용, 테이블 사이의 관계성이 없어도 사용 가능
- 행이 늘어나는 형태 (row가 합쳐짐)
- 테이블 간의 열 개수와 이름, 데이터 타입이 모두 동일 해야함(SELECT 컬럼 정보)
- 중복된 row는 하나만 출력됨
  - UNION ALL : 중복되도 다 출력 (값을 제거하는 작업이 없어 성능이 더 좋음)

## 서브 쿼리
- 하나의 SQL문 안에 포함되어 있는 또 다른 SQL문
- 서브 쿼리는 괄호로 감싸며, 메인 쿼리의 일부로 사용
- 메인쿼리가 실행되기 전에 먼저 실행 됨.
- 스칼라 서브 쿼리 : SELECT 절 안에서 사용하는 서브쿼리 -> 하나의 값만 리턴해야함
- FROM절 서브 쿼리 : 서브 쿼리의 결과를 마치 가상의 테이블처럼 사용
- WHERE절 서브 쿼리 : 서브 쿼리의 결과를 WHERE 조건에서 필터링에 사용(보통 IN 안에 많이씀)