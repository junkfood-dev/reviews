package _2024_09_03;

public class TodayReviews {
    public static void main(String[] args) {
        // 연산자

        // 오버플로우
        // 연산결과가 타입의 범위를 초과하면 쓰레기 값이 반환됨.

        //NaN, infinity가 결과값으로 나오면 안됨
        // 확인 방법 (true가 나오면 infinity, NaN가 나온다는것)
        // 타입.isInfinity(연산식);
        // 타입.isNaN(연산식);

        // Casting 위치에 따라 값이달라짐
        int num = 47;
        double num2 = 46.24;
        int result = (int) (num - num2); // 47 - 46.24 = 0
        int result2 = num - (int) num2; // 47 - 46 = 1
        
        // char 타입은 유니코드가 적용되서 연산
        char c1 = 'A' + 1; // B
        char c2 = 'A';
//        char c3 = c2 + 1; // 에러

        // 문자열연산자 +
//         "Hello" + 123 + 456 // Hello123456
//         123 + 456 + "Hello" // 579Hello

        // 2진수를 10진수로
        // 1110 -> 8 + 4 + 2 + 0
        // 1111 -> 8 + 4 + 2 + 1
    }
}
