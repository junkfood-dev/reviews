package _2024_09_03;

public class MyOOP {
    public static void main(String[] args) {
        delimiter = "---";
        printA();
        printB();

        delimiter = "***";
        printA();
        printB();
    }

    public static String delimiter = "";

    public static void printA() {
        System.out.println(delimiter);
        System.out.println("A");
    }

    public static void printB() {
        System.out.println(delimiter);
        System.out.println("B");
    }
}
