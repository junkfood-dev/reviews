package _2024_09_13.shoppingMall;

public class Product {
    String name;
    int price;
    int stock;

    Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    void reduceStock(int stock) {
        if (this.stock >= stock) {
            this.stock -= stock;
        } else {
            System.out.println("재고가 부족 합니다.");
        }
    }

    void increaseStock(int stock) {
        this.stock += stock;
    }

    int getPrice() {
        return price;
    }

    int getStock() {
        return stock;
    }
}
