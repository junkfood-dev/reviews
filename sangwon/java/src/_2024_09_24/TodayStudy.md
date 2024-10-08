# 스트림 (stream)
- 데이터의 흐름 (생성-가공-결과)
  - 생성 : 스트림 인스턴스 생성(배열이나 컬렉션을 스트림 인스턴스로 변환)
    - 컬렉션으로 스트림 생성 (주로사용)
    - 배열로 스트림 생성
    - 숫자 범위로 스트림 생성
    - 파일로부터 스트림 생성
  - 가공 : 원하는 결과를 만들어가는 중간 작업
    - 필터링 : distinct, filter
    - 매핑 : map, flatMap
    - 정렬 : sorted
    - 루핑 : peek
  - 결과 : 최종 결과를 만들어내는 작업
    - 루핑 : forEach
    - 수집 : collect()
- 특징
  - 데이터의 흐름을 나타내며, 실제로 데이터를 저장하지않는다.
  - 함수형 프로그래밍 지원 : 람다 표현식 사용가능
  - 일회용
  - 지연 연산 : 필요할 때만 연산이 이루어져 효율적인 처리가능
  - 병렬 처리 : 스트림을 쉽게 병렬로 처리
- 종류
  - Stream<T> : 객체의 스트림
  - IntStream, LongStream, DoubleStream : 기본타입을 위한 스트림
- 장점
  - 간결함 : 복잡한 반복문 대신 직관적인 코드 작성가능
  - 효율성 : 필요한 경우에만 데이터를 처리하여, 메모리 효율이 좋고, 병렬처리가 간단

## Optional
- Java 8 버전에 추가된 Wrapper클래스
- NPE(NullPointerException)를 방지 - 객체를 감쌈
- 실제 값이 있는지 여부를 체크하거나, 만약 값이 없을 경우 디폴트 값을 지정하는 기능 제공
- Optional 객체 생성 메소드
  - empty() : 아무런 값도 가지지 않는 비어있는 Optional객체 반환
  - of(T value) : null이 아닌 명시된 값을 가지는 Optional객체 반환, null이면 NPE 발생
  - ofNullable(T value) : 명시된 null이 아니면 명시된 값을 가지는 Optional객체 반환하며, 명시된 값이 null이면 비어있는 Optional객체 반환
- Optional 객체 반환 메소드
  - get() null일 경우 예외 발생(왠만하면 사용하지말자)
  - orElse() : 저장된 값이 존재하면 그 값을 반환, 값이 없으면 인수로 전달된 값 반환
  - orElseGet() : 저장된 값이 존재하면 그값을 반환, 값이 없으면 인수로 전달된 람다표현식의 결과 반환
  - orElseThrow() : 저장된 값이 존재하면 그값을 반환, 값이 없으면 예외발생
  - isPresent() : 저장된 값이 존재하면 true반환, 아니면 false
- Optional 이용한 null 처리
  - orElse() 사용
  - isPresent() 사용
  - ifPresent() 사용 : 값이 존재할 경우에만 동작