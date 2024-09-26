## 1. 큰 수 출력하기

N(1<=N<=100)개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작
성하세요. (첫 번째 수는 무조건 출력합니다)

```java
**입력설명**
첫 줄에 자연수 N이 주어지고, 그 다음 줄에 N개의 정수가 입력됩니다.

**출력설명**
자신의 바로 앞 수보다 큰 수만 한 줄로 출력합니다.

**입력예제 1**
6
7 3 9 5 6 12

**출력예제 1**
7 9 6 12
```

<코드 작성하기>

```java
public class PrintMoreBigNumber { // stream 안쓴거
    public List<Integer> solution(int n, int[] array) {
        List<Integer> answer = new ArrayList<>();

        answer.add(array[0]);
        for (int i = 1; i < n; i++) {
            if (array[i] > array[i - 1]) {
                answer.add(array[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PrintMoreBigNumber printMoreBigNumber = new PrintMoreBigNumber();
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int[] array = new int[number];

        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }

        for (int x : printMoreBigNumber.solution(number, array)) {
            System.out.print(x + " ");
        }
    }
}
```
```java
public class PrintMoreBigNumber2 { //stream 쓴거
    public List<Integer> solution(int n, int[] array) {
        List<Integer> answer = new ArrayList<>();
        answer.add(array[0]);
        List<Integer> bigNumbers = IntStream.range(1,n)
                .filter(i -> array[i] > array[i-1] )
                .mapToObj(i -> array[i]).toList();

        answer.addAll(bigNumbers);
        return answer;
    }

    public static void main(String[] args) {
        PrintMoreBigNumber2 printMoreBigNumber2 = new PrintMoreBigNumber2();
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int[] array = new int[number];

        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }

        for (int x : printMoreBigNumber2.solution(number, array)) {
            System.out.print(x + " ");
        }
    }
}
```

## 2. 두 배열 합치기

오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성해보세요.

```java
**입력설명**
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다. 
세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다. 
각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

**출력설명**
오름차순으로 정렬된 배열을 출력합니다.

**입력예제 1** 
3
1 3 5
5
2 3 6 7 9

**출력예제 1**
1 2 3 3 5 6 7 9
```

<코드 작성>

```java
public class AscendingSort { // stream 안쓴거
		public int[] solution(int[] array1, int[] array2) {
				int[] result = new int[array1.length + array2.length];

            for (int i = 0; i <array1.length ; i++) {
                result[i] = array1[i];
            }
            for (int i = 0; i < array2.length; i++) {
                result[array1.length + i] = array2[i];
            }
            Arrays.sort(result);
            return result;
        }

		public static void main(String[] args) {
        AscendingSort ascendingSort = new AscendingSort();
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int[] array = new int[number];

        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }

        int number2 = scanner.nextInt();
        int[] array2 = new int[number2];

        for (int i = 0; i < number2; i++) {
            array2[i] = scanner.nextInt();
        }

        for (int x : ascendingSort.solution(array, array2)) {
            System.out.print(x + " ");
        }
    }
}
```
```java
public class AscendingSort { // stream 쓴거
		public int[] solution(int[] array1, int[] array2) {
				int[] result = new int[array1.length + array2.length];

            result = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2))
                    .sorted()
                    .toArray();

            return result;
        }

		public static void main(String[] args) {
        AscendingSort ascendingSort = new AscendingSort();
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int[] array = new int[number];

        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }

        int number2 = scanner.nextInt();
        int[] array2 = new int[number2];

        for (int i = 0; i < number2; i++) {
            array2[i] = scanner.nextInt();
        }

        for (int x : ascendingSort.solution(array, array2)) {
            System.out.print(x + " ");
        }
    }
}
```