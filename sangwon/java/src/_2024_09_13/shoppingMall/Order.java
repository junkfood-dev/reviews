package _2024_09_13.shoppingMall;

import java.util.ArrayList;

public class Order extends Cart {
    static int nextOrderId = 0001;

    int orderId;
    int totalAmount;

    Order(String customer, ArrayList<Product> productList) {
        super(customer, productList);
        this.orderId = nextOrderId++;
    }

    int calculateTotalAmount() {
        int discount = calculateTotal();
        if (discount >= 2000000) {
            discount *= 0.9;
        }
        this.totalAmount = discount;
        return totalAmount;
    }

    void processOrder() {
        calculateTotalAmount();
        for (Product product : productList) {
            product.reduceStock(1);
        }
    }

    int getOrderId() {
        return orderId;
    }

    int getTotalAmount() {
        return totalAmount;
    }
}
