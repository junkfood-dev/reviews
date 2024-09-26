### 문제 설명  
ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

| NAME             | TYPE       | NULLABLE |
|------------------|------------|----------|
| ANIMAL_ID        | VARCHAR(N) | FALSE    |
| ANIMAL_TYPE      | VARCHAR(N) | FALSE    |
| DATETIME         | DATETIME   | FALSE    |
| INTAKE_CONDITION | VARCHAR(N) | FALSE    |
| NAME             | VARCHAR(N) | TRUE     |
| SEX_UPON_INTAKE  | VARCHAR(N) | FALSE    |
동물 보호소에 들어온 모든 동물의 정보를 ANIMAL_ID순으로 조회하는 SQL문을 작성해주세요. SQL을 실행하면 다음과 같이 출력되어야 합니다.

| ANIMAL_ID | ANIMAL_TYPE | DATETIME            | INTAKE_CONDITION | NAME   | SEX_UPON_INTAKE |
|-----------|-------------|---------------------|------------------|--------|-----------------|
| A349996   | Cat         | 2018-01-22 14:32:00 | Normal           | Sugar  | Neutered Male   |
| A350276   | Cat         | 2017-08-13 13:50:00 | Normal           | Jewel  | Spayed Female   |
| A350375   | Cat         | 2017-03-06 15:01:00 | Normal           | Meo    | Neutered Male   |
| A352555   | Dog         | 2014-08-08 04:20:00 | Normal           | Harley | Spayed Female   |

```sql
SELECT ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC
;
```

### 문제 설명
다음은 식품공장의 정보를 담은 FOOD_FACTORY 테이블입니다. FOOD_FACTORY 테이블은 다음과 같으며 FACTORY_ID, FACTORY_NAME, ADDRESS, TLNO는 각각 공장 ID, 공장 이름, 주소, 전화번호를 의미합니다.

| Column name  | Type         | Nullable |
|--------------|--------------|----------|
| FACTORY_ID   | VARCHAR(10)  | FALSE    |
| FACTORY_NAME | VARCHAR(50)  | FALSE    |
| ADDRESS      | VARCHAR(100) | FALSE    |
| TLNO         | VARCHAR(20)  | TRUE     |

| FACTORY_ID | FACTORY_NAME | ADDRESS                  | TLNO         |
|------------|--------------|--------------------------|--------------|
| FT19980003 | (주)맛있는라면     | 강원도 정선군 남면 칠현로 679       | 033-431-3122 |
| FT19980004 | (주)맛있는기름     | 경기도 평택시 포승읍 포승공단순환로 245  | 031-651-2410 |
| FT20010001 | (주)맛있는소스     | 경상북도 구미시 1공단로7길 58-11    | 054-231-2121 |
| FT20010002 | (주)맛있는통조림    | 전라남도 영암군 미암면 곤미현로 1336   | 061-341-5210 |
| FT20100001 | (주)맛있는차      | 전라남도 장성군 서삼면 장산리 233-1번지 | 061-661-1420 |
| FT20100002 | (주)맛있는김치     | 충청남도 아산시 탕정면 탕정면로 485    | 041-241-5421 |
| FT20100003 | (주)맛있는음료     | 강원도 원주시 문막읍 문막공단길 154    | 033-232-7630 |
| FT20100004 | (주)맛있는국      | 강원도 평창군 봉평면 진조길 227-35   | 033-323-6640 |
| FT20110001 | (주)맛있는밥      | 경기도 화성시 팔탄면 가재리 34번지     | 031-661-1532 |
| FT20110002 | (주)맛있는과자     | 광주광역시 북구 하서로 222         | 062-211-7759 |

### 출력 결과
| FACTORY_ID | FACTORY_NAME | ADDRESS                |
|------------|--------------|------------------------|
| FT19980003 | (주)맛있는라면     | 강원도 정선군 남면 칠현로 679     |
| FT20100003 | (주)맛있는음료     | 강원도 원주시 문막읍 문막공단길 154  |
| FT20100004 | (주)맛있는국      | 강원도 평창군 봉평면 진조길 227-35 |

```sql
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
FROM FOOD_FACTORY
WHERE ADDRESS LIKE('강원도%')
ORDER BY FACTORY_ID ASC
;
```



### 문제 설명
ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

| NAME             | TYPE       | NULLABLE |
|------------------|------------|----------|
| ANIMAL_ID        | VARCHAR(N) | FALSE    |
| ANIMAL_TYPE      | VARCHAR(N) | FALSE    |
| DATETIME         | DATETIME   | FALSE    |
| INTAKE_CONDITION | VARCHAR(N) | FALSE    |
| NAME             | VARCHAR(N) | TRUE     |
| SEX_UPON_INTAKE  | VARCHAR(N) | FALSE    |

### 문제
동물 보호소에 동물이 몇 마리 들어왔는지 조회하는 SQL 문을 작성해주세요.

### 예시
ANIMAL_INS 테이블이 다음과 같다면:

| ANIMAL_ID | ANIMAL_TYPE | DATETIME            | INTAKE_CONDITION | NAME     | SEX_UPON_INTAKE |
|-----------|-------------|---------------------|------------------|----------|-----------------|
| A399552   | Dog         | 2013-10-14 15:38:00 | Normal           | Jack     | Neutered Male   |
| A379998   | Dog         | 2013-10-23 11:42:00 | Normal           | Disciple | Intact Male     |
| A370852   | Dog         | 2013-11-03 15:04:00 | Normal           | Katie    | Spayed Female   |
| A403564   | Dog         | 2013-11-18 17:03:00 | Normal           | Anna     | Spayed Female   |

동물 보호소에 들어온 동물은 4마리입니다. 따라서 SQL문을 실행하면 다음과 같이 나와야 합니다:

| count |
|-------|
| 4     |

※ 컬럼 이름(위 예제에서는 `count`)은 일치하지 않아도 됩니다.
```sql
SELECT COUNT(*) AS count
FROM ANIMAL_INS
;
```