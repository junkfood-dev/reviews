package _2024_09_14.baseball;

import java.util.Random;
import java.util.Scanner;

public class Baseball {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int num = 0;
        String str = "";
        while (str.length() < 3){
            num = random.nextInt(10);
            if (!str.contains(num + "")) {
                str += num + "";
            }
        }

        System.out.println("시작");
        System.out.println(str);
        while (true) {
            int strike = 0;
            int ball = 0;
            String input = sc.next();
            for (int i = 0; i < str.length(); i++) {
                String x = String.valueOf(input.charAt(i));
                if (str.substring(i, i + 1).equals(input.substring(i, i + 1))) {
                    strike++;
                } else if (str.contains(x)) {
                    ball++;
                }
            }
            if (strike == 3) {
                System.out.println("정답");
                break;
            } else {
                System.out.println("스트라이크: " + strike + ", 볼: " + ball);
            }
        }
    }
}
