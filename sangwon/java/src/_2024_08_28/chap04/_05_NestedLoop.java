package _2024_08_28.chap04;

public class _05_NestedLoop {
    public static void main(String[] args) {
        //이중 반복문

        // *로 사각형만들기

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println("-------------------");

        // *로 삼각형만들기
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-------------------");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
