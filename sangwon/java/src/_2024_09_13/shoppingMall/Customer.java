package _2024_09_13.shoppingMall;

import java.util.ArrayList;

public class Customer {
    String name;
    String id;
    ArrayList<Order> orderHistory;

    Customer(String name, String id) {
        this.name = name;
        this.id = id;
        orderHistory = new ArrayList<>();
    }

    void addOrder (Order order) {
        orderHistory.add(order);
    }

    ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }
}
