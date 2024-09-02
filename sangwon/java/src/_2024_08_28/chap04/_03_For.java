package _2024_08_28.chap04;

public class _03_For {
    public static void main(String[] args) {
        // 반복문 for (명확한 횟수가 정해져 있을 때)

        // fori 탭 (단축키)
        for (int i = 0; i < 10; i += 2) {
            System.out.print(i);
        }

        System.out.println(); // 줄바꿈용

        for (int i = 5; i > 0; i -= 1) {
            System.out.print(i);
        }

        System.out.println();

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
