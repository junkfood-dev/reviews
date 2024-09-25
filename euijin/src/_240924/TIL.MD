Stream - 데이터의 흐름, 배열이나 컬렉션을 가공하여 원하는 결과 얻을 수 있음

## 스트림을 만드는 방법
- 컬렉션으로부터 스트림 생성 -> java.util.Collection 인터페이스는 stream() 메서드를 제공
```java
List<String> list = Arrays.asList("a", "b", "c", "d", "e"); // 배열 -> List로 변환

Stream<String> stream = list.stream();
stream.forEach(System.out::println);
```
- 배열에서의 스트림 생성 -> Arrays.stream() 메소드 사용
  
```java
String[] arr = new String[]{"a", "b", "c", "d", "e"};
Stream<String> stream = Arrays.stream(arr);
stream.forEach(System.out::println);
```
- 숫자 범위로부터 스트림 생성 
    - range 
    - rangeClosed
```java
IntStream intStream = IntStream.range(1, 5);	// [1, 2, 3, 4]
LongStream longStream = LongStream.rangeClosed(1, 5);	// [1, 2, 3, 4, 5]
DoubleStream doubleStream = DoubleStream.of(1,2,3);   // [1.0, 2.0, 3.0]
```
- 파일로부터 스트림 생성
```java
Stream<String> fileStream = Files.lines(Paths.get("file.txt"),Charset.forName("UTF-8"));
// Files.lines()  -> 지정된 파일을 한줄씩 스트림으로 읽는 메소드, 반환타입 = Stream<String>
// Paths.get("file.txt") -> 파일의 경로 (?)
// Charset.forName("UTF-8") -> "UTF-8" 인코딩 방식을 사용하는 Charset 객체 생성
// Stream<String> fileStream -> 파일의 각 줄을 스트림으로 읽어드림. 파일의 각 줄이 스트림에서 하나의 String으로 취급
fileStream.forEach(System.out::println);
```
- 스트림 연결 -> Stream.concat() 사용
```java
Stream<Integer> stream1 = Stream.of(1, 2, 3);
Stream<Integer> stream2 = Stream.of(4, 5, 6);

Stream<Integer> newStream = Stream.concat(stream1, stream2);
newStream.forEach(System.out::println); // 1, 2, 3, 4, 5, 6
```

## Optional
- NullPointerException을 방지하기 위해 도입된 개념
- 간단하게 null을 포함한 모든 데이터를 저장할 수 있는 Wrapper 클래스
- 객체가 null인지 아닌지 모를경우 Optional로 감싸서 실제 값의 유무를 확인하거나 default 값을 지정가능

```java
    List<String> list = null;

        // Optional로 감싸기
        Optional<List<String>> optional = Optional.ofNullable(list);
        optional.orElseGet(Collections::emptyList) // list가 null이면 emptyList 반환, 이를 순회
                //Collections.emptyList => 비어있는 list collection
                .forEach(System.out::println);  // NPE 안뜸, 빈 리스트 이므로 출력되지 않음 

        Optional<Integer> empty = Optional.empty();
        Optional<Integer> optional2 = Optional.of(456);  // of() 쓰려면 무조건 null이 아닌값 입력

        Integer value = empty.orElse(123); // 비어있으므로 default값인 123 출력, 들어있으면 안의 값 출력
```

### Optional 이용한 Null 처리 방법 예시
```java
List<Integer> list = new ArrayList<>();

// NoSuchElementException 예외 발생
double avg = list.stream()
             .mapToInt(Integer::intValue)
             .average()
             .getAsDouble();  // 여기에서 문제 발생 가능

System.out.println(avg);
```
- isPresent() 사용
```java
List<Integer> list = new ArrayList<>();

OptionalDouble optionalDouble = list.stream()
                 .mapToInt(Integer::intValue)
                 .average();
// isPresent()로 값이 존재하는지 확인
if (optionalDouble.isPresent()) {
    double avg = optionalDouble.getAsDouble();
    System.out.println(avg);
    }
```
- default 값을 정하는 orElse 사용
```java
List<Integer> list = new ArrayList<>();

OptionalDouble optionalDouble1 = list.stream()
				.mapToInt(Integer::intValue)
				.average()
    double result = optionalDouble1.orElse(0.0);  // 평균 값이 존재하지 않을 경우 0을 사용
				
System.out.println(avg);  // 0.0
```
- ifPresent() 사용
```java
List<Integer> list = new ArrayList<>();

OptionalDouble optionalDouble2 = list.stream()
	.mapToInt(Integer::intValue)
	.average();
optionalDouble2.ifPresent(System.out::println);;  // 평균 값이 있을 경우에만 출력
```