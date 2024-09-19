package _2024_09_13.shoppingMall;

public class Clothing extends Product{
    String size;

    Clothing(String name, int price, int stock, String size) {
        super(name, price, stock);
        this.size = size;
    }
}
