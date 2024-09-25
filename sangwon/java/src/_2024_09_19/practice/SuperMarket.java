package _2024_09_19.practice;

public class SuperMarket {
    public static void main(String[] args) {
        ChildProduct<String, String, Integer> childProduct = new ChildProduct<>("Tv", "32인치", 400000);
        System.out.println(childProduct.getValue2() + childProduct.getValue() + childProduct.getName());
    }
}
