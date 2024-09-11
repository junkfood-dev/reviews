package _2024_09_11.Java_Interface;

public class Product implements Promotion{
    String name;
    int price;
    int weight;

    Product (String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public int getDiscountAmount() {
        int discountAmount = switch (name) {
            case "beauty" -> 2000;
            case "grocery" -> 10000;
            default -> 0;
        };
        return discountAmount;
    }

    int getPrice() {
        return price - getDiscountAmount();
    }

    int getWeight() {
        return weight;
    }
}
