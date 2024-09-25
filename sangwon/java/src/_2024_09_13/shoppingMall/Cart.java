package _2024_09_13.shoppingMall;

import java.util.ArrayList;

public class Cart {
    String customer;
    ArrayList<Product> productList;

    Cart(String customer, ArrayList<Product> productList) {
        this.customer = customer;
        this.productList = new ArrayList<>(productList);
    }

    void addProduct(Product product) {
        this.productList.add(product);
    }

    void removeProduct(Product product) {
        this.productList.remove(product);
    }

    int calculateTotal() {
        int totalPrice = 0;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
