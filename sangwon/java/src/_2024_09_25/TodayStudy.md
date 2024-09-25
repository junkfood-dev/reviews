# 스트림 (Stream)

### 메소드 체이닝
- 리턴 타입이 스트림일 때 사용
- 여러 메소드를 연속적으로 호출 하는 방식
```java
int x = number.stream() // 생성
        .filter()  // 가공
        .method2() // 가공
        .method3() // 가공
//        .......
        .collect(); // 결과
```

## 가공
- 필터링
  - distinct() 중복 제거
  - filter() true인 것만 필터링
- 매핑
  - map() 각 요소를 특정 값으로 변환 후, 변환 값을 스트림에 그대로 전달
  - flatMap() 각 요소를 특정 값으로 변환 후, 변환 값들을 새로운 스트림으로 만듬 (2차원 -> 1차원)
    - 예) flatMap(x -> Array.stream(x))
  - mapTo기본타입() 형변환
    - boxing() 기본타입을 래퍼타입으로
- 정렬
  - sorted() 오름차순으로 정렬
  - sorted(Comparator.reverseOrder) 내림차순 정렬
- 루핑 (요소 전체를 반복)
  - peek() 
    - 가공 중에 결과를 확인해볼 때 사용 / 특정 결과를 반환하지 않음.
    - 최종 '결과' 메소드를 호출하지 않으면 아무 일도 안 일어남.

## 결과
- 루핑
  - forEach()
- 수집
  - collect() 가공한 데이터를 컬렉션으로 변환
    - toList() 요소를 List에 저장
    - toSet() 요소를 Set에 저장 // distinct() 의미없음 Set 자체가 중복 허용 안함
    - toMap() 요소를 Map에 저장
    - toCollection() 요소를 특정 컬렉션에 저장
    - groupingBy(key, 집계 함수) 
      - collect(Collectors.groupingBy(n -> n, Collectors.counting())
        - counting() 그룹핑 후 집계하는 메소드
  - sum()