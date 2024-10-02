1. employees라는 테이블을 생성하고 값을 추가하세요.
   이 테이블은 다음의 컬럼을 가져야 합니다
   ● id (정수형, 기본 키)
   ● name (문자열, 최대 50자)
   ● position (문자열, 최대 100자)
   ● hire_date (날짜)
답)
```mysql
CREATE TABLE employees(
    id int PRIMARY KEY,
    name VARCHAR(50),
    position VARCHAR(100),
    hire_date DATE
);
```

2. departments라는 테이블을 생성하고 값을 추가하세요.
   이 테이블은 다음의 컬럼을 가져야 합니다
   ● department_id (정수형, 기본 키)
   ● department_name (문자열, 최대 100자)
   ● manager_id (정수형, employees 테이블의 id와 외래 키 관계)
   ● 외래키 제약조건
   : employees 테이블의 id 삭제시, id가 참조중이라면 삭제불가
답)
```mysql
# CREATE TABLE departments(
#     department_id int PRIMARY KEY,
#     department_name VARCHAR(100),
#     manager_id int,
#     FOREIGN KEY (manager_id) REFERENCES employees (id)
# );
```

3. customers라는 테이블을 생성하세요. 이 테이블은 다음의 컬럼을
   가져야 합니다:
   ● customer_id (정수형, 기본 키)
   ● email (문자열, 최대 100자, 중복 불가)
   ● phone_number (문자열, 최대 15자, 중복 불가)
답)
```mysql
CREATE TABLE customers(
    customer_id int PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15) UNIQUE
);
```

4. employees 테이블에 salary라는 정수형 컬럼을
   추가하세요.
답)
```mysql
# ALTER TABLE employees ADD salary int;
```

5. employees 테이블에서 position 컬럼의 길이를
   100자에서 150자로 수정하세요.
답)
```mysql
# ALTER TABLE employees MODIFY COLUMN position VARCHAR(150);
```

6. employees 테이블에서 hire_at 컬럼을 삭제하세요.
답)
```mysql
# ALTER TABLE employees DROP COLUMN hire_at;
```

7. orders라는 테이블을 생성하고 값을 추가하세요.
   이 테이블은 다음의 컬럼을 가져야 합니다:
   ● order_id (정수형, 기본 키, 자동 증가)
   ● order_at (날짜/시간)
답)
```mysql
CREATE TABLE orders(
    order_id int PRIMARY KEY AUTO_INCREMENT,
    order_at TIMESTAMP
);
```

8. order_items라는 테이블을 생성하고 값을 추가하세요.
   이 테이블은 다음의 컬럼을 가져야 합니다
   ● item_id (정수형, 기본 키)
   ● order_id (정수형, orders 테이블의 외래 키, 삭제 시
   관련된 레코드도 함께 삭제)
답)
```mysql
# CREATE TABLE order_items(
#     item_id int PRIMARY KEY,
#     order_id int,
#     FOREIGN KEY (order_id) REFERENCES orders (order_id) ON DELETE CASCADE 
# );
```

9. orders 테이블을 삭제하세요.
   order_items 테이블을 삭제하세요.
답)
```mysql
# DROP TABLE orders;
# DROP TABLE order_items;
```

10. employees 테이블을 삭제하세요.
    departments 테이블을 삭제하세요.
답)
```mysql
# DROP TABLE employees;
# DROP TABLE departments;
```

11 ~ 12. 
    다음은 어느 의류 쇼핑몰에서 판매중인 상품들의 상품 정보를 담은 PRODUCT 테이블과 오프라인 상품 판매 정보를 담은 OFFLINE_SALE 테이블 입니다.
    PRODUCT 테이블은 아래와 같은 구조로 PRODUCT_ID, PRODUCT_CODE, PRICE는 각각 상품 ID, 상품코드, 판매가를 나타냅니다.
    상품 별로 중복되지 않는 8자리 상품코드 값을 가지며, 앞 2자리는 카테고리 코드를 의미합니다.
    OFFLINE_SALE 테이블은 아래와 같은 구조로 되어있으며 OFFLINE_SALE_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE는
    각각 오프라인 상품 판매 ID, 상품 ID, 판매량, 판매일을 나타냅니다.
    동일한 날짜, 상품 ID 조합에 대해서는 하나의 판매 데이터만 존재합니다.

11.
    PRODUCT 테이블과 OFFLINE_SALE 테이블에서 상품코드 별 매출액(판매가 * 판매량) 합계를 출력하는 SQL문을 작성해주세요.
    결과는 매출액을 기준으로 내림차순 정렬해주시고 매출액이 같다면 상품코드를 기준으로 오름차순 정렬해주세요.
답)
```mysql
# SELECT P.PRODUCT_CODE, SUM(O.SALES_AMOUNT) * P.PRICE AS SALES
# FROM PRODUCT AS P INNER JOIN OFFLINE_SALE AS O
# ON P.PRODUCT_ID = O.PRODUCT_ID
# GROUP BY P.PRODUCT_CODE
# ORDER BY SALES DESC, PRODUCT_CODE ASC;
```

12. PRODUCT 테이블과 OFFLINE_SALE 테이블간에 PRODUCT_ID 기준으로 교집합 row를 출력해주세요
답) 금요일문제랑 같은문제네;;
```mysql
# SELECT *
# FROM PRODUCT AS P INNER JOIN OFFLINE_SALE AS O
# ON P.PRODUCT_ID = O.PRODUCT_ID;
```