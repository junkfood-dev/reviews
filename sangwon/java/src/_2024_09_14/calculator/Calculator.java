package _2024_09_14.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws NotOperateException {
        double num = 0;
        double num2 = 0;
        String operate = "";
        boolean validValue = false;
        Scanner sc = new Scanner(System.in);

        while (!validValue) {
            try {
                System.out.println("숫자를 입력하세요");
                num = sc.nextInt();
                validValue = true;
            } catch (Exception e) {
                System.out.println("숫자가 아닙니다.");
                sc.nextLine();
            }
        }

        validValue = false;
        while (!validValue) {
            try {
                System.out.println("연산자를 입력 해주세요.");
                operate = sc.next();
                if (!operate.equals("+") && !operate.equals("-") && !operate.equals("*") && !operate.equals("/")) {
                    throw new NotOperateException("사칙 연산자가 아닙니다.");
                }
                validValue = true;
            } catch (NotOperateException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

        validValue = false;
        while (!validValue) {
            try {
                System.out.println("숫자를 입력하세요");
                num2 = sc.nextInt();
                validValue = true;
            } catch (Exception e) {
                System.out.println("숫자가 아닙니다.");
                sc.nextLine();
            }
        }

        System.out.print("결과입니다: ");
        double result = switch (operate) {
            case "+" -> num + num2;
            case "-" -> num - num2;
            case "*" -> num * num2;
            case "/" -> num / num2;
            default -> 0;
        };
        System.out.println(result);
    }
}