package _2024_09_13.shoppingMall;

public interface Payment {
    int pay(int money) throws PaymentFailedException;
}
