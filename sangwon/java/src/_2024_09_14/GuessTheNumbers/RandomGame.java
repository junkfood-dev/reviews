package _2024_09_14.GuessTheNumbers;

import java.util.Random;
import java.util.Scanner;

public class RandomGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int number;
        int count = 0;
        boolean isCorrectValue = false;

        int num = random.nextInt(100);
        while (!isCorrectValue) {
            System.out.println("숫자를 맞춰보자");
            number = sc.nextInt();
            if (count == 4) {
                System.out.println("실패");
                isCorrectValue = true;
                break;
            } else if (number > num) {
                System.out.println("down");
                count++;
            } else if (number < num) {
                System.out.println("up");
                count++;
            } else if (number == num){
                System.out.println("탈출성공!");
                isCorrectValue = true;
            }
        }
    }
}
