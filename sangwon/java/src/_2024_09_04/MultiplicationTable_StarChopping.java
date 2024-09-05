package _2024_09_04;

public class MultiplicationTable_StarChopping {
    public static void main(String[] args) {
//        7단 출력하기
        int result = 0;
        for (int i = 1; i < 10; i++) {
            result = 7 * i;
            System.out.println("7 X " + i + " = " + result);
        }

        System.out.println("----------------------");

//        구구단 출력하기
        int sum = 0;
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                sum = i * j;
                System.out.println(i + " X " + j + " = " + sum);
            }
        }

        System.out.println("----------------------");

//        별찍기1
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("----------------------");

//        별찍기2
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("----------------------");

//        별찍기3
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("----------------------");

//        별찍기4
        for (int i = 0; i < 5; i++) {
            for (int k = 1; k < i + 1; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("----------------------");

//        별찍기5
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i + (1 + i); k ++) {
                System.out.print("*");
            }
            for (int l = 0; l < 4 - i; l++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("----------------------");

//        별찍기6
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < i + 1; j++) {
                System.out.print(" ");
            }
            for (int k = 10; k > i + (i + 1); k--) {
                System.out.print("*");
            }
            for (int l = 1; l < i + 1; l++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("----------------------");

//        별찍기7
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i + (1 + i); k ++) {
                System.out.print("*");
            }
            for (int l = 0; l < 4 - i; l++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }
            for (int k = 8; k > i + (i + 1); k--) {
                System.out.print("*");
            }
            for (int l = 1; l < i + 1; l++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("----------------------");

//        별찍기8
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < i + 1; j++) {
                System.out.print(" ");
            }
            for (int k = 10; k > i + (i + 1); k--) {
                System.out.print("*");
            }
            for (int l = 1; l < i + 1; l++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i + (3 + i); k ++) {
                System.out.print("*");
            }
            for (int l = 0; l < 3 - i; l++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}