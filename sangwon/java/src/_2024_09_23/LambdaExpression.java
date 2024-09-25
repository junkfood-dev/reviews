package _2024_09_23;

import java.util.function.*;

public class LambdaExpression {
    public static void main(String[] args) {
        // 내가 만든 인터페이스로 람다식만들기
        LambdaExample ex = new LambdaExample() {
            @Override
            public int method(int a, int b) {
                return a + b;
            }
        };
        int result = ex.method(3, 2);
        System.out.println(result);
        // 위를 람다식으로
        LambdaExample ex2 = (a, b) -> a + b;
        int result2 = ex2.method(3, 2);
        System.out.println(result2);

        ////////////////////////////////////////////////////////////

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hi");
            }
        };
        // 위를 람다식으로
        // Runnable 매개변수 반환값 둘다 없음
        Runnable runnable1 = () -> System.out.println("hi");
        runnable1.run(); // 코드블록실행

        // Supplier 매개변수X 반환값만 있다
        Supplier<String> supplier = () -> "1";
        Supplier<Integer> supplier1 = () -> 1;
        supplier.get(); // 반환 값 가져오기

        // Consumer 매개변수만 있고 반환값없음
        Consumer<Double> consumer = x -> x *= Math.PI;
        consumer.accept(4.2); // 매개변수에 전달
        Consumer<String> consumer1 = x -> System.out.println(x);
        // 위 람다식을 메소드 참조로
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("Hello");

        // 매개변수를 확인해서 불리언 값으로 반환
        Predicate<String> predicate = x -> x.isEmpty();
//        Predicate<String> predicate = String::isEmpty;
        predicate.test("d"); // 매개변수 전달 후 boolean 반환

        // 매개변수와 반환값 둘다 있음
        Function<String, Double> function = x -> Double.parseDouble(x) * Math.PI;
        function.apply("3"); // 매개변수 전달후 반환

        // Bi 매개변수 2개
        // <매개변수1타입, 매개변수2타입, 반환값>
        BiFunction<Integer, Double, String> biFunction= (a, b) -> String.valueOf(Double.valueOf(a) * b);
        biFunction.apply(3, 4.2);

        //////////////////////////////////////////////////////////////////////////////////
        // To타입 매개변수를 to타입으로 반환
        ToDoubleFunction<Integer> toDoubleFunction = x -> x / 2.0;
        System.out.println(toDoubleFunction.applyAsDouble(10)); // 자동 형 변환

        // 타입1To타입2 타입1(매개변수)를 타입2(값) 으로 반환
        IntToDoubleFunction intToDoubleFunction = x -> x / 2.0;
        System.out.println(intToDoubleFunction.applyAsDouble(10)); // 자동 형 변환

        // 인터페이스 이름 엄청기네 걍 제네릭쓰는게 편하네
        ///////////////////////////////////////////////////////////////////////////////////
    }
}
