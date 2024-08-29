package _2024_08_28.chap04;

public class _04_While {
    public static void main(String[] args) {
        // 반복문 While (명확한 횟수가 없을 때)
        // while (조건) {}
        // 증감식이나 break 없으면 무한루프
//        int distance = 25;
//        int move = 0;
//        int height = 2;
//        while (move + height < distance) {
//            System.out.println("계속 뜁니다.");
//            System.out.println("현재 이동 거리 : " + move);
//            move += 3;
//        }
//        System.out.println("도착");
//
//        System.out.println("-------------");

        // Do While
        // do {} while (조건) {}
        // 한번은 무조건 실행
        int distance = 25;
        int move = 0;
        int height = 25;

        do {
            System.out.println("계속 뜁니다.");
            System.out.println("현재 이동 거리 : " + move);
            move += 3;
        }
        while (move + height < distance);
        System.out.println("도착");
    }
}
