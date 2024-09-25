package _2024_09_13.shoppingMall;

public class Electronics extends Product {
    String warrantyPeriod;

    Electronics(String name, int price, int stock, String warrantyPeriod) {
        super(name, price, stock);
        this. warrantyPeriod = warrantyPeriod;
    }
}
