package _2024_08_28.chap04;

public class _07_Break {
    public static void main(String[] args) {
        // Break

        int max = 20;
        for (int i = 1; i <= 50; i++) {
            System.out.println(i + "번 손님, 주문하신 음식 나왔습니다.");
            if (i == max) {
                System.out.println("금일 재료가 모두 소진 되었음.");
                break;
            }
        }
        System.out.println("영업 종료");

        System.out.println("--------------------------");

        int index = 1;
        while (index <= 50) {
            System.out.println(index + "번 손님, 주문하신 음식 나왔습니다.");
            if (index == max) {
                System.out.println("금일 재료가 모두 소진 되었음.");
                break;
            }
            index++;
        }
        System.out.println("영업 종료");
    }
}
