package _2024_08_28.chap06;

public class _06_WhenToUse {
    public static int getPower (int number) {
        return getPower(number, 2); // 메소드안에서 다른 메소드 불러올수있음
    }
    public static int getPower (int number, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= number;
        }
        return result;
    }


    public static void main(String[] args) {
        // 메소드가 필요한 이유

//        // 2의 2승 구하기
//        int result = 1;
//        for (int i = 0; i < 2; i++) {
//            result *= 2;
//        }
//        System.out.println(result);
//
//        // 3의 3승 구하기
//        result = 1;
//        for (int i = 0; i < 3; i++) {
//            result *= 3;
//        }
//        System.out.println(result);
//
//        // 4의 2승 구하기
//        result = 1;
//        for (int i = 0; i < 2; i++) {
//            result *= 4;
//        }
//        System.out.println(result);

        System.out.println(getPower(2, 3));
        System.out.println(getPower(3, 3));
        System.out.println(getPower(4, 2));
    }
}
