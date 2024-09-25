package _2024_09_23.textGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Adventure {
    static int hp = 50;
    static int gold = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("던전 입장");
        System.out.println("행동을 할 때마다 hp가 1씩 감소합니다.");
        startGame(sc);
    }

    private static void startGame(Scanner sc) {
        System.out.println("갈림길 : 어디 문으로 가시겠습니까 (1.왼쪽 or 2.오른쪽)");
        System.out.print("숫자 선택: ");

        int choice;
        while (true) {
            try {
                choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    leftpath(sc);
                } else if (choice == 2){
                    rightPath(sc);
                } else {
                    System.out.println("올바른 길을 선택해주세요.");
                }
                hp -= 1;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("올바른 길을 선택해주세요.");
            }
        }
    }

    private static void leftpath(Scanner sc) {
        System.out.println("왼쪽 문을 열고 들어갑니다. ");
        System.out.println("허름한 상자가 있습니다.");
        System.out.print("상자를 열겠습니까? (y/n) ");
        while (true) {
            String choice1 = sc.nextLine();
            if (choice1.matches("(?i)y")) {
                System.out.println("상자 안 금화(10)를 발견했습니다.");
                System.out.println("금화를 가져가겠습니까? (y/n) ");
                String choice2 = sc.nextLine();
                if (choice2.matches("(?i)y")) {
                    System.out.println("상자안에 있던 가시에 찔렸습니다.");
                    gold += 10;
                    hp -= 2;
                    break;
                } else if (choice2.matches("(?i)n")) {
                    System.out.println("욕심없는 당신에게 축복이 내립니다.");
                    hp += 1;
                    break;
                } else {
                    System.out.println("(y/n)중에 선택 하세요");
                }
            } else if (choice1.matches("(?i)n")) {
                System.out.println("아무 일도 일어나지 않았습니다.");
                break;
            } else {
                System.out.println("(y/n)중에 선택 하세요");
            }
        }
        System.out.println("현재 hp: " + hp + ", 보유골드: " + gold);
        startGame(sc);
    }

    private static void rightPath(Scanner sc) {
        System.out.println("오른쪽 문을 열고 들어갑니다.");
        System.out.println("괴물등장! 전투시작 (y/n) ");

        String choice3;
        while (true) {
            choice3 = sc.nextLine();

            if (choice3.matches("(?i)y")) {
                battle(sc);
            } else if (choice3.matches("(?i)n")) {
                System.out.println("뒤로 도망갑니다");
                startGame(sc);
                hp -= 1;
                break;
            } else {
                System.out.println("(y/n)중에 선택 하세요");
            }
        }
    }

    private static void battle(Scanner sc) {
        System.out.println("전투 시작!");
        int monsterHp = 60;

        System.out.println("1: 주먹, 2: 발차기");
        System.out.print("숫자 선택: ");
        while (monsterHp > 0 && hp > 0) {
            int attack;
            try {
                attack = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("1, 2 중에 선택하세요");
                sc.nextLine();
                continue;
            }
            if (attack == 1) {
                monsterHp -= 5;
                System.out.println("괴물 체력 -5");
            } else if (attack == 2) {
                monsterHp -= 7;
                System.out.println("괴물 체력 -7");
            } else {
                System.out.println("잘못된 선택입니다.");
                continue;
            }
            if (monsterHp > 0) {
                hp -= 2;
                System.out.println("괴물에게 맞았습니다 hp - 1");
            }
            if (hp <= 0) {
                System.out.println("게임 오버");
                System.exit(0);
            } else if (monsterHp <= 0){
                System.out.println("괴물이 쓰러집니다 (금화 + 30");
                gold += 30;
                System.out.println("괴물의 고기를 먹겠습니까? (y/n)");
                while (true) {
                    String choice4 = sc.nextLine();
                    if (choice4.matches("(?i)y")) {
                        hp += 4;
                        System.out.println("hp + 5, 현재 체력: " + hp);
                        break;
                    } else if (choice4.matches("(?i)n")) {
                        break;
                    } else {
                        System.out.println("(y/n)중에 선택 하세요");
                    }
                }
            }
        }
        System.out.println("현재 hp: " + hp + ", 보유골드: " + gold);
        startGame(sc);
    }
}