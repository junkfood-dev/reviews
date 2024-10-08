# 아주 조금 복잡한 쇼핑몰 만들기

## 프로그램 흐름

1. 제품 추가: 판매자가 제품 추가
2. 유저 등록: 새로운 유저를 등록
3. 장바구니 기능: 유저가 제품을 장바구니에 담음
4. 주문 생성: 유저가 장바구니에 담긴 제품을 주문
5. 결제: 유저가 결제 방식을 선택해서 결제
6. 주문 처리: 제품의 재고 감소, 구매 내역 추가
7. 할인 적용: 할인 조건에 따라 결제 금액 조정
8. 예외 처리: 재고 부족, 결제 오류 등 예외 상황 처리

## 클래스 설계

1. **제품 클래스**
    - 클래스명: `Product`
    - 속성
        - `name`: 제품명
        - `price`: 가격
        - `stock`: 재고
    - 메서드
        - `reduceStock`: 재고 감소 기능
        - `increaseStock`: 재고 추가 기능

2. **전자제품 클래스**
    - 클래스명: `Electronics`
    - 속성
        - `warrantyPeriod`: 보증기간, `xxxx-xx-xx` 형식의 문자열(`Date` 사용 ㄴㄴ)

3. **의류 클래스**
    - 클래스명: `Clothing`
    - 속성
        - `size`: 옷 사이즈

4. **고객 클래스**
    - 클래스명: `Customer`
    - 속성
        - `name`: 유저 이름
        - `id`: 유저 아이디, 중복되지 않는 유일한 값
        - `orderHistory`: 주문 내역
    - 메서드
        - `addOrder`: 주문 내역 추가 기능

5. **주문 클래스**
    - 클래스명: `Order`
    - 속성
        - `orderId`: 주문 번호, `0001`부터 순차적으로 증가.
        - `customer`: 주문자
        - `productList`: 제품 리스트
        - `totalAmount`: 총 주문 금액
    - 메서드
        - `calculateTotalAmount`: 총 금액 계산, 주문 금액이 200만원 이상이면 10% 할인 적용
        - `processOrder`: 주문 처리

6. **장바구니 클래스**
    - 클래스명: `Cart`
    - 속성
        - `customer`: 주문자
        - `productList`: 제품 리스트
    - 메서드
        - `addProduct`: 제품 추가
        - `removeProduct`: 제품 삭제
        - `calculateTotal`: 총 금액 계산

7. **결제 인터페이스**
    - 클래스명: `Payment`
    - 메소드
        - `pay`: 결제 처리

8. **카드 결제 클래스**
    - 클래스명: `CardPayment`
    - 메소드
        - `pay`
            - 카드 한도가 300만원 남았다고 가정하고, 300만원 초과 결제 시도 시 결제 실패 예외처리
            - `00:00` ~ `00:10` 시간은 카드회사 점검 시간으로 결제 실패 예외처리(시간은 `LocalTime` 데이터타입을 사용할 것)

9. **카카오페이 결제 클래스**
    - 클래스명: `KakaoPayment`
    - 메소드
        - `pay`
            - 최소 주문 금액 100만원이 적용되어, 100만원 미만 결제 시도 시 결제 실패 예외처리
            - `09:00` ~ `10:00` 시간은 카카오페이 이벤트 시간으로 추가 할인 5% 적용(시간은 `LocalTime` 데이터타입을 사용할 것)