### 1. 람다식에 대한 설명으로 틀린것은?

1) 람다식은 함수형 인터페이스의 익명 구현 객체를 생성한다.

2) 매개 변수가 없을 경우 ( ) → { … } 형태로 작성한다.

3) (x, y) → { return x + y; }는 (x, y) → x + y;로 바꿀 수 있다.

4) @FunctionalInterface가 기술된 인터페이스만 람다식으로 표현이 가능하다.
```java
4번,  어노테이션은 명시적으로 표현 할뿐
```

### 2. 메소드 참조에 대한 설명으로 틀린 것은?

1) 메소드 참조는 함수적 인터페이스의 익명 구현 객체를 생성한다.

2) 인스턴스 메소드는 “참조변수::메소드”로 기술한다.

3) 정적 메소드는 “클래스::메소드”로 기술한다.

4) 생성자 참조인 “클래스::new”는 매개 변수가 없는 디폴트 생성자만 호출한다.
```java
4번, 매개변수 받는 생성자 참조 가능
```
### 3. 잘못 작성한 람다식은?

1)  a → a + 3

2) a, b → a * b

3) x → System.out.println(x/5)

4) (x, y) → Math.max(x, y)
```java
2번, 매개변수가 2개일때는 소괄호로 묶어줘야함
```
### 4. 다음 코드는 컴파일 에러가 발생합니다. 그 이유는?

```java
public class LambdaExample {
    public static int method(int x, int y) {
        IntSupplier supplier = () -> {
            x *= 10;
            int result = x + y;
            return result;
        };
        int result = supplier.getAsInt();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(method(3, 5));
    }
}
```
```java
람다표현식 내에서 변수의 값을 바꿀 수 없음
```

### 5. 다음은 배열 항목 중 최대값 또는 최소값을 찾는 코드입니다. maxOrMin() 메소드의 매개값을 람다식으로 기술해보세요.

```java
public class LambdaExample_5 {
    private static int[] scores = {10, 50, 3};

    public static int maxOrMin(IntBinaryOperator operator) {
        int result = scores[0];
        for (int score : scores) {
            result = operator.applyAsInt(result, score);
        }
        return result;
    }

    public static void main(String[] args) {
        int max = maxOrMin((a,b) -> a > b ? a : b);
        System.out.println("최대값 : " + max);
        
        int min = maxOrMin((a,b) -> a < b ? a : b);
        System.out.println("최소값: " + min);
    }
}
```

```java
최대값 : 50
최소값: 3
```

### 6. 다음은 학생의 영어 평균 점수와 수학 평균 점수를 계산하는 코드입니다. avg() 메소드를 선언해보세요.

```java
public class LambdaExample_6 {
    private static Student[] students = {
            new Student("홍길동", 90, 96),
            new Student("저팔계", 95, 93)
    };
    public static double avg(Function<Student, Integer> score) {
        double sum = 0;
        for (Student student : students) {
            sum += score.apply(student);
        }
        return  sum / students.length;
    }
		
    public static void main(String[] args) {
        double englishAvg = avg( s -> s.getEnglishScore() );
        System.out.println("영어 평균 점수: " + englishAvg);
        
        double mathAvg = avg( s -> s.getMathScore() );
        System.out.println("수학 평균 점수: " + mathAvg);
    }
    
    public static class Student {
        private String name;
        private int englishScore;
        private int mathScore;

        public Student(String name, int englishScore, int mathScore) {
            this.name = name;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        public String getName() {
            return name;
        }

        public int getEnglishScore() {
            return englishScore;
        }

        public int getMathScore() {
            return mathScore;
        }
    }
}
```

### 7. 6번의 main() 메소드에서 avg() 호출할 때 매개값으로 준 람다식을 메소드 참조로 변경해보세요.

```java
double englishAvg = average( s -> s.getEnglishScore() );
-> double englishAvg = avg (Student::getEnglishScore);

double mathAvg = average( s -> s.getMathScore() );
-> double mathAvg = avg (Student::getMathScore);
```