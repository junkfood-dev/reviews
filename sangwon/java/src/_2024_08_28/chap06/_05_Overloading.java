package _2024_08_28.chap06;

public class _05_Overloading {
    public static int getpower(int number) {
        return number * number;
    }

    public static int getpower(String strNumber) {
        int number = Integer.parseInt(strNumber);
        return number * number;
    }

    public static int getPower(int number, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= number;
        }
        return result;
    }

    public static void main(String[] args) {
        // 메소드 오버로딩
        // 같은 이름의 메소드를 여러 번 선언
        // 전달값의 타입이나 갯수가 다를 때 사용
        // 반환형은 같아야함 (위에서는 int로 같음)
        System.out.println(getpower(3));
        System.out.println(getpower("4"));
        System.out.println(getPower(3, 3));
    }
}
