# 람다식 (함수형 프로그래밍 스타일)
- Java 8버전에서 추가됨
- 메소드를 간단한 식으로 표현하는 방법
- 익명함수를 생성하기 위한 식
- Java에서는 람다식을 하나의 객체로 취급할 수 있음 (익명 구현 객체)
- (매개변수) -> {실행코드}
  - 타입 메소드명 (매개변수) {실행문} 을 (매개변수) -> {실행문}
  - 매개변수의 타입도 제거가능
  - 반환값이 있는 경우에는 return문도 생략가능(세미콜론도 제거)
  - 하나의 매개변수만 있다면 괄호 생략가능 (매개변수가 없으면 ()써야함.)
  - 하나의 실행문만 있다면 중괄호 생략가능
- 장점
  - 코드가 매우 간결해짐
  - 컬렉션 요소를 필터링 하거나 매핑해서 원하는 결과를 쉽게 집계
  - 함수형 프로그래밍 지원
  - 병렬 처리와 성능 향상
- 단점
  - 디버깅시 가독성 하락
    - 복잡한 람다식 사용하면 문제가 발생했을 때 원인찾기가 어려움
  - 코드가 너무 간결해져 가독성이 하락할 수 있음.
  - 함수형 프로그래밍 스타일로 전환되면서 객체지향적인 특징을 덜 강조하게 됨.
  - Java 8이전의 코드와 통합할 때 호환성 문제

## 함수형 인터페이스
- 단 하나의 추상 메소드만 선언된 인터페이스
- 두 개 이상의 추상 메소드선언을 방지하고 싶으면 @FunctionalInterface 사용
- 재사용 가능한 코드를 만들 수 있다.
  - 필요한 부분만 매개변수화 하여 사용
- 람다식으로 구현 가능
- Java에서 제공해주는 함수형 인터페이스
  - 앞에 Bi가 붙으면 매개변수 2개
  - 앞에 타입1To타입2 : 매개변수는 타입1 반환값은 타입2
    - Runnable : 매개변수와 리턴이 없음
      - run() : 코드 블록 실행
    - Supplier<T> : 매개변수는 없고, 반환 값만 있음
      - get() : 값 반환
    - Consumer<T> : 매개변수는 있고, 반환 값이 없음
      - accept() : 매개변수 전달
    - Function<T, R> : 하나의 매개변수를 받아서 반환 (일반적인 함수)
      - apply() : 매개변수 전달하여 반환받음
    - Predicate<T> : 하나의 매개변수를 받아서 boolean으로 반환 (조건식을 표현)
      - test() : 매개변수 평가

## 메소드 참조
- 메소드를 참조해서 매개변수의 정보 및 리턴 타입을 알아내어, 람다식에서 불필요한 매개변수를 제거
- 간단한 작업이나 이미 존재하는 메소드를 재사용하는 경우에 사용
- 람다식을 더 간단하게
  - 정적(static)메소드 참조
    - 클래스::메소드
  - 인스턴스 메소드 참조
    - 참조변수::메소드
  - 매개변수의 메소드 참조
    - 클래스::instanceMethod
  - 생성자 참조
    - 클래스::new
- 가독성이 매우 떨어짐