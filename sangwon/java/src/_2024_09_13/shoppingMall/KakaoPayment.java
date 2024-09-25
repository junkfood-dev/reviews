package _2024_09_13.shoppingMall;

import java.time.LocalTime;

public class KakaoPayment implements Payment{
    LocalTime localTime;

    KakaoPayment() {
        this.localTime = LocalTime.now();
    }

    @Override
    public int pay(int money) throws PaymentFailedException {
        if (money < 1000000) {
            throw new PaymentFailedException("최소 주문 금액은 100만원 입니다.");
        }
        if (localTime.isAfter(LocalTime.of(9, 0)) && localTime.isBefore(LocalTime.of(10, 0))) {
            money *= 0.95;
        }
        return money;
    }
}
