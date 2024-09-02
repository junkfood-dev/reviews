package _2024_08_28.chap04;

public class _08_Continue {
    public static void main(String[] args) {
        //Continue

        int max = 20; // 최대판매수량
        int sold = 0; // 현재 판매수량
        int noShow = 17; // 노쇼손님
        for (int i = 1; i <= 50; i++) {
            System.out.println(i + "번 손님, 주문하신 음식 나왔습니다.");

            if (i == noShow) {
                System.out.println(i + "번 손님, 안오셔서 다음 손님~");
                continue;
            }

            sold++;
            if (sold == max) {
                System.out.println("금일 재료가 모두 소진 되었음.");
                break;
            }
        }
        System.out.println("영업 종료");

        System.out.println("---------------------------");

        sold = 0;
        int index = 0; // 손님 번호
        while (index <= 50) {
            index++;
            System.out.println(index + "번 손님, 주문하신 음식 나왔습니다.");

            if (index == noShow) {
                System.out.println(index + "번 손님, 안오셔서 다음 손님~");
                continue;
            }

            sold++;
            if (sold == max) {
                System.out.println("금일 재료가 모두 소진 되었음.");
                break;
            }
        }
        System.out.println("영업 종료");
    }
}
