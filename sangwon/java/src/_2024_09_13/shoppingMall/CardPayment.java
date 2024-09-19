package _2024_09_13.shoppingMall;

import java.time.LocalTime;

public class CardPayment implements Payment{
    LocalTime localTime;

    CardPayment() {
        this.localTime = LocalTime.now();
    }

    @Override
    public int pay(int money) throws PaymentFailedException{
        if (money > 3000000) {
            throw new PaymentFailedException("잔액이 부족합니다.");
        }
        if (localTime.isAfter(LocalTime.of(0, 0)) && localTime.isBefore(LocalTime.of(0, 10))) {
            throw new PaymentFailedException("카드회사 점검시간 입니다.");
        }
        return money;
    }
}
