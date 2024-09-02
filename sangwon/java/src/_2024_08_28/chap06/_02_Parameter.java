package _2024_08_28.chap06;

public class _02_Parameter {
    public static void power(int number) { // 파라미터, 매개변수
        int result = number * number;
        System.out.println(number + "의 2승은 " + result);
    }

    public static void powerByExp(int number, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= number;
        }
        System.out.println(number + "의 " + exponent + "승은 " + result);
    }

    public static void main(String[] args) {
        power(3); // 아규먼트, 인자

        powerByExp(2, 3);
        powerByExp(3, 3);
        powerByExp(10, 0);
    }
}
