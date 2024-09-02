package _2024_08_28.chap04;

public class _01_If {
    public static void main(String[] args) {
        // 조건문 if (여러범위와 조건이 있을 때)
        int hour = 20;
        boolean morningCoffee = true;
        
        if (hour < 14 && !morningCoffee){
            System.out.println("아아 한 잔");
        } else if (hour <= 19 || !morningCoffee) {
            System.out.println("디카페인 아아 한 잔");
        } else {
            System.out.println("우유 한 잔");
        }
        System.out.println("주문 완료");
    }
}
