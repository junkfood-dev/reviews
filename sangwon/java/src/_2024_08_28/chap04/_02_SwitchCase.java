package _2024_08_28.chap04;

public class _02_SwitchCase {
    public static void main(String[] args) {
        // 조건문 Switch Case (명확한 케이스가 있을 때)

        int rank = 3;
        int price = 6000;

        switch (rank){
            case 1:
                price += 1000;
            case 2:
                price += 1000;
            case 3:
                price += 1000;
            case 4:
            case 5:
                price += 1000;
                break;
        }
        System.out.println(rank + "등급 제품 가격 " + price + "원");
    }
}
