package _2024_08_28.chap04;

public class _06_MultipleTable {
    public static void main(String[] args) {
        // 구구단

        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " X " + j + " = " +(i * j));
            }
            System.out.println();
        }
    }
}
