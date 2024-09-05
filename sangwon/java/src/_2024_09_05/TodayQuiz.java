package _2024_09_05;

public class TodayQuiz {
    public static void main(String[] args) {
        // 수업중 내준 문제 다시풀기

        // 문자열내 단어 순서 뒤집기
        String str = "Hello Welcome Java";
        String[] arr = str.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        // 문자열 모든 공백 제거하기
        String str2 = "   Hello Welcome Java    ";
        String s = str2.replace(" ", "");
        System.out.println(s);

        // 문자열 "aaaabbccd" -> a4b2c2d1 나오게하기
        // 수업중 퀴즈풀이 시간안에 못 풀었던 문제
        String str3 = "aaaabbccd";
        StringBuilder str4 = new StringBuilder();
        int sum = 1;
        for (int i = 1; i < str3.length(); i++) {
            if (str3.charAt(i) == str3.charAt(i - 1)) {
                sum++;
            } else {
                str4.append(str3.charAt(i - 1)).append(sum);
                sum = 1;
            }
        }
        str4.append(str3.charAt(str3.length() - 1)).append(sum);
        System.out.println(str4);
    }
}
