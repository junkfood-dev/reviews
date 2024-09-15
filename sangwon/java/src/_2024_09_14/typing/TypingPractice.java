package _2024_09_14.typing;

import java.util.Random;
import java.util.Scanner;

public class TypingPractice {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 10000) {
            int num = random.nextInt(100);
            System.out.println(num);
            while (true) {
                int input = sc.nextInt();
                if (input != num) {
                    System.out.println("다시 입력하세요");
                    System.out.println(num);
                } else {
                    sum++;
                    break;
                }
            }
        }
        System.out.println("정답 개수: " + sum);
    }
}