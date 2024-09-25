package _2024_09_11.Java_Interface;

public class Cart {
    Product[] products;

    Cart(Product[] products) {
        this.products = products;
    }

    int calculateDeliveryCharge() {
        int totalWeight = 0;
        int totalPrice = 0;
        int deliveryFee;
        for (Product product : products) {
            totalWeight += product.getWeight();
            totalPrice += product.getPrice();
        }

        if (totalWeight < 3) {
            deliveryFee = 1000;
        } else if (totalWeight >= 3 && totalWeight < 10) {
            deliveryFee = 5000;
        } else {
            deliveryFee = 10000;
        }

        if (totalPrice >= 30000 && totalPrice < 100000) {
            deliveryFee -= 1000;
        } else if (totalPrice >= 100000){
            deliveryFee = 0;
        }
        return deliveryFee;
    }
}
