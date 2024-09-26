package _2024_09_26.raisingACat;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CatCare catCare = new CatCare();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Cat cat : catCare.cats) {
                    if (cat.isAlive()) {
                        cat.ageUp();
                    }
                }
                System.out.println("고양이들의 나이 증가");
            }
        }, 0, 30000);

        while (true) {
            catCare.printMenu();
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("추가할 고양이 이름: ");
                    String name = sc.nextLine();
                    System.out.println("품종");
                    System.out.println("1. 러시안블루, 2. 랙돌");
                    String breed = sc.nextLine();
                    Cat cat;
                    switch (breed) {
                        case "1" -> cat = new RussianBlue(name);
                        case "2" -> cat = new Ragdoll(name);
                        default -> {
                            System.out.println("다른 품종은 몰라");
                            return;
                        }
                    }
                    catCare.addCat(cat);
                    System.out.println("등록 완료");
                    break;
                case "2":
                    System.out.print("먹이 줄 고양이: ");
                    String peedName = sc.nextLine();
                    Cat peedCat = CatCare.findCatByName(catCare, peedName);
                    if (peedCat != null) {
                        peedCat.feed();
                        System.out.println("먹이를 주었습니다.");
                    } else {
                        System.out.println("없는 고양이 입니다.");
                    }
                    break;
                case "3":
                    System.out.print("놀아줄 고양이: ");
                    String playName = sc.nextLine();
                    Cat playCat = CatCare.findCatByName(catCare, playName);
                    if (playCat != null) {
                        playCat.play();
                        System.out.println(playCat + "와 놀아줌");
                    } else {
                        System.out.println("없는 고양이 입니다.");
                    }
                    break;
                case "4":
                    catCare.printCatStatus();
                    break;
                case "5":
                    System.out.println("종료");
                    timer.cancel();
                    System.exit(0);
                default:
                    System.out.println("잘못된 번호");
            }
        }
    }
}
