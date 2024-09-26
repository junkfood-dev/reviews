ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다.
ANIMAL_INS 테이블 구조는 다음과 같으며,
ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는
각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

1. 동물 보호소에 동물이 몇 마리 들어왔는지 조회하는 SQL 문을 작성해주세요.
답)
```mysql
-- SELECT COUNT(ANIMAL_ID) AS COUNT
-- FROM ANIMAL_INS;
```

2.  동물 보호소에 들어온 동물의 이름은 몇 개인지 조회하는 SQL 문을 작성해주세요.
    이때 이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나로 칩니다.
답)
```mysql
# SELECT COUNT(DISTINCT(NAME)) AS COUNT
# FROM ANIMAL_INS
# WHERE NAME IS NOT NULL;
```

3. 다음은 어느 의류 쇼핑몰에서 판매 중인 상품들의 정보를 담은 PRODUCT 테이블입니다.
    PRODUCT 테이블은 아래와 같은 구조로 되어있으며,
    PRODUCT_ID, PRODUCT_CODE, PRICE는 각각 상품 ID, 상품코드, 판매가를 나타냅니다.
    PRODUCT 테이블에서 판매 중인 상품 중 가장 높은 판매가를 출력하는 SQL문을 작성해주세요.
    이때 컬럼명은 MAX_PRICE로 지정해주세요.
답)
```mysql
# SELECT MAX(PRICE) AS MAX_PRICE
# FROM PRODUCT;
```

4.  다음은 어느 한 게임에서 사용되는 아이템들의 아이템 정보를 담은 ITEM_INFO 테이블입니다.
    ITEM_INFO 테이블은 다음과 같으며, ITEM_ID, ITEM_NAME, RARITY, PRICE는
    각각 아이템 ID, 아이템 명, 아이템의 희귀도, 아이템의 가격을 나타냅니다.
    ITEM_INFO 테이블에서 희귀도가 'LEGEND'인 아이템들의 가격의 총합을 구하는 SQL문을 작성해 주세요.
    이때 컬럼명은 'TOTAL_PRICE'로 지정해 주세요.
답)
```mysql
# SELECT SUM(PRICE) AS TOTAL_PRICE
# FROM ITEM_INFO
# WHERE RARITY = 'LEGEND';
```

5.  낚시앱에서 사용하는 FISH_INFO 테이블은 잡은 물고기들의 정보를 담고 있습니다.
    FISH_INFO 테이블의 구조는 다음과 같으며 ID, FISH_TYPE, LENGTH, TIME은
    각각 잡은 물고기의 ID, 물고기의 종류(숫자), 잡은 물고기의 길이(cm), 물고기를 잡은 날짜를 나타냅니다.
    FISH_INFO 테이블에서 잡은 물고기 중 가장 큰 물고기의 길이를 'cm' 를 붙여 출력하는 SQL 문을 작성해주세요.
    이 때 컬럼명은 'MAX_LENGTH' 로 지정해주세요.
답)
```mysql
# SELECT CONCAT(MAX(LENGTH), 'cm') AS MAX_LENGTH
# FROM FISH_INFO;
```