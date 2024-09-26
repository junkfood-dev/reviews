1. List<Integer>가 주어졌을 때, 각 숫자를 제곱한 값의
리스트로 변환하세요
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> list = numbers.stream()
        .map(x -> x * x)
        .toList();
```

2. List<String>의 문장들을 단어로 나누어(‘:’구분자) 하나의 List<String>로 변환하세요.
```java
List<String> sentences = Arrays.asList("Hello:world", "Java:stream:flatMap", "Functional:programming");
        List<String> stringList = sentences.stream()
                .flatMap(x -> Arrays.stream(x.split(":"))).toList();
```
3. 이차원 컬렉션에 들어있는 정수들을 하나의 컬렉션으로
   변환해주세요
```java
List<List<Integer>> numbers = Arrays.asList(
        Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
List<Integer> integerList = numbers.stream()
                .flatMap(x -> x.stream())
                .toList();
```
4. Person 클래스의 리스트가 주어졌을 때, 각 객체의 이름만
추출하여 List<String>으로 변환하세요.

```java
List<String> name = people.stream()
        .map(x -> x.getName())
        .toList();
```
5. Person 클래스의 리스트가 주어졌을 때, 나이가 28 이상인 사람만
   필터링하여 새로운 리스트를 만드세요.
```java
List<String> oldPeople = people.stream()
                .filter(x -> x.getAge() >= 28)
                .map(x -> x.getName())
                .toList();
```
6. List<String> 형태의 문자열 리스트가 주어졌을 때, 각
   문자열의 길이를 계산하여 길이가 5이하인 요소만 담아서
   List<String> 으로 변환하세요.
```java
List<String> words = Arrays.asList("apple","banana","cherry");

        List<String> length = words.stream()
                .filter(x -> x.length() <= 5)
                .toList();
```
7. List<String> 형태의 문자열 리스트가 주어졌을 때,
   내림차순으로 정렬하고
   모든 문자열을 대문자로 변환하세요.
```java
List<String> words = Arrays.asList("hello", "world", "java");
        List<String> upperWords = words.stream()
                .map(x-> x.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .toList();
```
8. List<String> 형태의 문자열 리스트가 주어졌을 때, 문자열의
   길이가 5글자 이상인 것만 필터링하여 새로운 리스트를 만드세요.
```java
List<String> words = Arrays.asList("apple", "banana", "cat", "dog", "elephant");

        List<String> longWords = words.stream()
                .filter(x -> x.length() >= 5)
                .toList();
```
9.List<Integer>가 주어졌을 때,
리스트에서 10보다 크고 50보다 작은 숫자만 필터링하세요.
```java
List<Integer> numbers = Arrays.asList(5, 12, 25, 37, 48, 50, 63);

        List<Integer> middleNumbers = numbers.stream()
                .filter(x -> x > 10 && x < 50)
                .toList();
```
10. List<String> 형태의 문자열 리스트가 주어졌을 때, 특정 단어
    (예: "apple")가 포함된 문자열만 필터링하세요.
```java
List<String> sentences = Arrays.asList("I like apples", "Bananas are tasty", "apple pie is delicious", "I have an apple");
        List<String> appleWords = sentences.stream()
                .filter(x-> x.contains("apple"))
                .toList();
```