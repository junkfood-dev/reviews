package practice;

public class ForLoop {
    public static void main(String[] args) {
//        구구단 7단 출력하기
//        아래와 같은 결과가 나와야함
//
//        7 x 1 = 7
//        7 x 2 = 14
//        7 x 3 = 21
//
//        7 x 9 = 63

        for (int i = 1; i <= 9; i++) {
            System.out.println("7 X " + i + " = " + (7 * i));
        }
        System.out.println("----------------------");
//        구구단 2단 ~ 9단 출력하기
        for (int a = 2; a <= 9; a++) {
            for (int b = 2; b <= 9; b++) {
                System.out.println(a + " X " + b + " = " + (a * b));
            }
        }
        System.out.println("----------------------");
//        별찍기 1
//        아래와 같은 결과가 나와야함
//        *
//        **
//        ***
//        ****
//        *****
        int star = 5;

        for (int i = 1; i <= star; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("----------------------");
//        별찍기 2
//        아래와 같은 결과가 나와야함
//        *****
//        ****
//        ***
//        **
//        *
        for (int i = 1; i <= star; i++) {
            for (int j = star; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("----------------------");
//        별찍기 3
//        아래와 같은 결과가 나와야함
//            *
//           **
//          ***
//         ****
//        *****
        for (int i = 1; i <= star; i++) {
            for (int j = 1; j <= star - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("----------------------");
//        별찍기 4
//        아래와 같은 결과가 나와야함
//        *****
//         ****
//          ***
//           **
//            *
        for (int i = 0; i < star; i++) {
            for (int j = star; j > star - i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < star - i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("----------------------");
//        별찍기 5
//        아래와 같은 결과가 나와야함
//            *
//           ***
//          *****
//         *******
//        *********
        for (int i = 0; i < star; i++) {
            for (int j = 1; j < star - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("----------------------");
//        별찍기 6
//        아래와 같은 결과가 나와야함
//        *********
//         *******
//          *****
//           ***
//            *
        for (int i = 0; i < star; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 9 - 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("----------------------");
//        별찍기 7
//        아래와 같은 결과가 나와야함
//            *
//           ***
//          *****
//         *******
//        *********
//         *******
//          *****
//           ***
//            *
        int star2 = 4;
        for (int i = 0; i < star; i++) {
            for (int j = 1; j < star - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < star2; i++) {
            for (int j = 0; j <= i ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 7 - 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("----------------------");
//        별찍기 8
//        아래와 같은 결과가 나와야함
//        *********
//         *******
//          *****
//           ***
//            *
//           ***
//          *****
//         *******
//        *********
        for (int i = 0; i < star; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 9 - 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < star2; i++) {
            for (int j = 1; j < star2 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= 2*i + 2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


