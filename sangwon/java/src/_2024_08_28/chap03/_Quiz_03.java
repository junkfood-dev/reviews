package _2024_08_28.chap03;

public class _Quiz_03 {
    public static void main(String[] args) {
        String date = "456895-1234567";

        System.out.println(date.substring(0, 8));

        date = "030708-2547569";

        System.out.println(date.substring(0, 8));
        System.out.println(date.substring(0, date.indexOf("-") + 2));
    }
}
