package _2024_08_28.chap04;

public class _Quiz_04 {
    public static void main(String[] args) {

        int hour = 10;
        boolean smallCar = false;
        boolean withDisabledPerson = true;

        int price = hour * 4000;

        if (price > 30000) {
            price = 30000;
        }
        if (smallCar || withDisabledPerson) {
            price /= 2;
        }

        System.out.println("주차요금은 " + price + "원 입니다.");
    }
}
