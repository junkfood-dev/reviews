package _2024_08_28.chap05;

public class _05_ASCII {
    public static void main(String[] args) {
        // 아스키 코드 (ANSI)
        // 알파벳 대문자는 65부터, 소문자는 97부터, 숫자는 48부터 시작

        char c = 'A';
        System.out.println((int)c);

        c = 'B';
        System.out.println((int)c);

        c++;
        System.out.println((int)c);

        String[][] seats3 = new String[10][15];
        char ch = 'A';
        for (int i = 0; i < seats3.length; i++) {
            for (int j = 0; j < seats3[i].length; j++) {
                seats3[i][j] = String.valueOf(ch) + (j + 1);
            }
            ch++;
        }
        for (int i = 0; i < seats3.length; i++) { // 세로
            for (int j = 0; j < seats3[i].length; j++) { // 가로
                System.out.print(seats3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
