1~3
ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다.
ANIMAL_INS 테이블 구조는 다음과 같으며,
ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는
각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

1. 동물 보호소에 들어온 모든 동물의 정보를 ANIMAL_ID순으로 조회하는 SQL문을 작성해주세요.
답)
```mysql
# SELECT *
# FROM ANIMAL_INS
# ORDER BY ANIMAL_ID;
```
2.  동물 보호소에 들어온 동물 중, 이름이 있는 동물의 ID를 조회하는 SQL 문을 작성해주세요.
    단, ID는 오름차순 정렬되어야 합니다.
답)
```mysql
# SELECT ANIMAL_ID
# FROM ANIMAL_INS
# WHERE NAME IS NOT NULL
# ORDER BY ANIMAL_ID;
```
3.  ANIMAL_OUTS 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블입니다.
    ANIMAL_OUTS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME는
    각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다.
    ANIMAL_OUTS 테이블의 ANIMAL_ID는 ANIMAL_INS의 ANIMAL_ID의 외래 키입니다.
    천재지변으로 인해 일부 데이터가 유실되었습니다. 입양을 간 기록은 있는데,
    보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.
답)
```mysql
# SELECT O.ANIMAL_ID, O.NAME
# FROM ANIMAL_OUTS AS O
# LEFT OUTER JOIN ANIMAL_INS AS I
#     ON O.ANIMAL_ID = I.ANIMAL_ID
# WHERE I.ANIMAL_ID IS NULL
# ORDER BY ANIMAL_ID
```
4.
    FOOD_FACTORY 테이블은 다음과 같으며 FACTORY_ID, FACTORY_NAME, ADDRESS, TLNO는
    각각 공장 ID, 공장 이름, 주소, 전화번호를 의미합니다.
    FOOD_FACTORY 테이블에서 강원도에 위치한 식품공장의
    공장 ID, 공장 이름, 주소를 조회하는 SQL문을 작성해주세요.
    이때 결과는 공장 ID를 기준으로 오름차순 정렬해주세요.
답)
```mysql
# SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
# FROM FOOD_FACTORY
# WHERE ADDRESS LIKE '강원도%'
# ORDER BY FACTORY_ID;
```
5. 두 테이블 Orders와 Customers를 CustomerID 필드를 사용하여 관계를 맺는 JOIN 절의 빈칸 부분을 삽입하세요.
답)
```mysql
# SELECT *
# FROM Orders AS o
# LEFT OUTER JOIN Customers AS c
#     ON o.CustomerID = c.CustomerID; -- 여기 줄이 빈칸
```
6. 두 테이블 Orders와 Customers를 CustomerID 필드를 사용하여 일치하는 모든 레코드를 선택하기 위한 올바른 SQL 문을 작성하세요.
답)
```mysql
# SELECT *
# FROM Orders AS o
# INNER JOIN Customers AS c
#     ON o.CustomerID = c.CustomerID;
```
7.  두 테이블 Orders와 Customers를 CustomerID 필드를 사용하여
    Customers 테이블의 모든 레코드와 Orders 테이블의 일치하는 모든 레코드를 선택하기 위한 올바른 SQL 문을 작성하세요.
답)
```mysql
# SELECT *
# FROM Customers AS c
# LEFT OUTER JOIN Orders AS o
#     ON c.CustomerID  = o.CustomerID;
```
8.  두 테이블 Orders와 Customers를 CustomerID 필드를 사용하여
    Customers 테이블의 모든 레코드와 Orders 테이블에서의 일치하는 모든 레코드를 선택하기 위한 올바른 SQL 문을 작성하세요.
```mysql
# SELECT *
# FROM Orders AS o
# RIGHT OUTER JOIN Customers AS c
#     ON o.CustomerID = c.CustomerID;
```
9. 아래 PRODUCT 테이블과 OFFLINE_SALE 테이블 PRODUCT_ID 기준으로 교집합 row를 출력해주세요.
```mysql
CREATE TABLE PRODUCT (
    PRODUCT_ID INTEGER PRIMARY KEY,
    PRODUCT_CODE VARCHAR(8) NOT NULL,
    PRICE INTEGER NOT NULL    
);
CREATE TABLE OFFLINE_SALE (
    OFFLINE_SALE_ID INTEGER PRIMARY KEY,
    PRODUCT_ID INTEGER NOT NULL,
    SALES_AMOUNT INTEGER NOT NULL,
    SALES_DATE DATE NOT NULL    
);
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_CODE, PRICE) VALUES
    (1, 'A1000011', 15000),
    (2, 'A1000045', 8000),
    (3, 'C3000002', 42000);
INSERT INTO OFFLINE_SALE (OFFLINE_SALE_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE) VALUES
    (1, 1, 2, '2024-02-21'),
    (2, 1, 2, '2024-03-02'),
    (3, 3, 3, '2024-05-01'),
    (4, 2, 1, '2024-05-24'),
    (5, 1, 2, '2024-06-14'),
    (6, 2, 1, '2024-06-22');
```
답)
```mysql
# SELECT *
# FROM PRODUCT AS P
#     INNER JOIN OFFLINE_SALE AS O
#     ON P.PRODUCT_ID = O.PRODUCT_ID;
```