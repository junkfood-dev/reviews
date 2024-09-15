package _2024_09_13.shoppingMall;

import java.util.ArrayList;

public class ShoppingMall {
    public static void main(String[] args) {
        // 제품추가
        Product Tv = new Electronics("Tv", 1000000, 11, "2025-09-20");
        Product Phone = new Electronics("Phone", 700000, 20, "2025-03-20");
        Product tShirt = new Clothing("t-shirt", 13000, 32, "S");
        Product pants = new Clothing("pants", 40000, 25, "M");

        // 유저등록
        Customer customer1 = new Customer("고윤정", "gogo123");
        Customer customer2 = new Customer("이상원", "lsw5604");

        // 장바구니에 담기
        ArrayList<Product> list = new ArrayList<>();
        list.add(Tv);
        list.add(tShirt);
        list.add(pants);

        Cart cart = new Cart(customer1.name, list);

        // 주문하기
        Order order1 = new Order(customer1.name, cart.productList);

        try {
            Payment payment = new CardPayment();
            int totalAmount = order1.calculateTotalAmount();
            int paidAmount = payment.pay(totalAmount);

            order1.processOrder();
            customer1.addOrder(order1);
        } catch (PaymentFailedException e) {
            System.out.println("결제 실패: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("에러 발생");
        }
    }
}
