package _2024_08_28.chap06;

public class _04_ParameterAndReturn {
    public static int getpower(int number) {
        return number * number;
    }

    public static int getPowerByExp(int number, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= number;
        }
        return result;
    }

    public static void main(String[] args) {
        // 전달값과 반환값이 함께있는 메소드
        int retVal = getpower(2);
        System.out.println(retVal);

        retVal = getpower(3);
        System.out.println(retVal);

        retVal = getPowerByExp(3, 3);
        System.out.println(retVal);

        System.out.println(getPowerByExp(2, 4));
    }
}
