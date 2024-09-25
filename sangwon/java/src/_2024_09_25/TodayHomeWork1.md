1. 
    List<String> 형태의 문자열 리스트가 주어졌을 때,
    각 문자열의 길이를 계산하여 길이가 5이하인 요소만 담아서
    List<String>으로 변환하세요.  
    결과 : [apple]
```java
List<String> words = Arrays.asList("apple", "banana", "cherry");
List<String> result = words.stream()
        .filter(str -> str.length() <= 5)
        .toList();
```

2. 
    List<String> 형태의 문자열 리스트가 주어졌을 때,
    내림차순으로 정렬하고, 모든 문자열을 대문자로 변환하세요.  
    결과 : [WORLD, JAVA, HELLO]

```java
List<String> words = Arrays.asList("hello", "world", "java");
List<String> result = words.stream()
        .map(str -> str.toUpperCase())
        .sorted(Comparator.reverseOrder())
        .toList();
```

3. 
    List<String> 형태의 문자열 리스트가 주어졌을 때,
    문자열의 길이가 5글자 이상인 것만 필터링하여 새로운 리스트 만들기  
    결과 : [apple, banana, elephant]
```java
List<String> words = Arrays.asList("apple", "banana", "cat", "dog", "elephant");
List<String> result = words.stream()
        .filter(str -> str.length() >= 5)
        .toList();
```

4. 
    List<Integer>가 주어졌을 때,
    리스트에서 10보다 크고 50보다 작은 숫자만 필터링하기  
    결과 : [12, 25, 37, 48]
```java
List<Integer> numbers = Arrays.asList(5, 12, 25, 37, 48, 50, 63);
List<Integer> result = numbers.stream()
        .filter(num -> num > 10 && num < 50)
        .toList();
```

5. 
    List<String> 형태의 문자열 리스트가 주어졌을 때,
    'apple'이 포함된 문자열만 필터링하기  
    결과 : [I like apples, apple pie is delicious, I have an apple]
```java
List<String> sentences = Arrays.asList("I like apples", "Bananas are tasty", "apple pie is delicious", "I have an apple");
List<String> result = sentences.stream()
        .filter(str -> str.contains("apple"))
        .toList();
```